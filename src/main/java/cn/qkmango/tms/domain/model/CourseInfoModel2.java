package cn.qkmango.tms.domain.model;

import cn.qkmango.tms.domain.orm.CourseInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author qkmango
 * @version 1.0
 * @className CourseInfoModel2
 * @Description TODO
 * @date 2022-08-03 17:34
 */
public class CourseInfoModel2 {
    @Valid
    @NotNull(message = "{valid.CourseInfoModel.courseInfos.NotNull}")
    private List<CourseInfo> courseInfos;

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }

    public CourseInfoModel2(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }

    public CourseInfoModel2() {}

    public int size() {
        return courseInfos.size();
    }
}

