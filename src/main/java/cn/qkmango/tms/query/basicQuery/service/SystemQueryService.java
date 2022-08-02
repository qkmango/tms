package cn.qkmango.tms.query.basicQuery.service;

import cn.qkmango.tms.domain.orm.SystemKeyValue;

import java.util.List;
import java.util.Map;

/**
 * @className: SystemQueryService
 * @Description: 系统查询服务
 * @author: qkmango
 * @date: 2021-08-17 21:47
 * @version: 1.0
 */
public interface SystemQueryService {
    Map<String, String> getSystemCurrYearAndTerm();

    List<Map<String, String>> getSystemKeyValueList();

    String getSystemCurrYear();

    String getSystemCurrTerm();


}
