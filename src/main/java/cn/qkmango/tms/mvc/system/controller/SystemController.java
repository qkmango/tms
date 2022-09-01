package cn.qkmango.tms.mvc.system.controller;

import cn.qkmango.tms.mvc.system.service.SystemService;
import org.apache.catalina.Manager;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * 系统信息控制器
 * @author qkmango
 * @version 1.0
 * @date 2021-06-13
 */
@RestController
@RequestMapping(value = "/system")
public class SystemController {

    @Resource
    private SystemService systemService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    private Manager sessionManager;


    /**
     * 更改语言环境
     * @param locale 新的语言
     * @return
     */
    @RequestMapping(value = "/setLocale.do")
    public Map setLocale(String locale, Locale localeObj) {
        HashMap<Object, Object> map = new HashMap<>(3);
        map.put("locale",localeObj.getLanguage());
        map.put("success",true);
        map.put("message",messageSource.getMessage("response.setLocale.success",null,localeObj));
        return map;

    }


    /**
     * 获取当前活动的 session 数量（当前登陆用户数）
     * @param request
     * @return
     */
    @RequestMapping("/getActiveSessionCount.do")
    public String getActiveSessionCount(HttpServletRequest request) throws NoSuchFieldException, IllegalAccessException {

        if (sessionManager == null) {
            if (request instanceof RequestFacade) {
                Field requestField = request.getClass().getDeclaredField("request");
                requestField.setAccessible(true);
                Request req = (Request) requestField.get(request);
                org.apache.catalina.Context context = req.getContext();
                sessionManager = context.getManager();
            }
        }

        int active = sessionManager != null ? sessionManager.getActiveSessions() : 0;
        String res = "{\"success\":true,\"active\":"+active+"}";

        return res;
    }

}
