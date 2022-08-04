package cn.qkmango.tms.domain.query;

import cn.qkmango.tms.domain.orm.Course2;
import cn.qkmango.tms.domain.orm.CourseInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author qkmango
 * @version 1.0
 * @className InsertCourseQuery
 * @Description TODO
 * @date 2022-08-04 10:03
 */
public class InsertCourseQuery {

    @Valid
    private Course2 course;
    @NotEmpty
    private List<Integer> clazzList;
    @Valid
    @NotEmpty
    private List<CourseInfo> courseInfoList;


    public Course2 getCourse() {
        return course;
    }

    public void setCourse(Course2 course) {
        this.course = course;
    }

    public List<Integer> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Integer> clazzList) {
        this.clazzList = clazzList;
    }

    public List<CourseInfo> getCourseInfoList() {
        return courseInfoList;
    }

    public void setCourseInfoList(List<CourseInfo> courseInfoList) {
        this.courseInfoList = courseInfoList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InsertCourseQuery.class.getSimpleName() + "[", "]")
                .add("course=" + course)
                .add("clazzList=" + clazzList)
                .add("courseInfos=" + courseInfoList)
                .toString();
    }
}
