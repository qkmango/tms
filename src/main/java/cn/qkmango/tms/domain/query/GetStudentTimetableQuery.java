package cn.qkmango.tms.domain.query;

import javax.validation.constraints.NotNull;

/**
 * @className: GetStudentTimetableQuery
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-25 16:08
 * @version: 1.0
 */
public class GetStudentTimetableQuery {

    @NotNull
    Integer year;
    @NotNull
    String term;
    Integer id;

    public GetStudentTimetableQuery() {
    }

    public GetStudentTimetableQuery(@NotNull Integer year, @NotNull String term, Integer id) {
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
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
        return "GetStudentTimetableQuery{" +
                "year=" + year +
                ", term=" + term +
                ", id=" + id +
                '}';
    }
}
