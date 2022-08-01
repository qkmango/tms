package cn.qkmango.tms.domain.vo;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @className: InsertElectiveVO
 * @Description:TODO
 * @author: qkmango
 * @date: 2021-07-20 19:55
 * @version: 1.0
 */
public class InsertElectiveVO {
    @NotNull(message = "{valid.InsertElectiveVO.courseIds.NotNull}")
    Integer[] courseIds;

    public InsertElectiveVO() {
    }

    public InsertElectiveVO(Integer[] courseIds) {
        this.courseIds = courseIds;
    }

    public Integer[] getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(Integer[] courseIds) {
        this.courseIds = courseIds;
    }

    @Override
    public String toString() {
        return "InsertElectiveVO{" +
                "courseIds=" + Arrays.toString(courseIds) +
                '}';
    }
}
