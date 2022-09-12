package cn.qkmango.tms.mvc.query.service;

import cn.qkmango.tms.domain.entity.Faculty;

import java.util.List;

/**
 * 树型列表查询服务接口
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-03 14:44
 */
public interface ListTreeQueryService {
    List<Faculty> getClazzTreeList();

    List<Faculty> getTeacherTreeList();
}
