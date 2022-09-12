package cn.qkmango.tms.mvc.query.service;

import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.param.GetCourseListParam;
import cn.qkmango.tms.domain.param.GetStudentTimetableParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表查询服务接口
 *
 * @author qkmango
 */
public interface ListQueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedList(Specialized specialized);

    List<Clazz> getClazzList(Clazz clazz);

    List<Course> getCourseList(GetCourseListParam query);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<Year> getYearList(Year year);

    List<Map> getStudentElectiveCourseList(Integer id, Boolean alreadyElective);

    TimeTable getStudentTimetable(GetStudentTimetableParam query);

    HashMap<String, Object> getStudentBasicInfo(Integer id);

    List<Map<String, Object>> getTeachEvaluateList(Integer id);

    List<Calendar> getSchoolCalendarList();
}
