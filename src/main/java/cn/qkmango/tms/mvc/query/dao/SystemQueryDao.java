package cn.qkmango.tms.mvc.query.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 系统信息查询DAO层
 * @author qkmango
 * @date 2021-08-17 21:41
 * @version 1.0
 */

@Mapper
public interface SystemQueryDao {
    List<Map<String, String>> getSystemCurrYearAndTerm();

    List<Map<String, String>> getSystemKeyValueList();

    String getSystemCurrYear();

    String getSystemCurrTerm();
}
