package cn.qkmango.tms.mvc.update.controller;


import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.common.validate.group.Update.UpdateStudentScore;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.entity.Building;
import cn.qkmango.tms.domain.entity.Elective;
import cn.qkmango.tms.domain.entity.Room;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import cn.qkmango.tms.mvc.update.service.UpdateService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateController
 * @Description 更新修改控制器
 * @date 2021-06-15
 */
@RestController
@RequestMapping(value="/update",method = RequestMethod.POST)
public class UpdateController {

    @Resource
    private UpdateService updateService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    /**
     * 更改用户密码
     * @param session
     * @param updatePasswordParam
     * @param locale
     * @return
     * @throws PermissionException
     * @throws UpdateException
     */
    // @Permission
    @RequestMapping("/updatePassword.do")
    public Map<String, Object> updatePassword(HttpSession session,
                                              UpdatePasswordParam updatePasswordParam,
                                              Locale locale) throws PermissionException, UpdateException {

        //获取用户ID
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        //获取用户权限类型
        PermissionType thisUserPermissionType = user.getPermissionType();

        updatePasswordParam.setId(id);
        updatePasswordParam.setPermissionType(thisUserPermissionType);

        updateService.updatePassword(updatePasswordParam,locale);

        ResponseMap map = new ResponseMap();

        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updatePassword.success",null,locale));

        return map;
    }

    /**
     * 更新学生成绩
     * @Validated true
     * @param elective
     * @param result
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("updateStudentScore.do")
    public Map<String, Object> updateStudentScore(@Validated(UpdateStudentScore.class) Elective elective,
                                                  BindingResult result,
                                                  Locale locale) throws UpdateException {

        updateService.updateStudentScore(elective,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateStudentScore.success",null,locale));

        return map;
    }

    /**
     * 更新楼宇信息
     * @Validated false
     * @param building
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateBuilding.do")
    public Map<String, Object> updateBuilding(@Validated Building building, BindingResult result, Locale locale) throws UpdateException {

        updateService.updateBuilding(building, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateBuilding.success",null,locale));

        return map;
    }

    /**
     * 修改 教室信息
     * @validated true
     * @param room
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateRoom.do")
    public Map<String, Object> updateRoom(@Validated(Update.class) Room room, BindingResult result, Locale locale) throws UpdateException {

        updateService.updateRoom(room,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateRoom.success",null,locale));

        return map;
    }


    /**
     * 更新修改 年份
     * @Validated false
     * @param year
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateYear.do")
    public Map<String, Object> updateYear(Integer year,Integer newYear,Locale locale) throws UpdateException {

        updateService.updateYear(year,newYear,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateYear.success",null,locale));

        return map;
    }

    @PostMapping("updateUserBasicInfo.do")
    public Map<String, Object> updateUserBasicInfo(HttpSession session,
                                                   @Validated(Update.UpdateUserBasicInfo.class)
                                                   User updateUser,
                                                   BindingResult result,
                                                   Locale locale) throws UpdateException {

        User user = (User) session.getAttribute("user");
        updateUser.setId(user.getId());
        updateUser.setPermissionType(user.getPermissionType());

        updateService.updateUserBasicInfo(updateUser,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateUserBasicInfo.success",null,locale));

        return map;

    }

    /**
     * 找回密码更新
     * @param session
     * @param vo
     * @param locale
     * @return
     * @throws UpdateException
     */
    @PostMapping("updateRetrievePassword.do")
    public Map<String, Object> updateRetrievePassword(HttpSession session,
                                                   @Validated RetrievePasswordParam vo,
                                                   BindingResult result,
                                                   Locale locale) throws UpdateException {

        updateService.updateRetrievePassword(vo,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updatePassword.success",null,locale));

        return map;

    }




}
