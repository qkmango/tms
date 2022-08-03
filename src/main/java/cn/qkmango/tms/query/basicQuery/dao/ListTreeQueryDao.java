package cn.qkmango.tms.query.basicQuery.dao;

import cn.qkmango.tms.domain.orm.Clazz;
import cn.qkmango.tms.domain.orm.Specialized;
import cn.qkmango.tms.domain.orm.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author qkmango
 * @version 1.0
 * @className ListTreeQueryDao
 * @Description TODO
 * @date 2022-08-03 14:45
 */

@Mapper
public interface ListTreeQueryDao {
    List<Specialized> getSpecializedListByFacultyId(Integer faculty);

    List<Clazz> getClazzListBySpecializedId(Integer specialized);

    List<Teacher> getTeacherListByFacultyId(Integer faculty);
}
