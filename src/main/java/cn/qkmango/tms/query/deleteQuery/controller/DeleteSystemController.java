package cn.qkmango.tms.query.deleteQuery.controller;

import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.DeleteException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Delete;
import cn.qkmango.tms.query.deleteQuery.service.DeleteSystemService;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.orm.SystemKeyValue;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
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
 * @className DeleteSystemController
 * @Description TODO
 * @date 2022-07-28 17:55
 */
@RestController
@RequestMapping(value = "/delete/system", method = RequestMethod.POST)
public class DeleteSystemController {

    @Resource
    private DeleteSystemService service;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Permission(PermissionType.admin)
    @RequestMapping("/deleteSystemKeyValue.do")
    public Map deleteSystemKeyValue(@Validated(Delete.DeleteSystemKeyValue.class) SystemKeyValue systemKeyValue,
                                    BindingResult result,
                                    Locale locale) throws DeleteException {

        service.deleteSystemKeyValue(systemKeyValue, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.deleteSystemKeyValue.success", null, locale));

        return map;
    }
}
