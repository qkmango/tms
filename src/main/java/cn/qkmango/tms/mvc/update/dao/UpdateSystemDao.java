package cn.qkmango.tms.mvc.update.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateSystemDao
 * @Description TODO
 * @date 2022-07-28 19:57
 */

@Mapper
public interface UpdateSystemDao {
    int updateSystemKeyValue(SystemKeyValue systemKeyValue);
}