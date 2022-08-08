package cn.qkmango.tms.query.updateQuery.service.impl;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import cn.qkmango.tms.query.updateQuery.dao.UpdateSystemDao;
import cn.qkmango.tms.query.updateQuery.service.UpdateSystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateSystemServiceImpl
 * @Description 更新系统信息
 * @date 2022-07-28 19:57
 */

@Service
public class UpdateSystemServiceImpl implements UpdateSystemService {

    @Resource
    private UpdateSystemDao dao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws UpdateException {
        int affectedRows = dao.updateSystemKeyValue(systemKeyValue);
        if (affectedRows != 1) {
            throw new UpdateException(messageSource.getMessage("db.updateSystemKeyValue.failure",null,locale));
        }
    }
}
