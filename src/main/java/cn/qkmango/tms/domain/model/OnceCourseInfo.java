package cn.qkmango.tms.domain.model;

import cn.qkmango.tms.domain.bind.course.WeekType;

/**
 * 一次课的课程信息
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-07-25 15:50
 */
public class OnceCourseInfo {
    private String name;
    private Integer id;

    private byte beginWeek;
    private byte lengthWeek;
    private WeekType weekType;

    private String teacher;

    private String buildingNumber;
    private int roomNumber;

    private byte weekDay;

    private byte length;
    private byte begin;

    public OnceCourseInfo() {
    }

    public OnceCourseInfo(String name, Integer id, byte beginWeek, byte lengthWeek, WeekType weekType, String teacher, String buildingNumber, int roomNumber, byte weekDay, byte length, byte begin) {
        this.name = name;
        this.id = id;
        this.beginWeek = beginWeek;
        this.lengthWeek = lengthWeek;
        this.weekType = weekType;
        this.teacher = teacher;
        this.buildingNumber = buildingNumber;
        this.roomNumber = roomNumber;
        this.weekDay = weekDay;
        this.length = length;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getBeginWeek() {
        return beginWeek;
    }

    public void setBeginWeek(byte beginWeek) {
        this.beginWeek = beginWeek;
    }

    public byte getLengthWeek() {
        return lengthWeek;
    }

    public void setLengthWeek(byte lengthWeek) {
        this.lengthWeek = lengthWeek;
    }

    public WeekType getWeekType() {
        return weekType;
    }

    public void setWeekType(WeekType weekType) {
        this.weekType = weekType;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public byte getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(byte weekDay) {
        this.weekDay = weekDay;
    }

    public byte getLength() {
        return length;
    }

    public void setLength(byte length) {
        this.length = length;
    }

    public byte getBegin() {
        return begin;
    }

    public void setBegin(byte begin) {
        this.begin = begin;
    }

    @Override
    public String toString() {
        return "OnceCourseInfo{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", beginWeek=" + beginWeek +
                ", lengthWeek=" + lengthWeek +
                ", weekType=" + weekType +
                ", teacher='" + teacher + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", roomNumber=" + roomNumber +
                ", weekDay=" + weekDay +
                ", length=" + length +
                ", begin=" + begin +
                '}';
    }
}
