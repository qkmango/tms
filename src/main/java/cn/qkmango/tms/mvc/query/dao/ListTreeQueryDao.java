package cn.qkmango.tms.mvc.query.dao;

import cn.qkmango.tms.domain.entity.Clazz;
import cn.qkmango.tms.domain.entity.Specialized;
import cn.qkmango.tms.domain.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 树型列表查询DAO层
 * @author qkmango
 * @version 1.0
 * @date 2022-08-03 14:45
 */

@Mapper
public interface ListTreeQueryDao {
    List<Specialized> getSpecializedListByFacultyId(Integer faculty);

    List<Clazz> getClazzListBySpecializedId(Integer specialized);

    List<Teacher> getTeacherListByFacultyId(Integer faculty);
}
