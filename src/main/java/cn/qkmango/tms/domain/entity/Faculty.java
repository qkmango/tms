package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.common.validate.group.Insert;
import cn.qkmango.tms.common.validate.group.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * 院系
 *
 * @author qkmango
 */
public class Faculty implements Serializable {
    private static final long serialVersionUID = 5036028095163376600L;
    @NotNull(groups = {Update.UpdateFaculity.class})
    private Integer id;
    @NotBlank(groups = {Update.UpdateFaculity.class, Insert.class})
    private String name;
    private List<Specialized> specializedList;
    private List<Teacher> teacherList;

    public Faculty() {
    }

    public Faculty(Integer id, String name, List<Specialized> specializedList, List<Teacher> teacherList) {
        this.id = id;
        this.name = name;
        this.specializedList = specializedList;
        this.teacherList = teacherList;
    }

    public List<Specialized> getSpecializedList() {
        return specializedList;
    }

    public void setSpecializedList(List<Specialized> specializedList) {
        this.specializedList = specializedList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Faculty.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("specializedList=" + specializedList)
                .add("teacherList=" + teacherList)
                .toString();
    }
}
