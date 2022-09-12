package cn.qkmango.tms.domain.param;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 插入选课信息 插叙参数类
 *
 * @author qkmango
 * @version 1.0
 * @date 2021-07-20 19:55
 */
public class InsertElectiveParam {
    @NotNull(message = "课程ID列表不能为空")
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
