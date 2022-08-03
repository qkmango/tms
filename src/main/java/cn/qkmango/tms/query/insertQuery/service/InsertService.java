package cn.qkmango.tms.query.insertQuery.service;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.model.CourseInfoModel;
import cn.qkmango.tms.domain.model.CourseInfoModel2;
import cn.qkmango.tms.domain.orm.*;
import cn.qkmango.tms.domain.vo.InsertElectiveVO;

import java.util.List;
import java.util.Locale;

public interface InsertService {
    void insertCourse(Course course, CourseInfoModel courseInfoModel, Locale locale) throws InsertException;

    void insertBuilding(Building building,Locale locale) throws InsertException;

    void insertRoom(Room room,Locale locale) throws InsertException;

    void insertYear(Year Year,Locale locale) throws InsertException;

    void insertElective(InsertElectiveVO electiveVO, Locale locale) throws InsertException;

    void insertTeachEvaluate(TeachEvaluate teachEvaluate, Locale locale) throws InsertException;

    void insertCourse2(Course2 course, CourseInfoModel2 courseInfoModel, List<Integer> clazzList, Locale locale) throws InsertException;
}
