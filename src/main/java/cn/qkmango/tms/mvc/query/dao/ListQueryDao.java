package cn.qkmango.tms.mvc.query.dao;

import cn.qkmango.tms.domain.model.OnceCourseInfo;
import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.GetCourseListParam;
import cn.qkmango.tms.domain.param.GetStudentTimetableParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列表查询DAO层
 * @author qkmango
 */

@Mapper
public interface ListQueryDao {

    int getCount();

    List<Faculty> getFacultyList();

    List<Specialized> getSpecializedList(Specialized specialized);

    List<Clazz> getClazzList(Clazz clazz);

    List<Course> getCourseList(GetCourseListParam query);

    List<Teacher> getTeacherList(Teacher teacher);

    List<Building> getBuildingList(Building building);

    List<Year> getYearList(Year year);

    List<Map> getStudentElectiveCourseList(Integer id, Boolean alreadyElective);

    List<OnceCourseInfo> getStudentTimetable(GetStudentTimetableParam query);

    /**
     * 获取信息，仅供课程表查询功能使用
     * @param studentId
     * @return
     */
    TimeTable getInfoOfTimeTable(Integer studentId);

    HashMap<String, Object> getStudentBasicInfo(Integer id);

    List<Map<String, Object>> getTeachEvaluateList(@Param("currYear") String currYear,
                                                   @Param("currTerm") String currTerm,
                                                   @Param("id") Integer id);


    List<Calendar> getSchoolCalendarList();
}
