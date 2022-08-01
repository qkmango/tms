package cn.qkmango.tms.query.updateQuery.service.impl;

import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.orm.Building;
import cn.qkmango.tms.domain.orm.Elective;
import cn.qkmango.tms.domain.orm.Room;
import cn.qkmango.tms.domain.vo.UpdatePasswordVO;
import cn.qkmango.tms.query.updateQuery.dao.UpdateDao;
import cn.qkmango.tms.query.updateQuery.service.UpdateService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Resource
    private UpdateDao updateDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(UpdatePasswordVO updatePasswordVO, Locale locale) throws PermissionException, UpdateException {
        int affectedRows = 0;

        affectedRows = updateDao.updatePassword(updatePasswordVO);

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
}
