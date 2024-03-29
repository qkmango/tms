package cn.qkmango.tms.mvc.delete.service;

import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.domain.entity.SystemKeyValue;

import java.util.Locale;

/**
 * 删除系统信息对服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 17:55
 */
public interface DeleteSystemService {
    void deleteSystemKeyValue(SystemKeyValue systemKeyValue, Locale locale) throws DeleteException;
}
