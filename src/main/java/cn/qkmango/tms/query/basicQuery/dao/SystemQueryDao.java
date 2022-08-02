package cn.qkmango.tms.query.basicQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @className: SystemQueryDao
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:41
 * @version: 1.0
 */

@Mapper
public interface SystemQueryDao {
    List<Map<String, String>> getSystemCurrYearAndTerm();

    List<Map<String, String>> getSystemKeyValueList();

    String getSystemCurrYear();

    String getSystemCurrTerm();
}
