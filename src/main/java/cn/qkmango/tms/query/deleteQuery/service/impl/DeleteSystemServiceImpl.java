package cn.qkmango.tms.query.deleteQuery.service.impl;

import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.query.deleteQuery.dao.DeleteSystemDao;
import cn.qkmango.tms.query.deleteQuery.service.DeleteSystemService;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className DeleteSystemServiceImpl
 * @Description TODO
 * @date 2022-07-28 17:55
 */

@Service
public class DeleteSystemServiceImpl implements DeleteSystemService {

    @Resource
    private DeleteSystemDao dao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws DeleteException {
        int affectedRows = dao.deleteSystemKeyValue(systemKeyValue);
        if (affectedRows != 1) {
            throw new DeleteException(messageSource.getMessage("db.deleteSystemKeyValue.failure",null,locale));
        }
    }
}
