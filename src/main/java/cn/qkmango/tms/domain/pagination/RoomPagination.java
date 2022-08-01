package cn.qkmango.tms.domain.pagination;

import cn.qkmango.tms.domain.bind.RoomType;

/**
 * room分页对象
 */
public class RoomPagination extends Pagination{

    private Integer id;
    private Integer number;
    private String name;
    private Integer building;
    private Integer capacity;
    private RoomType roomType;

    public RoomPagination() {
    }

    public RoomPagination(Integer page, Integer limit, Boolean pagination, Integer id, Integer number, String name, Integer building,Integer capacity, RoomType roomType) {
        super(page, limit, pagination);
        this.id = id;
        this.number = number;
        this.name = name;
        this.building = building;
        this.capacity = capacity;
        this.roomType = roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "RoomPagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", pagination=" + pagination +
                ", id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", building=" + building +
                ", capacity=" + capacity +
                ", roomType=" + roomType +
                '}';
    }
}
