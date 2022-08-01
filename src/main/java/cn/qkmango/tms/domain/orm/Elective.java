package cn.qkmango.tms.domain.orm;

import cn.qkmango.tms.common.validate.group.Update.UpdateStudentScore;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @className: Elective
 * @Description: 选课对象，对于对应数据库 t_elective 表
 * @author: qkmango
 * @date: 2021-07-02 18:04
 * @version: 1.0
 */
public class Elective {
    //选课ID，学生ID，课程ID，课程分数

    @NotNull(message = "{valid.Elective.id.NotNull}",groups = {UpdateStudentScore.class})
    private Integer id;
    private Integer student;
    private Integer course;
    @NotNull(message = "{valid.Elective.id.NotNull}",groups = {UpdateStudentScore.class})
    @Range(min = 0,max = 100,message = "{valid.Elective.id.NotNull}",groups = {UpdateStudentScore.class})
    private Integer score;

    public Elective() {
    }

    public Elective(Integer id, Integer student, Integer course, Integer score) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Elective{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}
