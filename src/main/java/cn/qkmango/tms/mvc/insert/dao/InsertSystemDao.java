package cn.qkmango.tms.mvc.insert.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qkmango
 * @version 1.0
 * @className InsertSystemDao
 * @Description TODO
 * @date 2022-07-28 19:24
 */

@Mapper
public interface InsertSystemDao {
    int insertSystemKeyValue(SystemKeyValue systemKeyValue);
}
