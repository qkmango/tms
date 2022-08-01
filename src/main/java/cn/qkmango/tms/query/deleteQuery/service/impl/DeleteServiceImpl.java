package cn.qkmango.tms.query.deleteQuery.service.impl;

import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.query.deleteQuery.dao.DeleteDao;
import cn.qkmango.tms.query.deleteQuery.service.DeleteService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Resource
    private DeleteDao deleteDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBuilding(Integer id, Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteBuilding(id);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteBuilding.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoom(Integer id, Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteRoom(id);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteRoom.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteYear(Integer year,Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteYear(year);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteYear.failure",null,locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteElective(HashMap<String, Object> param, Locale locale) throws DeleteException {
        int affectedRows = deleteDao.deleteElective(param);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteElective.failure",null,locale));
        }
    }
}
