package cn.qkmango.tms.query.system.service.impl;

import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.domain.orm.User;
import cn.qkmango.tms.query.system.dao.SystemDao;
import cn.qkmango.tms.query.system.service.SystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;


@Service
public class SystemServiceImpl implements SystemService {


    @Resource
    private SystemDao dao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    public User login(User user, Locale locale) throws LoginException, PermissionException {

        User loginUser = dao.login(user);

        if (loginUser == null) {
            throw new LoginException(messageSource.getMessage("response.login.failure",null,locale));
        }

        loginUser.setPermissionType(user.getPermissionType());
        return loginUser;
    }

    @Override
    public User getUserAllInfo(User user) {
        User userAllInfo = dao.getUserAllInfo(user);
        userAllInfo.setPermissionType(user.getPermissionType());
        return userAllInfo;
    }

}
