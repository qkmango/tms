package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.domain.bind.course.CourseType;
import cn.qkmango.tms.domain.bind.course.WeekType;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 课程信息
 *
 * @author qkmango
 */
public class CourseInfo implements Serializable {

    private static final long serialVersionUID = 7153500823408238626L;
    private Integer id;
    private Integer course;
    @NotNull
    private CourseType courseType;
    @NotNull
    private WeekType weekType;
    @NotNull
    @Range(min = 1, message = "起始周必须>=1")
    private Integer beginWeek;
    @NotNull
    @Range(min = 1, message = "持续周必须>=1")
    private Integer lengthWeek;
    @NotNull
    @Range(min = 1, max = 7, message = "星期在1-7")
    private Integer weekDay;
    @NotNull
    @Range(min = 1, max = 11, message = "起始节取值在1-11")
    private Integer begin;
    @NotNull
    @Range(min = 1, max = 4, message = "持续节取值在1-4")
    private Integer length;
    @NotNull
    private Integer address;

    public CourseInfo() {
    }

    public CourseInfo(Integer id, Integer course, CourseType courseType, WeekType weekType, Integer beginWeek, Integer lengthWeek, Integer weekDay, Integer begin, Integer length, Integer address) {
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

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
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
