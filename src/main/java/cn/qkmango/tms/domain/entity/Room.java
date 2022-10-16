package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.common.validate.group.Insert.InsertRoom;
import cn.qkmango.tms.common.validate.group.Update.UpdateRoom;
import cn.qkmango.tms.domain.bind.RoomType;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 教室
 * 属性：ID，教室号，名称，所属楼宇，容纳人数，教室类型
 *
 * @author qkmango
 */
public class Room implements Serializable {
    @NotNull(groups = {UpdateRoom.class})
    private Integer id;

    @NotNull(groups = {UpdateRoom.class, InsertRoom.class})
    @Range(min = 101, max = 999, message = "教室号为三位数101-999", groups = {UpdateRoom.class, InsertRoom.class})
    private Integer number;

    @NotNull(groups = {UpdateRoom.class, InsertRoom.class})
    private String name;

    @NotNull(groups = {UpdateRoom.class, InsertRoom.class})
    private Integer building;

    @NotNull(groups = {UpdateRoom.class, InsertRoom.class})
    @Range(min = 1, message = "容纳人数>0", groups = {UpdateRoom.class, InsertRoom.class})
    private Integer capacity;

    @NotNull(groups = {UpdateRoom.class, InsertRoom.class})
    private RoomType roomType;

    public Room() {
    }

    public Room(Integer id, Integer number, String name, Integer building, Integer capacity, RoomType roomType) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.building = building;
        this.capacity = capacity;
        this.roomType = roomType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", building=" + building +
                ", capacity=" + capacity +
                ", roomType=" + roomType +
                '}';
    }
}
