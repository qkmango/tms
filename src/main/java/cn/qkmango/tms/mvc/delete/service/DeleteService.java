package cn.qkmango.tms.mvc.delete.service;

import cn.qkmango.tms.common.exception.DeleteException;

import java.util.HashMap;
import java.util.Locale;

/**
 * 删除服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 17:55
 */
public interface DeleteService {
    void deleteBuilding(Integer id, Locale locale) throws DeleteException;

    void deleteRoom(Integer id, Locale locale) throws DeleteException;

    void deleteYear(Integer year, Locale locale) throws DeleteException;

    void deleteElective(HashMap<String, Object> param, Locale locale) throws DeleteException;

}
