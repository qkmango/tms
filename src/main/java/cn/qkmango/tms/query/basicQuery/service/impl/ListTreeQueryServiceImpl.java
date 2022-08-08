package cn.qkmango.tms.query.basicQuery.service.impl;

import cn.qkmango.tms.domain.orm.Clazz;
import cn.qkmango.tms.domain.orm.Faculty;
import cn.qkmango.tms.domain.orm.Specialized;
import cn.qkmango.tms.domain.orm.Teacher;
import cn.qkmango.tms.query.basicQuery.dao.ListQueryDao;
import cn.qkmango.tms.query.basicQuery.dao.ListTreeQueryDao;
import cn.qkmango.tms.query.basicQuery.service.ListQueryService;
import cn.qkmango.tms.query.basicQuery.service.ListTreeQueryService;
import cn.qkmango.tms.query.basicQuery.service.SystemQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qkmango
 * @version 1.0
 * @className ListTreeQueryServiceImpl
 * @Description 树型列表查询
 * @date 2022-08-03 14:45
 */

@Service
public class ListTreeQueryServiceImpl implements ListTreeQueryService {

    @Resource
    private ListTreeQueryDao dao;

    @Resource
    private ListQueryService listQueryService;


    @Override
    public List<Faculty> getClazzTreeList() {

        List<Faculty> facultyList = listQueryService.getFacultyList();

        for (Faculty faculty : facultyList) {
            List<Specialized> specializedList = dao.getSpecializedListByFacultyId(faculty.getId());
            faculty.setSpecializedList(specializedList);
            for (Specialized specialized : specializedList) {
                List<Clazz> clazzList = dao.getClazzListBySpecializedId(specialized.getId());
                specialized.setClazzList(clazzList);
            }
        }

        return facultyList;
    }

    @Override
    public List<Faculty> getTeacherTreeList() {
        List<Faculty> facultyList = listQueryService.getFacultyList();

        for (Faculty faculty : facultyList) {
            List<Teacher> teacherList = dao.getTeacherListByFacultyId(faculty.getId());
            faculty.setTeacherList(teacherList);
        }

        return facultyList;
    }
}
