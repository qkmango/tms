package cn.qkmango.tms.domain.pagination;

import java.util.List;
import java.util.StringJoiner;


/**
 * @author qkmango
 * @version 1.0
 * @className StudentScorePagination
 * @Description 学生分数分页类
 * @see cn.qkmango.tms.domain.pagination.Pagination
 * @date 2022-07-31 19:26
 */
public class StudentScorePagination extends Pagination {

    //学生ID
    private Integer student;
    //学生姓名
    private String name;
    //授课老师ID
    private Integer teacher;
    //班级ID
    private List<Integer> clazz;
    //学科（专业课）ID
    private Integer course;
    //学科 开设年份
    private Integer courseYear;
    //学期
    private Integer term;
    //课程 名称
    private String courseName;

    public StudentScorePagination() {
    }

    public StudentScorePagination(Integer page, Integer limit, Boolean pagination, Integer student, String name, Integer teacher, List<Integer> clazz, Integer course, Integer courseYear, Integer term, String courseName) {
        super(page, limit, pagination);
        this.student = student;
        this.name = name;
        this.teacher = teacher;
        this.clazz = clazz;
        this.course = course;
        this.courseYear = courseYear;
        this.term = term;
        this.courseName = courseName;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public List<Integer> getClazz() {
        return clazz;
    }

    public void setClazz(List<Integer> clazz) {
        this.clazz = clazz;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Integer courseYear) {
        this.courseYear = courseYear;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentScorePagination.class.getSimpleName() + "[", "]")
                .add("student=" + student)
                .add("name='" + name + "'")
                .add("teacher=" + teacher)
                .add("clazz=" + clazz)
                .add("course=" + course)
                .add("courseYear=" + courseYear)
                .add("term=" + term)
                .add("courseName='" + courseName + "'")
                .add("page=" + page)
                .add("limit=" + limit)
                .add("skipCount=" + skipCount)
                .add("pagination=" + pagination)
                .toString();
    }
}
