package cn.qkmango.tms.insertQuery.service;

import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.model.CourseInfoModel;

import java.util.HashMap;
import java.util.Locale;

public interface InsertService {
    void insertCourse(Course course, CourseInfoModel courseInfoModel, Locale locale) throws InsertException;

    void insertBuilding(Building building,Locale locale) throws InsertException;

    void insertRoom(Room room,Locale locale) throws InsertException;

    void insertYear(Year Year,Locale locale) throws InsertException;

    void insertElective(HashMap<String, Object> param, Locale locale) throws InsertException;

    void insertTeachEvaluate(TeachEvaluate teachEvaluate, Locale locale) throws InsertException;
}
