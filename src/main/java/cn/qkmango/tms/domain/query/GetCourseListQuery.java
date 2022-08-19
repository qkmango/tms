package cn.qkmango.tms.domain.query;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author qkmango
 * @version 1.0
 * @className GetCourseListQuery
 * @Description 获取课程列表
 * @date 2022-08-19 18:39
 */
public class GetCourseListQuery {
    private Integer course;
    private List<Integer> clazz;
    private Integer teacher;
    private Integer courseYear;
    private Byte term;

    public GetCourseListQuery() {
    }

    public GetCourseListQuery(Integer course, List<Integer> clazz, Integer teacher, Integer courseYear, Byte term) {
        this.course = course;
        this.clazz = clazz;
        this.teacher = teacher;
        this.courseYear = courseYear;
        this.term = term;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public List<Integer> getClazz() {
        return clazz;
    }

    public void setClazz(List<Integer> clazz) {
        this.clazz = clazz;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Integer courseYear) {
        this.courseYear = courseYear;
    }

    public Byte getTerm() {
        return term;
    }

    public void setTerm(Byte term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GetCourseListQuery.class.getSimpleName() + "[", "]")
                .add("course=" + course)
                .add("clazz=" + clazz)
                .add("teacher=" + teacher)
                .add("courseYear=" + courseYear)
                .add("term=" + term)
                .toString();
    }
}
