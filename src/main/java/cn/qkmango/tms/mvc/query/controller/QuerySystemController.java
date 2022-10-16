package cn.qkmango.tms.mvc.query.controller;

import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.mvc.query.service.SystemQueryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 查询系统信息
 * <p>如当前学期，当前学年</p>
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-08-17 21:31
 */

@RestController
@RequestMapping("/query/system")
public class QuerySystemController {

    @Resource
    private SystemQueryService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 获取系统基本信息
     *
     * @return
     */

    @Cacheable(cacheNames="systemKV",key = "'CurrYearAndTerm'")
    @RequestMapping("/getSystemCurrYearAndTerm.do")
    public Map getSystemCurrYearAndTerm() {
        Map<String, String> systemCurrYearAndTerm = service.getSystemCurrYearAndTerm();

        ResponseMap res = new ResponseMap();
        res.setSuccess(true);
        res.setData(systemCurrYearAndTerm);

        return res;
    }

    @RequestMapping("/getSystemKeyValueList.do")
    public Map getSystemKeyValueList() {
        List<Map<String, String>> resMap = service.getSystemKeyValueList();

        ResponseMap res = new ResponseMap();
        res.setSuccess(true);
        res.setData(resMap);

        return res;
    }
}
