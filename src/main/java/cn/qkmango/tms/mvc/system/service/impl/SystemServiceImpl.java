package cn.qkmango.tms.mvc.system.service.impl;

import cn.qkmango.tms.mvc.system.dao.SystemDao;
import cn.qkmango.tms.mvc.system.service.SystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qkmango
 * @version 1.0
 * @className SystemServiceImpl
 * @Description 系统信息服务
 * @date
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Resource
    private SystemDao dao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


}
