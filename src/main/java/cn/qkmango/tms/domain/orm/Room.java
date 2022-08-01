package cn.qkmango.tms.domain.orm;

import cn.qkmango.tms.common.validate.group.Insert.InsertRoom;
import cn.qkmango.tms.common.validate.group.Update.UpdateRoom;
import cn.qkmango.tms.domain.bind.RoomType;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 属性：ID，教室号，名称，所属楼宇，容纳人数，教室类型
 */
public class Room {
    @NotNull(message = "{valid.Room.id.NotNull}",groups = {UpdateRoom.class})
    private Integer id;

    @NotNull(message = "{valid.Room.number.NotNull}",groups = {UpdateRoom.class, InsertRoom.class})
    @Range(min = 101,max = 999,message = "{valid.Room.number.Range}",groups = {UpdateRoom.class, InsertRoom.class})
    private Integer number;

    private String name;

    @NotNull(message = "{valid.Room.building.NotNull}",groups = {UpdateRoom.class, InsertRoom.class})
    private Integer building;

    @NotNull(message = "{valid.Room.capacity.NotNull}",groups = {UpdateRoom.class, InsertRoom.class})
    @Range(min = 1,message = "{valid.Room.capacity.Range}",groups = {UpdateRoom.class, InsertRoom.class})
    private Integer capacity;

    @NotNull(message = "{valid.Room.roomType.NotNull}",groups = {UpdateRoom.class, InsertRoom.class})
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
