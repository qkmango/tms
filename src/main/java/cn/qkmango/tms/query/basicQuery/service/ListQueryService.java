package cn.qkmango.tms.query.basicQuery.service;

import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.query.GetStudentTimetableQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ListQueryService {

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedList(Specialized specialized);

    List<Clazz> getClazzList(Clazz clazz);

    List<Course> getCourseListByTeacherAndClazz(HashMap<String, Integer> paramsMap);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<Year> getYearList(Year year);

    List<Map> getStudentElectiveCourseList(HashMap<String, Object> params);

    TimeTable getStudentTimetable(GetStudentTimetableQuery query);

    HashMap<String, Object> getStudentBasicInfo(Integer id);

    List<Map<String, Object>> getTeachEvaluateList(Integer id);
}
