package cn.qkmango.tms.query.deleteQuery.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;


@Mapper
public interface DeleteDao {
    int deleteBuilding(Integer id);

    int deleteRoom(Integer id);

    int deleteYear(Integer year);

    int deleteElective(HashMap<String, Object> param);

    // int deleteSystemKeyValue(String key);
}
