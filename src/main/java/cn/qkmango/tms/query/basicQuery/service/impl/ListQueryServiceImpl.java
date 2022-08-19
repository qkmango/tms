package cn.qkmango.tms.query.basicQuery.service.impl;

import cn.qkmango.tms.domain.query.GetCourseListQuery;
import cn.qkmango.tms.domain.query.GetStudentTimetableQuery;
import cn.qkmango.tms.query.basicQuery.dao.ListQueryDao;
import cn.qkmango.tms.query.basicQuery.service.ListQueryService;
import cn.qkmango.tms.query.basicQuery.service.SystemQueryService;
import cn.qkmango.tms.domain.model.OnceCourseInfo;
import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.orm.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qkmango
 */
@Service
public class ListQueryServiceImpl implements ListQueryService {


    @Resource
    private ListQueryDao listQueryDao;

    @Resource
    private SystemQueryService systemQueryService;

    @Override
    public List<Faculty> getFacultyList() {
        List<Faculty> facultyList = listQueryDao.getFacultyList();
        return facultyList;
    }

    @Override
    public List<Specialized> getSpecializedList(Specialized specialized) {

        List<Specialized> specializedList = listQueryDao.getSpecializedList(specialized);

        return specializedList;
    }

    @Override
    public List<Clazz> getClazzList(Clazz clazz) {
        List<Clazz> clazzList = listQueryDao.getClazzList(clazz);

        return clazzList;
    }

    @Override
    public List<Course> getCourseList(GetCourseListQuery query) {

        List<Course> courseList = listQueryDao.getCourseList(query);

        return courseList;
    }

    @Override
    public List<Teacher> getTeacherList(Teacher teacher) {

        List<Teacher> list = listQueryDao.getTeacherList(teacher);
        return list;
    }

    @Override
    public List<Building> getBuildingList(Building building) {

        List<Building> list = listQueryDao.getBuildingList(building);

        return list;
    }

    @Override
    public List<Year> getYearList(Year year) {
        List<Year> list = listQueryDao.getYearList(year);
        return list;
    }

    @Override
    public List<Map> getStudentElectiveCourseList(Integer id, Boolean alreadyElective) {
        List<Map> list = listQueryDao.getStudentElectiveCourseList(id, alreadyElective);
        return list;
    }

    @Override
    public TimeTable getStudentTimetable(GetStudentTimetableQuery query) {

        List<OnceCourseInfo> list = listQueryDao.getStudentTimetable(query);
        TimeTable timeTable = listQueryDao.getInfoOfTimeTable(query.getId());

        // TimeTable timeTable = new TimeTable();

        timeTable.setList(list);
        timeTable.setStudentId(query.getId());
        timeTable.setYear(query.getYear());
        timeTable.setTerm(query.getTerm());
        return timeTable;
    }


    @Override
    public HashMap<String, Object> getStudentBasicInfo(Integer id) {

        HashMap<String, Object> basicInfo = listQueryDao.getStudentBasicInfo(id);

        return basicInfo;
    }

    @Override
    public List<Map<String, Object>> getTeachEvaluateList(Integer id) {

        Map<String, String> systemCurrYearAndTerm = systemQueryService.getSystemCurrYearAndTerm();
        String currYear = systemCurrYearAndTerm.get("currYear");
        String currTerm = systemCurrYearAndTerm.get("currTerm");

        List<Map<String, Object>> resList = listQueryDao.getTeachEvaluateList(currYear,currTerm, id);

        return resList;
    }


}
