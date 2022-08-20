package cn.qkmango.tms.mvc.update.dao;

import cn.qkmango.tms.domain.entity.Building;
import cn.qkmango.tms.domain.entity.Elective;
import cn.qkmango.tms.domain.entity.Room;
import cn.qkmango.tms.domain.entity.User;
import cn.qkmango.tms.domain.param.UpdatePasswordParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateDao {

    int updateStudentScore(Elective elective);

    int updateBuilding(Building building);

    int updateRoom(Room room);

    int updateYear(@Param("year") Integer year, @Param("newYear") Integer newYear);

}
