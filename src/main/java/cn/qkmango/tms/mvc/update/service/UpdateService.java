package cn.qkmango.tms.mvc.update.service;

import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.*;

import java.util.Locale;

/**
 * 更细服务接口
 *
 * @author qkmango
 */
public interface UpdateService {

    void updateStudentScore(Elective elective, Locale locale) throws UpdateException;

    void updateBuilding(Building building, Locale locale) throws UpdateException;

    void updateRoom(Room room, Locale locale) throws UpdateException;

    void updateYear(Integer year, Integer newYear, Locale locale) throws UpdateException;


    void updateFaculty(Faculty faculty, Locale locale) throws UpdateException;

    void updateSpecialized(Specialized specialized, Locale locale) throws UpdateException;
}
