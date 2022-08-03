package cn.qkmango.tms.query.basicQuery.controller;

import cn.qkmango.tms.domain.orm.Faculty;
import cn.qkmango.tms.query.basicQuery.service.ListQueryService;
import cn.qkmango.tms.query.basicQuery.service.ListTreeQueryService;
import cn.qkmango.tms.query.basicQuery.service.SystemQueryService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qkmango
 * @version 1.0
 * @className ListTreeQueryController
 * @Description 树型列表查询
 * @date 2022-08-03 14:43
 */

@RestController
@RequestMapping("/query/list/tree")
public class ListTreeQueryController {


    @Resource
    private ListQueryService listQueryService;

    @Resource
    private ListTreeQueryService listTreeQueryService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    //获取学院，专业，班级树型列表
    @RequestMapping("getClazzTreeList.do")
    public List<Faculty> getClazzTreeList() {
        List<Faculty> facultyList = listTreeQueryService.getClazzTreeList();
        return facultyList;
    }

    @RequestMapping("getTeacherTreeList.do")
    public List<Faculty> getTeacherTreeList() {
        List<Faculty> facultyList = listTreeQueryService.getTeacherTreeList();
        return facultyList;
    }

}
