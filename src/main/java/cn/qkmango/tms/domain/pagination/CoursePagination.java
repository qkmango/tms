package cn.qkmango.tms.domain.pagination;

import cn.qkmango.tms.domain.orm.Course;


/**
 * @author qkmango
 * @version 1.0
 * @className CoursePagination
 * @Description
 * @date 2022-07-31 19:26
 */
public class CoursePagination extends Pagination {

    private Course course;
    private Integer teacher;

    public Integer getId() {
        return course.getId();
    }

    public void setId(Integer id) {
        this.course.setId(id);
    }

    public String getName() {
        return course.getName();
    }

    public void setName(String name) {
        this.course.setName(name);
    }

    public Integer getCredit() {
        return course.getCredit();
    }

    public void setCredit(Integer credit) {
        this.course.setCredit(credit);
    }

    public Integer getTeacher() {
        return course.getTeacher();
    }

    public void setTeacher(Integer teacher) {
        this.course.setTeacher(teacher);
    }

    public Integer getYear() {
        return course.getCourseYear();
    }

    public void setYear(Integer year) {
        this.course.setCourseYear(year);
    }

    public String getTerm() {
        return course.getTerm();
    }

    public void setTerm(String term) {
        this.course.setTerm(term);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CoursePagination{" +
                "course=" + course +
                ", teacher=" + teacher +
                ", page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", pagination=" + pagination +
                '}';
    }
}
