package cn.qkmango.tms.mvc.update.service.impl;

import cn.qkmango.tms.common.enumerate.RedisKey;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.Building;
import cn.qkmango.tms.domain.entity.Elective;
import cn.qkmango.tms.domain.entity.Room;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import cn.qkmango.tms.mvc.update.dao.UpdateDao;
import cn.qkmango.tms.mvc.update.service.UpdateService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateServiceImpl
 * @Description 更新修改服务
 * @date 2021-06-15
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    @Resource
    private UpdateDao updateDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(UpdatePasswordParam updatePasswordParam, Locale locale) throws PermissionException, UpdateException {
        int affectedRows = 0;

        affectedRows = updateDao.updatePassword(updatePasswordParam);

        //判断影行数
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updatePassword.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudentScore(Elective elective, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateStudentScore(elective);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateStudentScore.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBuilding(Building building, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateBuilding(building);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateBuilding.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoom(Room room, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateRoom(room);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateRoom.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateYear(Integer year,Integer newYear, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateYear(year,newYear);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateYear.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserBasicInfo(User updateUser,Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateUserBasicInfo(updateUser);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateUserBasicInfo.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRetrievePassword(RetrievePasswordParam vo, Locale locale) throws UpdateException {
        User user = vo.getUser();

        String redisKey = RedisKey.RETRIEVE_PASSWORD_CAPTCHA_PREFIX.key+":"+user.getEmail();

        String code = stringRedisTemplate.opsForValue().get(redisKey);
        if (vo.getCode().equals(code)) {
            int affectedRows = updateDao.updateRetrievePassword(user);
            if (affectedRows != 1) {
                throw new UpdateException(messageSource.getMessage("db.updatePassword.failure",null,locale));
            }
            stringRedisTemplate.delete(redisKey);
        } else {
            throw new UpdateException(messageSource.getMessage("captcha.error",null,locale));
        }
    }
}
