package cn.qkmango.tms.query.basicQuery.dao;

import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author qkmango
 */

@Mapper
public interface PaginationQueryDao {
    int getCount();
    List<HashMap<String, Object>> getStudentScorePagination(StudentScorePagination pagination);
    List<HashMap<String, Object>> getRoomPagination(RoomPagination pagination);

}
