package cn.qkmango.tms.query.system.dao;

import cn.qkmango.tms.domain.orm.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemDao {
    User login(User user);

    User getUserAllInfo(User user);

    int hasUser(User user);
}
