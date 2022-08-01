package cn.qkmango.tms.query.deleteQuery.service;

import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.domain.orm.SystemKeyValue;

import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className DeleteSystemService
 * @Description TODO
 * @date 2022-07-28 17:55
 */
public interface DeleteSystemService {
    void deleteSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws DeleteException;
}
