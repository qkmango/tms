package cn.qkmango.tms.mvc.insert.service.impl;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;
import cn.qkmango.tms.mvc.insert.dao.InsertSystemDao;
import cn.qkmango.tms.mvc.insert.service.InsertSystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 插入系统信息服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:25
 */

@Service
public class InsertSystemServiceImpl implements InsertSystemService {


    @Resource
    private InsertSystemDao insertSystemDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws InsertException {

        int affectedRows = insertSystemDao.insertSystemKeyValue(systemKeyValue);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertSystemKeyValue.failure",null,locale));
        }
    }
}
