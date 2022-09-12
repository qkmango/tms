package cn.qkmango.tms.domain.param;

import javax.validation.constraints.NotNull;

/**
 * 获取学生课程表查询参数类
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-07-25 16:08
 */
public class GetStudentTimetableParam {

    @NotNull
    Integer year;
    Byte term;
    Integer id;

    public GetStudentTimetableParam() {
    }

    public GetStudentTimetableParam(@NotNull Integer year, Byte term, Integer id) {
        this.year = year;
        this.term = term;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetStudentTimetableParam{" +
                "year=" + year +
                ", term=" + term +
                ", id=" + id +
                '}';
    }
}
