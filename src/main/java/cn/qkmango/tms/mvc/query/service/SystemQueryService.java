package cn.qkmango.tms.mvc.query.service;

import java.util.List;
import java.util.Map;

/**
 * 系统查询服务接口
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-08-17 21:47
 */
public interface SystemQueryService {
    Map<String, String> getSystemCurrYearAndTerm();

    List<Map<String, String>> getSystemKeyValueList();

    String getSystemCurrYear();

    String getSystemCurrTerm();


}
