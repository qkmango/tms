package cn.qkmango.tms.mvc.common.service.impl;

import cn.qkmango.tms.common.enumerate.RedisKey;
import cn.qkmango.tms.common.exception.DatabaseOperateException;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.common.utils.CaptchaUtil;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import cn.qkmango.tms.mvc.common.service.EmailService;
import cn.qkmango.tms.mvc.common.dao.CommonDao;
import cn.qkmango.tms.mvc.common.service.CommonService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * 公共服务
 * @author qkmango
 * @version 1.0
 * @date 2022-08-20 20:13
 */

@Service
public class CommonServiceImpl implements CommonService {

    @Resource
    private CommonDao dao;

    @Resource
    private EmailService emailService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    public User login(User user, Locale locale) throws LoginException, PermissionException {
        User loginUser = dao.login(user);
        if (loginUser == null) {
            throw new LoginException(messageSource.getMessage("response.login.failure",null,locale));
        }

        loginUser.setPermissionType(user.getPermissionType());
        return loginUser;
    }


    @Override
    public User getUseDetailInfo(User user) {
        User userAllInfo = dao.getUseDetailInfo(user);
        userAllInfo.setPermissionType(user.getPermissionType());
        return userAllInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(UpdatePasswordParam updatePasswordParam, Locale locale) throws PermissionException, UpdateException {
        int affectedRows = 0;

        affectedRows = dao.updatePassword(updatePasswordParam);

        //判断影行数
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updatePassword.failure",null,locale));
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRetrievePassword(RetrievePasswordParam vo, Locale locale) throws UpdateException {
        User user = vo.getUser();

        String redisKey = RedisKey.RETRIEVE_PASSWORD_CAPTCHA_PREFIX.key+":"+user.getEmail();

        String code = stringRedisTemplate.opsForValue().get(redisKey);
        if (vo.getCode().equals(code)) {
            int affectedRows = dao.updateRetrievePassword(user);
            if (affectedRows != 1) {
                throw new UpdateException(messageSource.getMessage("db.updatePassword.failure",null,locale));
            }
            stringRedisTemplate.delete(redisKey);
        } else {
            throw new UpdateException(messageSource.getMessage("captcha.error",null,locale));
        }
    }


    @Override
    public void sendRetrievePasswordCaptcha(User user, Locale locale) throws Exception {
        boolean hasUser = hasUser(user);
        if (!hasUser) {
            throw new DatabaseOperateException(messageSource.getMessage("db.hasUser.failure",null,locale));
        }

        String captchaCode = CaptchaUtil.getCode();
        //发送邮件验证码
        emailService.sendMessage(user.getEmail(),"教务系统找回密码","验证码为【"+captchaCode+"】, 有效期为5分钟");

        //验证码写入 redis
        //邮箱地址-验证码写入redis，有效期为 300 秒(5分钟)
        //redisKey示例 "RetrievePasswordCaptcha:123@qq.com"
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String redisKey = RedisKey.RETRIEVE_PASSWORD_CAPTCHA_PREFIX.key+":"+user.getEmail();
        ops.set(redisKey, captchaCode,300, TimeUnit.SECONDS);
    }


    @Override
    public boolean hasUser(User user) {
        int affectedRows = dao.hasUser(user);
        if (affectedRows != 1) {
            return false;
        }
        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserBasicInfo(User updateUser,Locale locale) throws UpdateException {
        int affectedRows = dao.updateUserBasicInfo(updateUser);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateUserBasicInfo.failure",null,locale));
        }
    }


}
