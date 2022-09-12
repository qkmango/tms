package cn.qkmango.tms.mvc.delete.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 删除
 * @author qkmango
 */
@Mapper
public interface DeleteDao {
    int deleteBuilding(Integer id);

    int deleteRoom(Integer id);

    int deleteYear(Integer year);

    int deleteElective(HashMap<String, Object> param);

    // int deleteSystemKeyValue(String key);
}
