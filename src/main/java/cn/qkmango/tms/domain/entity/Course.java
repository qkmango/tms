package cn.qkmango.tms.domain.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 课程实体类
 *
 * @author qkmango
 */
public class Course implements Serializable {

    private Integer id;
    @NotEmpty
    private String name;
    @NotNull
    @Range(min = 1, max = 4)
    private Integer credit;
    @NotNull
    private Integer teacher;
    @NotNull
    @Range(min = 2000, max = 2100)
    private Integer courseYear;
    /**
     * 1：表示第一学期；2：表示第二学期
     */
    @Size(min = 1, max = 2)
    @NotEmpty
    private String term;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer teacher, Integer courseYear, String term) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.teacher = teacher;
        this.courseYear = courseYear;
        this.term = term;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", teacher=" + teacher +
                ", year=" + courseYear +
                ", term=" + term +
                '}';
    }
}
