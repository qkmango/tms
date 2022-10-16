package cn.qkmango.tms.mvc.insert.dao;

import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.InsertElectiveParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 插入信息DAO层
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:24
 */
@Mapper
public interface InsertDao {

    int insertCourse(Course course);

    int lastInsertId();

    int insertCourseInfo(@Param("courseId") int courseId, @Param("list") List<CourseInfo> courseInfoList);

    int insertBuilding(Building building);

    int insertRoom(Room room);

    int insertYear(Year id);

    int insertElective(InsertElectiveParam electiveVO);

    int insertTeachEvaluate(TeachEvaluate teachEvaluate);

    int insertCourseClazz(int courseId, List<Integer> clazzList);

    int insertCalendar(Calendar calendar);

    int insertFaculty(Faculty faculty);

    int insertSpecialized(Specialized specialized);
}
