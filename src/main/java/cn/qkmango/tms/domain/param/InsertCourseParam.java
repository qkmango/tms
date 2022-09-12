package cn.qkmango.tms.domain.param;

import cn.qkmango.tms.domain.entity.Course;
import cn.qkmango.tms.domain.entity.CourseInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.StringJoiner;

/**
 * 插入课程 查询参数类
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-04 10:03
 */
public class InsertCourseParam {

    @Valid
    private Course course;
    @NotEmpty
    private List<Integer> clazzList;
    @Valid
    @NotEmpty
    private List<CourseInfo> courseInfoList;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
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
        return new StringJoiner(", ", InsertCourseParam.class.getSimpleName() + "[", "]")
                .add("course=" + course)
                .add("clazzList=" + clazzList)
                .add("courseInfos=" + courseInfoList)
                .toString();
    }
}
