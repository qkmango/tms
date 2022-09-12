package cn.qkmango.tms.mvc.delete.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * 删除系统键值对Dao
 * @author qkmango
 */
@Mapper
public interface DeleteSystemDao {
    int deleteSystemKeyValue(SystemKeyValue systemKeyValue);
}
