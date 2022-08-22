package cn.qkmango.tms.mvc.insert.dao;

import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.InsertElectiveParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
