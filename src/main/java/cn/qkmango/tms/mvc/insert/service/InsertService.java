package cn.qkmango.tms.mvc.insert.service;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.InsertCourseParam;
import cn.qkmango.tms.domain.param.InsertElectiveParam;

import java.util.Locale;

public interface InsertService {

    void insertCourse(InsertCourseParam query, Locale locale) throws InsertException;

    void insertBuilding(Building building,Locale locale) throws InsertException;

    void insertRoom(Room room,Locale locale) throws InsertException;

    void insertYear(Year Year,Locale locale) throws InsertException;

    void insertElective(InsertElectiveParam electiveVO, Locale locale) throws InsertException;

    void insertTeachEvaluate(TeachEvaluate teachEvaluate, Locale locale) throws InsertException;

    void insertCalendar(Calendar calendar, Locale locale) throws InsertException;
}
