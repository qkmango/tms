package cn.qkmango.tms.query.basicQuery.controller;

import cn.qkmango.tms.query.basicQuery.service.PaginationQueryService;
import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * @author qkmango
 *
 * 提供分页的查询和不分页的查询
 *
 */
@RestController
@RequestMapping("/query/pagination")
public class PaginationQueryController {

    @Resource
    private PaginationQueryService paginationQueryService;


    /**
     * 获取学生成绩列表分页
     * @return
     */
    // @Permission({PermissionType.admin,PermissionType.teacher})
    @RequestMapping("/getStudentScorePagination.do")
    public Map<String, Object> getStudentScorePagination(StudentScorePagination pagination, HttpSession session) {

        //判断当前用户，如果是学生的话，传入ID，仅可以查询自己的成绩
        User user = (User) session.getAttribute("user");
        if (PermissionType.student == user.getPermissionType()) {
            pagination.setId(user.getId());
        }

        HashMap<String,Object> map = paginationQueryService.getStudentScorePagination(pagination);



        map.put("success",true);
        map.put("message","获取学生成绩分页列表成功");

        return map;
    }

    /**
     * 条件获取教室列表 分页
     * @param pagination
     * @return
     */
    @Permission(PermissionType.admin)
    @RequestMapping("/getRoomPagination.do")
    public Map<String, Object> getRoomPagination(RoomPagination pagination) {

        HashMap<String,Object> map = paginationQueryService.getRoomPagination(pagination);

        // ResponseMap map = new ResponseMap();
        map.put("success",true);
        map.put("message","获取教室列表成功");

        return map;
    }



}
