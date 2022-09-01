package cn.qkmango.tms.mvc.query.service.impl;

import cn.qkmango.tms.domain.entity.Clazz;
import cn.qkmango.tms.domain.entity.Faculty;
import cn.qkmango.tms.domain.entity.Specialized;
import cn.qkmango.tms.domain.entity.Teacher;
import cn.qkmango.tms.mvc.query.dao.ListTreeQueryDao;
import cn.qkmango.tms.mvc.query.service.ListQueryService;
import cn.qkmango.tms.mvc.query.service.ListTreeQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 树型列表查询服务
 * @author qkmango
 * @version 1.0
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
