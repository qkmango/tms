package cn.qkmango.tms.domain.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author qkmango
 * @version 1.0
 * @className Calendar
 * @Description 校历
 * @date 2022-08-22 10:43
 */
public class Calendar {
    private Integer id;

    @NotNull
    private Integer year;

    @Size(min = 1,max = 2)
    @NotEmpty
    private String term;

    @Pattern(regexp = "^\\d{4}-\\d{1,2}-\\d{1,2}$")
    private String start;

    @Pattern(regexp = "^\\d{4}-\\d{1,2}-\\d{1,2}$")
    private String end;

    /**
     * 假期格式化字符串
     * 2022-5-1,2,3,4,5,6,7
     * 2022-6-1,2
     */
    private String holiday;

    public Calendar() {
    }

    public Calendar(Integer id, Integer year, String term, String start, String end, String holiday) {
        this.id = id;
        this.year = year;
        this.term = term;
        this.start = start;
        this.end = end;
        this.holiday = holiday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", year=" + year +
                ", term=" + term +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", holiday='" + holiday + '\'' +
                '}';
    }
}
