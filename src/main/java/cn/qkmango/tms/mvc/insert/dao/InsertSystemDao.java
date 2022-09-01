package cn.qkmango.tms.mvc.insert.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * 插入系统信息DAO层
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:24
 */

@Mapper
public interface InsertSystemDao {
    int insertSystemKeyValue(SystemKeyValue systemKeyValue);
}
