package cn.qkmango.tms.mvc.update.dao;

import cn.qkmango.tms.domain.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 更新DAO层
 *
 * @author qkmango
 */
@Mapper
public interface UpdateDao {

    int updateStudentScore(Elective elective);

    int updateBuilding(Building building);

    int updateRoom(Room room);

    int updateYear(@Param("year") Integer year, @Param("newYear") Integer newYear);

    int updateFaculty(Faculty faculty);

    int updateSpecialized(Specialized specialized);
}
