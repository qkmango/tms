package cn.qkmango.tms.query.updateQuery.service;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.orm.SystemKeyValue;

import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateSystemService
 * @Description TODO
 * @date 2022-07-28 19:57
 */
public interface UpdateSystemService {
    void updateSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws UpdateException;
}
