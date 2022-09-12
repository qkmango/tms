package cn.qkmango.tms.mvc.insert.service;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;

import java.util.Locale;

/**
 * 插入系统信息服务接口
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:25
 */
public interface InsertSystemService {
    void insertSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws InsertException;
}
