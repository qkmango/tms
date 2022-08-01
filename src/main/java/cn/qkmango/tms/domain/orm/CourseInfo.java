package cn.qkmango.tms.domain.orm;

import cn.qkmango.tms.domain.bind.course.CourseType;
import cn.qkmango.tms.domain.bind.course.WeekDay;
import cn.qkmango.tms.domain.bind.course.WeekType;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


public class CourseInfo {

    private Integer id;
    private Integer course;
    @NotNull(message = "{valid.CourseInfo.courseType.NotNull}")
    private CourseType courseType;
    @NotNull(message = "{valid.CourseInfo.weekType.NotNull}")
    private WeekType weekType;
    @NotNull(message = "{valid.CourseInfo.beginWeek.NotNull}")
    @Range(min = 1, message = "{valid.CourseInfo.beginWeek.Range}")
    private Integer beginWeek;
    @NotNull(message = "{valid.CourseInfo.lengthWeek.NotNull}")
    @Range(min = 1, message = "{valid.CourseInfo.lengthWeek.Range}")
    private Integer lengthWeek;
    @NotNull(message = "{valid.CourseInfo.weekDay.NotNull}")
    private WeekDay weekDay;
    @NotNull(message = "{valid.CourseInfo.begin.NotNull}")
    @Range(min = 1, max = 11, message = "{valid.CourseInfo.begin.Range}")
    private Integer begin;
    @NotNull(message = "{valid.CourseInfo.length.NotNull}")
    @Range(min = 1, max = 4, message = "{valid.CourseInfo.length.Range}")
    private Integer length;
    @NotNull(message = "{valid.CourseInfo.address.NotNull}")
    private Integer address;

    public CourseInfo() {
    }

    public CourseInfo(Integer id, Integer course, CourseType courseType, WeekType weekType, Integer beginWeek, Integer lengthWeek, WeekDay weekDay, Integer begin, Integer length, Integer address) {
        this.id = id;
        this.course = course;
        this.courseType = courseType;
        this.weekType = weekType;
        this.beginWeek = beginWeek;
        this.lengthWeek = lengthWeek;
        this.weekDay = weekDay;
        this.begin = begin;
        this.length = length;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public WeekType getWeekType() {
        return weekType;
    }

    public void setWeekType(WeekType weekType) {
        this.weekType = weekType;
    }

    public Integer getBeginWeek() {
        return beginWeek;
    }

    public void setBeginWeek(Integer beginWeek) {
        this.beginWeek = beginWeek;
    }

    public Integer getLengthWeek() {
        return lengthWeek;
    }

    public void setLengthWeek(Integer lengthWeek) {
        this.lengthWeek = lengthWeek;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id=" + id +
                ", course=" + course +
                ", courseType=" + courseType +
                ", weekType=" + weekType +
                ", startWeek=" + beginWeek +
                ", endWeek=" + lengthWeek +
                ", weekDay=" + weekDay +
                ", begin=" + begin +
                ", length=" + length +
                ", address=" + address +
                '}';
    }
}
