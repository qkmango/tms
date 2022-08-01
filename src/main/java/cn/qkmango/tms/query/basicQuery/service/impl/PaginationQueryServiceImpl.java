package cn.qkmango.tms.query.basicQuery.service.impl;

import cn.qkmango.tms.query.basicQuery.dao.PaginationQueryDao;
import cn.qkmango.tms.query.basicQuery.service.PaginationQueryService;
import cn.qkmango.tms.domain.pagination.RoomPagination;
import cn.qkmango.tms.domain.pagination.StudentScorePagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author qkmango
 * 系统分页查询服务实现
 */
@Service
public class PaginationQueryServiceImpl implements PaginationQueryService {

    @Resource
    private PaginationQueryDao paginationQueryDao;

    @Override
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = true
    )
    public HashMap<String,Object> getStudentScorePagination(StudentScorePagination pagination) {

        List<HashMap<String, Object>> data = paginationQueryDao.getStudentScorePagination(pagination);

        HashMap<String, Object> map = new HashMap<>(3);

        if (pagination.getPagination() != false) {
            int count = paginationQueryDao.getCount();
            map.put("count",count);
        }

        map.put("data",data);
        map.put("pagination",pagination.getPagination());

        return map;
    }

    @Override
    public HashMap<String, Object> getRoomPagination(RoomPagination pagination) {

        List<HashMap<String, Object>> data = paginationQueryDao.getRoomPagination(pagination);

        HashMap<String, Object> map = new HashMap<>(3);

        if (pagination.getPagination() != false) {
            int count = paginationQueryDao.getCount();
            map.put("count",count);
        }

        map.put("data",data);
        map.put("pagination",pagination.getPagination());

        return map;
    }

}
