package cn.qkmango.tms.query.basicQuery.service;

import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;

import java.util.HashMap;

/**
 * 分页查询服务接口
 */
public interface PaginationQueryService {

    HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination);

    HashMap<String, Object> getRoomPagination(RoomPagination pagination);

}
