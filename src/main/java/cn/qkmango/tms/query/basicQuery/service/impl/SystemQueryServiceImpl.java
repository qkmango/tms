package cn.qkmango.tms.query.basicQuery.service.impl;

import cn.qkmango.tms.query.basicQuery.dao.SystemQueryDao;
import cn.qkmango.tms.query.basicQuery.service.SystemQueryService;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: SystemQueryServiceImpl
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:48
 * @version: 1.0
 */

@Service
public class SystemQueryServiceImpl implements SystemQueryService {

    @Resource
    private SystemQueryDao dao;

    @Override
    public Map<String, String> getSystemCurrYearAndTerm() {

        String systemCurrYear = dao.getSystemCurrYear();
        String systemCurrTerm = dao.getSystemCurrTerm();

        HashMap<String, String> map = new HashMap<>(2);
        map.put("currYear",systemCurrYear);
        map.put("currTerm",systemCurrTerm);

        return map;
    }

    @Override
    public List<Map<String, String>> getSystemKeyValueList() {
        List<Map<String, String>> infoList  = dao.getSystemKeyValueList();
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
