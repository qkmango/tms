package cn.qkmango.tms.mvc.update.controller;


import cn.qkmango.tms.common.annotation.Permission;
import cn.qkmango.tms.common.exception.UpdateException;
import cn.qkmango.tms.common.map.ResponseMap;
import cn.qkmango.tms.common.validate.group.Update;
import cn.qkmango.tms.common.validate.group.Update.*;
import cn.qkmango.tms.domain.bind.PermissionType;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.mvc.update.service.UpdateService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.Map;

/**
 * 更新修改控制器
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-06-15
 */
@RestController
@RequestMapping(value = "/update", method = RequestMethod.POST)
public class UpdateController {

    @Resource
    private UpdateService updateService;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;


    /**
     * 更新学生成绩
     *
     * @param elective
     * @return
     * @throws UpdateException
     * @Validated true
     */
    @Permission(PermissionType.teacher)
    @RequestMapping("updateStudentScore.do")
    public Map<String, Object> updateStudentScore(@Validated(UpdateStudentScore.class) Elective elective,
                                                  Locale locale) throws UpdateException {

        updateService.updateStudentScore(elective, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateStudentScore.success", null, locale));

        return map;
    }


    /**
     * 更新楼宇信息
     *
     * @param building
     * @return
     * @throws UpdateException
     * @Validated false
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateBuilding.do")
    public Map<String, Object> updateBuilding(@Validated Building building, Locale locale) throws UpdateException {

        updateService.updateBuilding(building, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateBuilding.success", null, locale));

        return map;
    }


    /**
     * 修改 教室信息
     *
     * @param room
     * @return
     * @throws UpdateException
     * @validated true
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateRoom.do")
    public Map<String, Object> updateRoom(@Validated(UpdateRoom.class) Room room, Locale locale) throws UpdateException {

        updateService.updateRoom(room, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateRoom.success", null, locale));

        return map;
    }


    /**
     * 更新修改 年份
     *
     * @param year
     * @return
     * @throws UpdateException
     * @Validated false
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateYear.do")
    public Map<String, Object> updateYear(Integer year, Integer newYear, Locale locale) throws UpdateException {

        updateService.updateYear(year, newYear, locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateYear.success", null, locale));

        return map;
    }

    /**
     * 更新修改 学院信息
     * @param faculty
     * @param locale
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @CacheEvict(cacheNames="*@faculty*",allEntries = true)
    @RequestMapping("updateFaculty.do")
    public Map<String, Object> updateFaculty(@Validated(UpdateFaculity.class) Faculty faculty, Locale locale) throws UpdateException {
        updateService.updateFaculty(faculty,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateFaculty.success", null, locale));

        return map;
    }

    /**
     * 更新修改 专业信息
     * @param specialized
     * @param locale
     * @return
     * @throws UpdateException
     */
    @Permission(PermissionType.admin)
    @RequestMapping("updateSpecialized.do")
    public Map<String, Object> updateSpecialized(@Validated(Update.class) Specialized specialized, Locale locale) throws UpdateException {
        updateService.updateSpecialized(specialized,locale);

        ResponseMap map = new ResponseMap();
        map.setSuccess(true);
        map.setMessage(messageSource.getMessage("db.updateSpecialized.success", null, locale));

        return map;
    }


}
