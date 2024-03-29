package cn.qkmango.tms.domain.model;

import java.util.List;

/**
 * 课程表类
 * 包含课表的基本信息和课程信息列表
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-07-25 15:31
 * @see cn.qkmango.tms.domain.model.OnceCourseInfo
 */
public class TimeTable {

    List<OnceCourseInfo> list;
    Integer year;
    Byte term;
    String studentName;
    Integer studentId;
    String clazzName;

    public TimeTable() {
    }

    public TimeTable(List<OnceCourseInfo> list, Integer year, Byte term, String studentName, Integer studentId, String clazzName) {
        this.list = list;
        this.year = year;
        this.term = term;
        this.studentName = studentName;
        this.studentId = studentId;
        this.clazzName = clazzName;
    }

    public List<OnceCourseInfo> getList() {
        return list;
    }

    public void setList(List<OnceCourseInfo> list) {
        this.list = list;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Byte getTerm() {
        return term;
    }

    public void setTerm(Byte term) {
        this.term = term;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "list=" + list +
                ", year=" + year +
                ", term=" + term +
                ", studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                ", clazzName='" + clazzName + '\'' +
                '}';
    }
}
