package cn.qkmango.tms.web.interceptor;

import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.utils.ResponseUtil;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author qkmango
 * @version 1.0
 * @className PermissionsInterceptor
 * @Description 用户权限验证
 * 验证请求用户的权限是否满足请求的接口权限
 * @date 2021-06-14
 */
public class PermissionsInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        /**
         * 如果没有注解，则说明没有设置接口权限，则无需拦截,返回true放行
         */
        Permission annotation = null;
        //控制器方法上使用注解指定的 允许访问的用户权限类型
        PermissionType[] methodPermissionTypes = null;

        if (method.isAnnotationPresent(Permission.class)) {
            annotation = method.getAnnotation(Permission.class);
            methodPermissionTypes = annotation.value();
        } else {
            return true;
        }

        User user = (User) request.getSession().getAttribute("user");

        //当前登陆的用户（当前请求的用户）的用户权限类型
        PermissionType thisUserPermissionType = user.getPermissionType();
        /**
         * 如果用户权限在方法注解规定的权限中，则返回true放行
         * 使用 @Permission 在方法上可以指定多个权限值
         */
        for (PermissionType value : methodPermissionTypes) {
            if (value == thisUserPermissionType) {
                return true;
            }
        }

        ResponseUtil.responseJson(response,"{\"success\":false,\"message\":\"无权操作\"}");
        return false;
    }

}
