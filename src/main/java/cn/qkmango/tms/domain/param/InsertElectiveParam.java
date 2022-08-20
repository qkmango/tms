package cn.qkmango.tms.domain.param;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @className: InsertElectiveParam
 * @Description: 插入选课信息 插叙参数类
 * @author: qkmango
 * @date: 2021-07-20 19:55
 * @version: 1.0
 */
public class InsertElectiveParam {
    @NotNull(message = "{valid.InsertElectiveParam.courseIds.NotNull}")
    private Integer[] courseIds;

    private Integer studentId;

    public InsertElectiveParam() {
    }

    public InsertElectiveParam(Integer[] courseIds, Integer studentId) {
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
        return new StringJoiner(", ", InsertElectiveParam.class.getSimpleName() + "[", "]")
                .add("courseIds=" + Arrays.toString(courseIds))
                .add("studentId='" + studentId + "'")
                .toString();
    }
}
