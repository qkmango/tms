package cn.qkmango.tms.query.insertQuery.dao;

import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.query.InsertElectiveQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InsertDao {

    int insertCourse(Course course);
    int insertCourse2(Course2 course);

    int lastInsertId();

    int insertCourseInfo(@Param("courseId") int courseId, @Param("list") List<CourseInfo> courseInfoList);

    int insertBuilding(Building building);

    int insertRoom(Room room);

    int insertYear(Year id);

    int insertElective(InsertElectiveQuery electiveVO);

    int insertTeachEvaluate(TeachEvaluate teachEvaluate);

    int insertCourseClazz(int courseId, List<Integer> clazzList);
}
