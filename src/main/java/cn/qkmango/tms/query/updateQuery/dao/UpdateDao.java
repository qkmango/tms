package cn.qkmango.tms.query.updateQuery.dao;

import cn.qkmango.tms.domain.orm.Building;
import cn.qkmango.tms.domain.orm.Elective;
import cn.qkmango.tms.domain.orm.Room;
import cn.qkmango.tms.domain.vo.UpdatePasswordVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpdateDao {

    int updateStudentScore(Elective elective);

    int updateBuilding(Building building);

    int updateRoom(Room room);

    int updateYear(@Param("year") Integer year, @Param("newYear") Integer newYear);

    int updatePassword(UpdatePasswordVO updatePasswordVO);
}
