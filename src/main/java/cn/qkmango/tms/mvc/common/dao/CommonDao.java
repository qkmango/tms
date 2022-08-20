package cn.qkmango.tms.mvc.common.dao;

import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qkmango
 * @version 1.0
 * @className CommonDao
 * @Description 公共服务
 * @date 2022-08-20 20:13
 */
@Mapper
public interface CommonDao {
    User login(User user);

    User getUseDetailInfo(User user);

    int updatePassword(UpdatePasswordParam updatePasswordParam);

    int updateRetrievePassword(User user);

    int hasUser(User user);

    int updateUserBasicInfo(User updateUser);
}
