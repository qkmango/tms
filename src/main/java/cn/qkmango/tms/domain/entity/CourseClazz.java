package cn.qkmango.tms.domain.entity;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 课程班级关系
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-08-03 14:34
 */
public class CourseClazz implements Serializable {

    private static final long serialVersionUID = 1641323564398132839L;
    /**
     * course ID
     */
    private Integer course;
    /**
     * clazz ID
     */
    private Integer clazz;

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CourseClazz.class.getSimpleName() + "[", "]")
                .add("course=" + course)
                .add("clazz=" + clazz)
                .toString();
    }
}
