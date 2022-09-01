package cn.qkmango.tms.mvc.update.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * 更新系统信息DAO层
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:57
 */

@Mapper
public interface UpdateSystemDao {
    int updateSystemKeyValue(SystemKeyValue systemKeyValue);
}
