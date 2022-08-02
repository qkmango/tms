package cn.qkmango.tms.query.system.service.impl;

import cn.qkmango.tms.common.exception.DatabaseOperateException;
import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.utils.CaptchaUtil;
import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.email.service.EmailService;
import cn.qkmango.tms.query.system.dao.SystemDao;
import cn.qkmango.tms.query.system.service.SystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


@Service
public class SystemServiceImpl implements SystemService {


    @Resource
    private SystemDao dao;

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
    public User getUserAllInfo(User user) {
        User userAllInfo = dao.getUserAllInfo(user);
        userAllInfo.setPermissionType(user.getPermissionType());
        return userAllInfo;
    }

    @Override
    public void sendRetrievePasswordCaptcha(User user, Locale locale) throws Exception {
        boolean hasUser = hasUser(user);
        if (!hasUser) {
            throw new DatabaseOperateException(messageSource.getMessage("db.hasUser.failure",null,locale));
        }

        String captchaCode = CaptchaUtil.getCode();

        emailService.sendMessage(user.getEmail(),"教务系统找回密码","验证码为【"+captchaCode+"】, 有效期为5分钟");

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //邮箱地址-验证码写入redis，有效期为 300 秒(5分钟)
        ops.set(user.getEmail(), captchaCode,300, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasUser(User user) {
        int affectedRows = dao.hasUser(user);
        if (affectedRows != 1) {
            return false;
        }
        return true;
    }

}
