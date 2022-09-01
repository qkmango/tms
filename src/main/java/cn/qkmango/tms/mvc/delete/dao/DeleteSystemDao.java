package cn.qkmango.tms.mvc.delete.dao;

import cn.qkmango.tms.domain.entity.SystemKeyValue;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DeleteSystemDao {
    int deleteSystemKeyValue(SystemKeyValue systemKeyValue);
}
