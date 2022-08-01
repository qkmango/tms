package cn.qkmango.tms.config;

import cn.qkmango.tms.web.interceptor.LoginInterceptor;
import cn.qkmango.tms.web.interceptor.PermissionsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author qkmango
 * @version 1.0
 * @className InterceptorConfig
 * @Description 拦截器配置类
 * @date 2022-07-31 20:57
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {


        //国际化拦截器
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        registry.addInterceptor(localeChangeInterceptor)
                .addPathPatterns("/system/setLocale.do");

        //登陆拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**/*.do")
                .excludePathPatterns("/system/login.do")
                .excludePathPatterns("/system/setLocale.do")
                .excludePathPatterns("/query/list/test.do");


        PermissionsInterceptor permissionsInterceptor = new PermissionsInterceptor();
        registry.addInterceptor(permissionsInterceptor)
                .addPathPatterns("/query/**/*.do")
                .addPathPatterns("/insert/**/*.do")
                .addPathPatterns("/delete/**/*.do")
                .addPathPatterns("/update/**/*.do")
                // .addPathPatterns("/system/**/*.do")
                // .excludePathPatterns("/system/setLocale.do")
                // .excludePathPatterns("/system/setLocale.do")
                .excludePathPatterns("/query/list/test.do");

    }

}
