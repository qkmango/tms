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
 * 系统信息查询服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-08-17 21:48
 */

@Service
public class SystemQueryServiceImpl implements SystemQueryService {

    @Resource
    private SystemQueryDao dao;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, String> getSystemCurrYearAndTerm() {

        String currYear = dao.getSystemCurrYear();
        String currTerm = dao.getSystemCurrTerm();

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
