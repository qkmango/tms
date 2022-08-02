package cn.qkmango.tms.web.interceptor;

import cn.qkmango.tms.common.utils.ResponseUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    // private ReloadableResourceBundleMessageSource messageSource = SpringUtil.getBean(ReloadableResourceBundleMessageSource.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        //如果session存在，说明已经登陆过了，则放行
        HttpSession session = request.getSession(false);
        if (session != null) {
            return true;
        }

        // String message = messageSource.getMessage("response.login.LoginInterceptor", null, request.getLocale());
        // Sys.out.println(message);
        ResponseUtil.responseJson(response,"{\"success\": false,\"message\": \"未登录!\"}");
        return false;

    }
}
