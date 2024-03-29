package cn.qkmango.tms.mvc.update.service.impl;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.mvc.update.dao.UpdateDao;
import cn.qkmango.tms.mvc.update.service.UpdateService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 更新修改服务
 *
 * @author qkmango
 * @version 1.0
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
    public void updateStudentScore(Elective elective, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateStudentScore(elective);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateStudentScore.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBuilding(Building building, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateBuilding(building);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateBuilding.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRoom(Room room, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateRoom(room);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateRoom.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateYear(Integer year, Integer newYear, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateYear(year, newYear);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateYear.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFaculty(Faculty faculty, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateFaculty(faculty);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateFaculty   .failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSpecialized(Specialized specialized, Locale locale) throws UpdateException {
        int affectedRows = updateDao.updateSpecialized(specialized);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateSpecialized.failure", null, locale));
        }
    }
}
