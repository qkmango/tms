package cn.qkmango.tms.mvc.update.service;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;

import java.util.Locale;

/**
 * 更新系统信息服务接口
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:57
 */
public interface UpdateSystemService {
    void updateSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws UpdateException;
}
