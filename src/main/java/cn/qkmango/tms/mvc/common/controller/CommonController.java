package cn.qkmango.tms.mvc.common.controller;

import cn.qkmango.tms.common.exception.LoginException;
import cn.qkmango.tms.common.exception.PermissionException;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Query;
import cn.qkmango.tms.common.validate.group.Sys;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.RetrievePasswordParam;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import cn.qkmango.tms.mvc.common.service.CommonService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author qkmango
 * @version 1.0
 * @className CommonController
 * @Description 所有用户公共的接口
 * 如登陆更新密码，找回密码，发送验证码 等
 * @date 2022-08-20 11:01
 */

@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Resource
    private CommonService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * @param request
     * @param user 户信息，前端传来参数：id，password
     * @return
     * @throws LoginException
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public Map<String, Object> login(@Validated(Query.login.class) User user, BindingResult result, HttpServletRequest request, Locale locale) throws LoginException, PermissionException {

        User loginUser = service.login(user,locale);

        request.getSession(true).setAttribute("user", loginUser);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("response.login.success",null,locale));

        return map;
    }


    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout.do",method = RequestMethod.POST)
    public Map<String, Object> logout(HttpServletRequest request) {
        request.getSession().invalidate();

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("message", "退出成功！");
        return map;
    }


    @RequestMapping("/test.do")
    public Map test(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user;
        if (session == null) {
            user = new User(1,null,"芒果小洛",null, PermissionType.student);
            request.getSession(true).setAttribute("user",user);
        } else {
            user = (User)request.getSession().getAttribute("user");
            if (user == null) {
                user = new User(1,null,"芒果小洛",null,PermissionType.student);
                request.getSession(true).setAttribute("user",user);
            }
        }

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.put("user",user);

        return map;
    }


    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserInfo.do")
    public Map<String, Object> getUserInfo(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        HashMap<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("user", user);
        return map;
    }

    /**
     * 获取用户详细信息
     * @param request
     * @return
     */
    @RequestMapping("/getUseDetailInfo.do")
    public Map<String, Object> getUserAllInfo(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");

        User userAllInfo = service.getUseDetailInfo(user);

        HashMap<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("user", userAllInfo);
        return map;
    }


    /**
     * 更改用户密码
     * @param session
     * @param updatePasswordParam
     * @param locale
     * @return
     * @throws PermissionException
     * @throws UpdateException
     */
    @RequestMapping("/updatePassword.do")
    public Map<String, Object> updatePassword(HttpSession session,
                                              UpdatePasswordParam updatePasswordParam,
                                              Locale locale) throws PermissionException, UpdateException {

        //获取用户ID
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();

        //获取用户权限类型
        PermissionType thisUserPermissionType = user.getPermissionType();

        updatePasswordParam.setId(id);
        updatePasswordParam.setPermissionType(thisUserPermissionType);

        service.updatePassword(updatePasswordParam,locale);

        ResponseMap map = new ResponseMap();

        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updatePassword.success",null,locale));

        return map;
    }


    /**
     * 找回密码更新
     * @param session
     * @param vo
     * @param locale
     * @return
     * @throws UpdateException
     */
    @PostMapping("updateRetrievePassword.do")
    public Map<String, Object> updateRetrievePassword(HttpSession session,
                                                      @Validated RetrievePasswordParam vo,
                                                      BindingResult result,
                                                      Locale locale) throws UpdateException {

        service.updateRetrievePassword(vo,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updatePassword.success",null,locale));

        return map;

    }


    /**
     * 发送找回密码验证码
     * @param user
     * @param result
     * @param locale
     * @return
     * @throws Exception
     */
    @RequestMapping("/sendRetrievePasswordCaptcha.do")
    public Map<String, Object> sendRetrievePasswordCaptcha(@Validated(Sys.RetrievePasswordCaptcha.class) User user,
                                                           BindingResult result,
                                                           Locale locale) throws Exception {

        service.sendRetrievePasswordCaptcha(user, locale);

        ResponseMap map = new ResponseMap(2);
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("response.sendRetrievePasswordCaptcha.success",null,locale));

        return map;
    }



    /**
     * 更新用户基本信息
     * @param session
     * @param updateUser
     * @param result
     * @param locale
     * @return
     * @throws UpdateException
     */
    @PostMapping("updateUserBasicInfo.do")
    public Map<String, Object> updateUserBasicInfo(HttpSession session,
                                                   @Validated(Update.UpdateUserBasicInfo.class)
                                                   User updateUser,
                                                   BindingResult result,
                                                   Locale locale) throws UpdateException {

        User user = (User) session.getAttribute("user");
        updateUser.setId(user.getId());
        updateUser.setPermissionType(user.getPermissionType());

        service.updateUserBasicInfo(updateUser,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateUserBasicInfo.success",null,locale));

        return map;

    }



}
