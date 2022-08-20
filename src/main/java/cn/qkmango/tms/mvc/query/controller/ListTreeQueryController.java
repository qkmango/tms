package cn.qkmango.tms.mvc.query.controller;

import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.domain.entity.Faculty;
import cn.qkmango.tms.mvc.query.service.ListQueryService;
import cn.qkmango.tms.mvc.query.service.ListTreeQueryService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getClazzTreeList() {
        List<Faculty> clazzTreeList = listTreeQueryService.getClazzTreeList();
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(true);
        map.setData(clazzTreeList);
        return map;
    }

    @RequestMapping("getTeacherTreeList.do")
    public Map<String, Object> getTeacherTreeList() {
        List<Faculty> teacherTreeList = listTreeQueryService.getTeacherTreeList();
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(true);
        map.setData(teacherTreeList);
        return map;
    }

}
