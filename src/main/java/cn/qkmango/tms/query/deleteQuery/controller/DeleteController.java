package cn.qkmango.tms.query.deleteQuery.controller;


import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.query.deleteQuery.service.DeleteService;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.User;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping(value = "/delete",method = RequestMethod.POST)
public class DeleteController {

    @Resource
    private DeleteService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteBuilding.do")
    public Map<String, Object> deleteBuilding(Integer id, Locale locale) throws DeleteException {

        service.deleteBuilding(id,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteBuilding.success",null,locale));

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteRoom.do")
    public Map<String, Object> deleteRoom(Integer id, Locale locale) throws DeleteException {

        service.deleteRoom(id,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteRoom.success",null,locale));

        return map;
    }

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteYear.do")
    public Map<String, Object> deleteYear(Integer year,Locale locale) throws DeleteException {

        service.deleteYear(year,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteYear.success",null,locale));

        return map;
    }

    /**
     * 删除选课，删除学生已经选择的课程
     * @param courseId
     * @param session
     * @param locale
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.student)
    @RequestMapping("/deleteElective.do")
    public Map<String, Object> deleteElective(Integer courseId, HttpSession session, Locale locale) throws DeleteException {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        HashMap<String, Object> param = new HashMap<>(2);
        param.put("studentId",id);
        param.put("courseId",courseId);

        service.deleteElective(param,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.deleteElective.success",null,locale));
        return map;
    }



}
