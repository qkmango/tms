package cn.qkmango.tms.query.insertQuery.dao;

import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.vo.InsertElectiveVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface InsertDao {

    int insertCourse(Course course);

    int lastInsertId();

    int insertCourseInfo(List<CourseInfo> courseInfoList);

    int insertBuilding(Building building);

    int insertRoom(Room room);

    int insertYear(Year id);

    int insertElective(InsertElectiveVO electiveVO);

    int insertTeachEvaluate(TeachEvaluate teachEvaluate);
}
