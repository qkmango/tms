package cn.qkmango.tms.domain.orm;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 课程实体类
 */
public class Course {

    private Integer id;
    @NotEmpty(message = "{valid.Course.name.NotEmpty}")
    private String name;
    @NotNull(message = "{valid.Course.credit.NotNull}")
    @Range(min = 1,max = 4,message = "{valid.Course.credit.Range}")
    private Integer credit;
    @NotNull(message = "{valid.Course.clazz.NotNull}")
    private Integer clazz;
    @NotNull(message = "{valid.Course.teacher.NotNull}")
    private Integer teacher;
    @NotNull(message = "{valid.Course.courseYear.NotNull}")
    @Range(min = 2000,max = 2100,message = "{valid.Year.year.Range}")
    private Integer courseYear;
    //false 0：表示第一学期；true 1：表示第二学期
    @NotNull(message = "{valid.Course.term.NotNull}")
    private Boolean term;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, Integer clazz, Integer teacher, Integer courseYear, Boolean term) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.clazz = clazz;
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

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
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

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", clazz=" + clazz +
                ", teacher=" + teacher +
                ", year=" + courseYear +
                ", term=" + term +
                '}';
    }
}
