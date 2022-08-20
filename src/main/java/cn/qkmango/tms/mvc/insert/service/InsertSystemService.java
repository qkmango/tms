package cn.qkmango.tms.mvc.insert.service;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;

import java.util.Locale;

/**
 * @author qkmango
 * @version 1.0
 * @className InsertSystemService
 * @Description TODO
 * @date 2022-07-28 19:25
 */
public interface InsertSystemService {
    void insertSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws InsertException;
}
