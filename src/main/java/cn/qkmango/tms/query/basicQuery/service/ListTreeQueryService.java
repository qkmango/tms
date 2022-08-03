package cn.qkmango.tms.query.basicQuery.service;

import cn.qkmango.tms.domain.orm.Faculty;

import java.util.List;

/**
 * @author qkmango
 * @version 1.0
 * @className ListTreeQueryService
 * @Description TODO
 * @date 2022-08-03 14:44
 */
public interface ListTreeQueryService {
    List<Faculty> getClazzTreeList();

    List<Faculty> getTeacherTreeList();
}
