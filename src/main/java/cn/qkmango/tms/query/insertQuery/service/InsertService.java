package cn.qkmango.tms.query.insertQuery.service;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.query.InsertCourseQuery;
import cn.qkmango.tms.domain.query.InsertElectiveQuery;

import java.util.Locale;

public interface InsertService {

    void insertCourse(InsertCourseQuery query, Locale locale) throws InsertException;

    void insertBuilding(Building building,Locale locale) throws InsertException;

    void insertRoom(Room room,Locale locale) throws InsertException;

    void insertYear(Year Year,Locale locale) throws InsertException;

    void insertElective(InsertElectiveQuery electiveVO, Locale locale) throws InsertException;

    void insertTeachEvaluate(TeachEvaluate teachEvaluate, Locale locale) throws InsertException;

}
