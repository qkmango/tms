package cn.qkmango.tms.mvc.insert.service.impl;

import cn.qkmango.tms.common.exception.InsertException;
import cn.qkmango.tms.domain.entity.*;
import cn.qkmango.tms.domain.param.InsertCourseParam;
import cn.qkmango.tms.domain.param.InsertElectiveParam;
import cn.qkmango.tms.mvc.insert.dao.InsertDao;
import cn.qkmango.tms.mvc.insert.service.InsertService;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

/**
 * 插入服务
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:25
 */
@Service
public class InsertServiceImpl implements InsertService {

    @Resource
    private InsertDao insertDao;

    @Resource
    private ReloadableResourceBundleMessageSource messageSource;

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertCourse(InsertCourseParam query, Locale locale) throws InsertException {

        //获取 InsertCourseParam 中的属性
        Course course = query.getCourse();
        List<Integer> clazzList = query.getClazzList();
        List<CourseInfo> courseInfoList = query.getCourseInfoList();

        //插入课程
        int affectedRows = insertDao.insertCourse(course);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertCourse.failure", null, locale));
        }

        //获取插入课程的ID（课程ID）
        int courseId = insertDao.lastInsertId();
        //插入课程信息
        insertCourseInfo(courseId, courseInfoList, locale);

        //插入 课程-班级 关系
        affectedRows = insertDao.insertCourseClazz(courseId, clazzList);
        if (affectedRows != clazzList.size()) {
            throw new InsertException(messageSource.getMessage("db.insertCourse.failure", null, locale));
        }

    }

    /**
     * 插入 课程信息，仅供 insertCourse(..)方法使用
     *
     * @param courseInfoList
     * @throws InsertException
     */
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    protected void insertCourseInfo(int courseId, List<CourseInfo> courseInfoList, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertCourseInfo(courseId, courseInfoList);
        if (affectedRows != courseInfoList.size()) {
            throw new InsertException(messageSource.getMessage("db.insertCourse.failure", null, locale));
        }
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class
    )
    public void insertBuilding(Building building, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertBuilding(building);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertBuilding.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRoom(Room room, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertRoom(room);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertRoom.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertYear(Year year, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertYear(year);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertYear.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertElective(InsertElectiveParam electiveVO, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertElective(electiveVO);
        if (affectedRows != electiveVO.getCourseIds().length) {
            throw new InsertException(messageSource.getMessage("db.insertElective.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTeachEvaluate(TeachEvaluate teachEvaluate, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertTeachEvaluate(teachEvaluate);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertTeachEvaluate.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertCalendar(Calendar calendar, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertCalendar(calendar);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertCalendar.failure", null, locale));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertFaculty(Faculty faculty, Locale locale) throws InsertException {
        int affectedRows = insertDao.insertFaculty(faculty);
        if (affectedRows != 1) {
            throw new InsertException(messageSource.getMessage("db.insertFaculty.failure", null, locale));
        }
    }
}
