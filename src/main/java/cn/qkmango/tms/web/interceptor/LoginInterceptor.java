package cn.qkmango.tms.web.interceptor;

import cn.qkmango.tms.common.utils.ResponseUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qkmango
 * @version 1.0
 * @className LoginInterceptor
 * @Description 登陆拦截器
 * 验证用户是否登陆
 * @date 2021-06-14
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //如果session存在，说明已经登陆过了，则放行
        HttpSession session = request.getSession(false);
        if (session != null) {
            return true;
        }

        ResponseUtil.responseJson(response,"{\"success\": false,\"message\": \"未登录!\"}");
        return false;

    }
}
