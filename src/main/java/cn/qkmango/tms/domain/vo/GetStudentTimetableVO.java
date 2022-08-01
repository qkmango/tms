package cn.qkmango.tms.domain.vo;

import javax.validation.constraints.NotNull;

/**
 * @className: GetStudentTimetableVO
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-25 16:08
 * @version: 1.0
 */
public class GetStudentTimetableVO {

    @NotNull
    Integer year;
    @NotNull
    Boolean term;
    Integer id;

    public GetStudentTimetableVO() {
    }

    public GetStudentTimetableVO(@NotNull Integer year, @NotNull Boolean term, Integer id) {
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

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
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
        return "GetStudentTimetableVO{" +
                "year=" + year +
                ", term=" + term +
                ", id=" + id +
                '}';
    }
}
