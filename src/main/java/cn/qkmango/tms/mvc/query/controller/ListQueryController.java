package cn.qkmango.tms.mvc.query.controller;

import cn.qkmango.tms.domain.param.GetCourseListParam;
import cn.qkmango.tms.domain.param.GetStudentTimetableParam;
import cn.qkmango.tms.mvc.query.service.ListQueryService;
import cn.qkmango.tms.mvc.query.service.SystemQueryService;
import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.model.TimeTable;
import cn.qkmango.tms.domain.entity.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qkmango
 * @version 1.0
 * @className ListQueryController
 * @Description 仅提供列表查询，不提供分页
 * @date 2022-07-31 19:26
 */
@RestController
@RequestMapping("/query/list")
public class ListQueryController {


    @Resource
    private ListQueryService listQueryService;

    @Resource
    private SystemQueryService systemQueryService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 查询院系列表
     * @return
     */
    @RequestMapping("/getFacultyList.do")
    public Map<String, Object> getFacultyList() {

        List<Faculty> facultyList = listQueryService.getFacultyList();

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(facultyList);

        return map;
    }

    /**
     * 条件查询专业列表
     * @return
     */
    @RequestMapping("/getSpecializedList.do")
    public Map<String, Object> getSpecializedList(Specialized specialized) {

        List<Specialized> specializedList = listQueryService.getSpecializedList(specialized);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(specializedList);

        return map;
    }


    /**
     * 查询指定专业的所有班级
     * teacher 角色 在使用学生成绩修改模块时，条件查询时获取下拉列表使用的
     * Map接收的参数有
     *      faculty     表示院系的id，数据库中存储的为 int类型，但是前端请求的是 String类型
     *      courseYear  学科开设的年份
     *      term        学科开设的学期
     *      clazzYear   班级年级（如2020级）
     * @return
     */
    @RequestMapping("/getClazzList.do")
    public Map<String, Object> getClazzList(Clazz clazz) {

        List<Clazz> clazzList = listQueryService.getClazzList(clazz);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(clazzList);

        return map;
    }

    /**
     * 获取指定的老师和班级的 科目列表
     * @param query 查询条件
     * @return
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("/getCourseList.do")
    public Map<String, Object> getCourseList(GetCourseListParam query, HttpSession session) {

        // User user = (User)session.getAttribute("user");

        List<Course> courseList = listQueryService.getCourseList(query);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(courseList);

        return map;
    }

    @RequestMapping("/getTeacherList.do")
    public Map<String, Object> getTeacherList(Teacher teacher) {

        List<Teacher> data = listQueryService.getTeacherList(teacher);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }

    /**
     * 条件获取 楼 列表（不分页）
     * @param building
     * @return
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/getBuildingList.do")
    public Map<String, Object> getBuildingList(Building building) {

        List<Building> data = listQueryService.getBuildingList(building);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 条件获取 年份 列表
     * @param year
     * @return
     */
    @RequestMapping("/getYearList.do")
    public Map<String, Object> getYearList(Year year) {

        List<Year> data = listQueryService.getYearList(year);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }

    /**
     * 获取 当前学生选课列表（）包括已选和未选的课程
     * @param alreadyElective 是否已选（true，false，null）
     * @param session
     * @return
     */
    @RequestMapping("/getStudentElectiveCourseList.do")
    public Map<String, Object> getStudentElectiveCourseList(Boolean alreadyElective, HttpSession session) {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        List<Map> data = listQueryService.getStudentElectiveCourseList(id,alreadyElective);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 获取学生课表
     * @param session
     * @return
     */
    @RequestMapping("/getStudentTimetable.do")
    public Map<String,Object> getStudentTimetable(@Validated GetStudentTimetableParam query, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer studentId = user.getId();

        query.setId(studentId);

        TimeTable data = listQueryService.getStudentTimetable(query);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(data);

        return map;
    }


    /**
     * 获取学生基本信息
     * @param session
     * @return
     */
    @RequestMapping("/getStudentBasicInfo.do")
    public Map<String,Object> getStudentBasicInfo(HttpSession session) {
        HashMap<String, Object> basicInfo = (HashMap<String, Object>) session.getAttribute("basicInfo");

        if (basicInfo == null) {
            User user = (User) session.getAttribute("user");
            basicInfo = listQueryService.getStudentBasicInfo(user.getId());
            session.setAttribute("basicInfo",basicInfo);
        }

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setData(basicInfo);

        return map;
    }


    /**
     * 获得教学评价列表
     * @param session
     * @return
     */
    @RequestMapping("/getTeachEvaluateList.do")
    public Map<String, Object> getTeachEvaluateList(HttpSession session) {

        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        List<Map<String, Object>> list = listQueryService.getTeachEvaluateList(id);

        ResponseMap map = new ResponseMap();

        map.setSuccess(true);
        map.setData(list);

        return map;

    }


}
