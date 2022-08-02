package cn.qkmango.tms.query.system.service;

import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.domain.orm.User;

import java.util.Locale;

public interface SystemService {

    User login(User user, Locale locale) throws LoginException, PermissionException;

    User getUserAllInfo(User user);

    void sendRetrievePasswordCaptcha(User user, Locale locale) throws Exception;

    boolean hasUser(User user);
}
