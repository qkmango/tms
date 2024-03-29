package cn.qkmango.tms.mvc.query.controller;

import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.domain.entity.Faculty;
import cn.qkmango.tms.mvc.query.service.ListQueryService;
import cn.qkmango.tms.mvc.query.service.ListTreeQueryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.List;
import java.util.Map;

/**
 * 树型列表查询
 *
 * @author qkmango
 * @version 1.0
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


    /**
     * 获取学院，专业，班级树型列表
     *
     * @return
     */
    @Cacheable(cacheNames="@faculty@specialized@clazz",key = "'getClazzTreeList'")
    @RequestMapping("getClazzTreeList.do")
    public Map<String, Object> getClazzTreeList() {
        List<Faculty> clazzTreeList = listTreeQueryService.getClazzTreeList();
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(true);
        map.setData(clazzTreeList);
        return map;
    }

    /**
     * 获取教师树型列表
     *
     * @return
     */
    @Cacheable(cacheNames="@faculty@teacher",key = "'getTeacherTreeList'")
    @RequestMapping("getTeacherTreeList.do")
    public Map<String, Object> getTeacherTreeList() {
        List<Faculty> teacherTreeList = listTreeQueryService.getTeacherTreeList();
        ResponseMap map = new ResponseMap(2);
        map.setSuccess(true);
        map.setData(teacherTreeList);
        return map;
    }

}
