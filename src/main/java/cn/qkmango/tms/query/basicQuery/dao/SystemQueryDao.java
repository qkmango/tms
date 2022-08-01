package cn.qkmango.tms.query.basicQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: SystemQueryDao
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-08-17 21:41
 * @version: 1.0
 */

@Mapper
public interface SystemQueryDao {
    List<SystemKeyValue> getSystemCurrYearAndTerm();

    List<SystemKeyValue> getSystemKeyValueList();
}
