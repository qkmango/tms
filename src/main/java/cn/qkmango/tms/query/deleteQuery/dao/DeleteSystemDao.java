package cn.qkmango.tms.query.deleteQuery.dao;

import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qkmango
 * @version 1.0
 * @className DeleteSystemDao
 * @Description TODO
 * @date 2022-07-28 17:55
 */

@Mapper
public interface DeleteSystemDao {
    int deleteSystemKeyValue(SystemKeyValue systemKeyValue);
}
