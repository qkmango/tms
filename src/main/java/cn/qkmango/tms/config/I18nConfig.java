package cn.qkmango.tms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

/**
 * 国际化配置类
 * @author qkmango
 * @version 1.0
 * @date 2022-07-31 20:58
 */
@Configuration
public class I18nConfig {
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasenames(
                "classpath:i18n/db",
                "classpath:i18n/query",
                "classpath:i18n/response"
        );

        messageBundle.setUseCodeAsDefaultMessage(false);
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }

    @Bean(name = "localeResolver")
    public CookieLocaleResolver cookieLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return resolver;
    }


    // @Bean(name = "myValidator")
    // public LocalValidatorFactoryBean localValidatorFactoryBean() {
    //     LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
    //     factoryBean.setValidationMessageSource(messageSource());
    //     factoryBean.setProviderClass(HibernateValidator.class);
    //
    //     return factoryBean;
    // }
}
