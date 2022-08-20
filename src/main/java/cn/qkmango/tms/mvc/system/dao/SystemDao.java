package cn.qkmango.tms.mvc.system.dao;

import cn.qkmango.tms.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemDao {
    User login(User user);

    User getUserAllInfo(User user);

    int hasUser(User user);
}
