package cn.qkmango.tms.mvc.update.service.impl;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;
import cn.qkmango.tms.mvc.update.dao.UpdateSystemDao;
import cn.qkmango.tms.mvc.update.service.UpdateSystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 更新系统信息服务
 * @author qkmango
 * @version 1.0
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
