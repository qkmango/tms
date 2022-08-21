package cn.qkmango.tms.mvc.update.controller;

import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.entity.SystemKeyValue;
import cn.qkmango.tms.mvc.update.service.UpdateSystemService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Map;

/**
 * @author qkmango
 * @version 1.0
 * @className UpdateSystemController
 * @Description 更新系统信息控制器
 * @date 2022-07-28 19:56
 */

@RestController
@RequestMapping(value="/update/system",method = RequestMethod.POST)
public class UpdateSystemController {

    @Resource
    private UpdateSystemService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Permission(PermissionType.admin)
    @RequestMapping("updateSystemKeyValue.do")
    public Map<String, Object> updateSystemKeyValue(@Validated(Update.UpdateSystemKeyValue.class) SystemKeyValue systemKeyValue,
                                                  Locale locale) throws UpdateException {

        service.updateSystemKeyValue(systemKeyValue,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateSystemKeyValue.success",null,locale));

        return map;
    }

}
