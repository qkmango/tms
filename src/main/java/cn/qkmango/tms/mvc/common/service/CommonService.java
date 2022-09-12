package cn.qkmango.tms.mvc.common.service;

import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;

import java.util.Locale;

/**
 * 公共服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-20 20:13
 */
public interface CommonService {
    User login(User user, Locale locale) throws LoginException, PermissionException;

    User getUseDetailInfo(User user);

    void updatePassword(UpdatePasswordParam updatePasswordParam, Locale locale) throws PermissionException, UpdateException;

    void updateRetrievePassword(RetrievePasswordParam vo, Locale locale) throws UpdateException;

    void sendRetrievePasswordCaptcha(User user, Locale locale) throws Exception;

    boolean hasUser(User user);

    void updateUserBasicInfo(User updateUser, Locale locale) throws UpdateException;

}
