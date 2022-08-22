package cn.qkmango.tms.mvc.insert.controller;


import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Insert.InsertRoom;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.InsertCourseParam;
import cn.qkmango.tms.domain.param.InsertElectiveParam;
import cn.qkmango.tms.mvc.insert.service.InsertService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;


/**
 * 插入数据控制器
 * <p>
 * 所有需要校验的字段都需要在字段后面跟 BindingResult result，
 * 类切面会自动拦截方法，
 * ControllerAspect 判断 result 对象中是否保存的有字段校验错误信息，如果有则直接响应给前端
 *
 * @see cn.qkmango.tms.common.aspect.ControllerAspect
 */
@RestController
@RequestMapping(value = "/insert", method = RequestMethod.POST)
public class InsertController {

    @Resource
    private InsertService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 插入课程
     * @param query
     * @param result
     * @param locale
     * @return
     * @throws InsertException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertCourse.do")
    public Map<String, Object> insertCourse(@RequestBody @Validated InsertCourseParam query,
                                            Locale locale) throws InsertException {

        service.insertCourse(query,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertCourse.success", null, locale));

        return map;
    }

    /**
     * 添加楼宇
     *
     * @param building 楼宇对象（楼号，楼名称）
     * @param result
     * @return
     * @throws InsertException
     * @validated true
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertBuilding.do")
    public Map<String, Object> insertBuilding(@Validated Building building, Locale locale) throws InsertException {

        service.insertBuilding(building, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertBuilding.success", null, locale));

        return map;
    }

    /**
     * 添加教室
     *
     * @param room
     * @return
     * @throws InsertException
     * @validated true
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertRoom.do")
    public Map<String, Object> insertRoom(@Validated(InsertRoom.class) Room room, Locale locale) throws InsertException {

        service.insertRoom(room, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertRoom.success", null, locale));

        return map;
    }

    /**
     * 添加年度
     *
     * @param year   年度
     * @param result
     * @param locale
     * @return
     * @throws InsertException
     * @validated true
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/insertYear.do")
    public Map<String, Object> insertYear(@Validated Year year, Locale locale) throws InsertException {
        service.insertYear(year, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertYear.success", null, locale));
        return map;
    }


    /**
     * 批量插入选课，学生进行选课
     *
     * @param electiveVO
     * @param session
     * @param locale
     * @return
     * @throws InsertException
     * @validated true
     */
    @Permission(PermissionType.student)
    @RequestMapping("/insertElective.do")
    public Map<String, Object> insertElective(@Validated InsertElectiveParam electiveVO,
                                              HttpSession session,
                                              Locale locale) throws InsertException {

        User user = (User) session.getAttribute("user");
        // Integer id = user.getId();

        // HashMap<String, Object> param = new HashMap<>(2);
        // param.put("studentId",id);
        // param.put("courseIds",electiveVO.getCourseIds());

        electiveVO.setStudentId(user.getId());


        service.insertElective(electiveVO, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);

        map.setMessage(messageSource.getMessage("db.insertElective.success", null, locale));
        return map;
    }


    /**
     * 添加教学评价
     */
    @Permission(PermissionType.student)
    @RequestMapping("/insertTeachEvaluate.do")
    public Map insertTeachEvaluate(@Validated TeachEvaluate teachEvaluate, HttpSession session, Locale locale) throws InsertException {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        teachEvaluate.setStudent(id);
        service.insertTeachEvaluate(teachEvaluate, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertTeachEvaluate.success", null, locale));

        return map;
    }


    @Permission(PermissionType.admin)
    @RequestMapping("/insertCalendar.do")
    public Map insertCalendar(@Validated Calendar calendar, Locale locale) throws InsertException {
        service.insertCalendar(calendar,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.insertCalendar.success", null, locale));

        return map;
    }




}
