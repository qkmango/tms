package cn.qkmango.tms.mvc.update.service;

import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.Building;
import cn.qkmango.tms.domain.entity.Elective;
import cn.qkmango.tms.domain.entity.Room;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;

import java.util.Locale;

public interface UpdateService {

    void updatePassword(UpdatePasswordParam updatePasswordParam, Locale locale) throws PermissionException, UpdateException;

    void updateStudentScore(Elective elective, Locale locale) throws UpdateException;

    void updateBuilding(Building building, Locale locale) throws UpdateException;

    void updateRoom(Room room, Locale locale) throws UpdateException;

    void updateYear(Integer year,Integer newYear, Locale locale) throws UpdateException;

    void updateUserBasicInfo(User updateUser,Locale locale) throws UpdateException;

    void updateRetrievePassword(RetrievePasswordParam vo, Locale locale) throws UpdateException;
}
