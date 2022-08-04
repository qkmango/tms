package cn.qkmango.tms.domain.query;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @className: InsertElectiveQuery
 * @Description: 插入选课的VO，参数接收实体类
 * @author: qkmango
 * @date: 2021-07-20 19:55
 * @version: 1.0
 */
public class InsertElectiveQuery {
    @NotNull(message = "{valid.InsertElectiveQuery.courseIds.NotNull}")
    private Integer[] courseIds;

    private Integer studentId;

    public InsertElectiveQuery() {
    }

    public InsertElectiveQuery(Integer[] courseIds, Integer studentId) {
        this.courseIds = courseIds;
        this.studentId = studentId;
    }

    public Integer[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(Integer[] courseIds) {
        this.courseIds = courseIds;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InsertElectiveQuery.class.getSimpleName() + "[", "]")
                .add("courseIds=" + Arrays.toString(courseIds))
                .add("studentId='" + studentId + "'")
                .toString();
    }
}
