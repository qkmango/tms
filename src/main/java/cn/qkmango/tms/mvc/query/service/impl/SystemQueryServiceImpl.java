package cn.qkmango.tms.mvc.query.service.impl;

import cn.qkmango.tms.mvc.query.dao.SystemQueryDao;
import cn.qkmango.tms.mvc.query.service.SystemQueryService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: SystemQueryServiceImpl
 * @Description: 系统查询
 * @author: qkmango
 * @date: 2021-08-17 21:48
 * @version: 1.0
 */

@Service
public class SystemQueryServiceImpl implements SystemQueryService {

    @Resource
    private SystemQueryDao dao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, String> getSystemCurrYearAndTerm() {

        String currYear = stringRedisTemplate.opsForValue().get("currYear");
        String currTerm = stringRedisTemplate.opsForValue().get("currTerm");

        if (currYear == null) {
            currYear = dao.getSystemCurrYear();
            stringRedisTemplate.opsForValue().set("currYear",currYear);
        }
        if(currTerm == null) {
            currTerm = dao.getSystemCurrTerm();
            stringRedisTemplate.opsForValue().set("currTerm",currTerm);
        }

        HashMap<String, String> map = new HashMap<>(2);
        map.put("currYear", currYear);
        map.put("currTerm", currTerm);

        return map;
    }

    @Override
    public List<Map<String, String>> getSystemKeyValueList() {
        List<Map<String, String>> infoList = dao.getSystemKeyValueList();
        return infoList;
    }

    @Override
    public String getSystemCurrYear() {
        return dao.getSystemCurrYear();
    }

    @Override
    public String getSystemCurrTerm() {
        return dao.getSystemCurrTerm();
    }
}
