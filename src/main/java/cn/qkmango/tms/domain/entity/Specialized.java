package cn.qkmango.tms.domain.entity;


import cn.qkmango.tms.common.validate.group.Insert;
import cn.qkmango.tms.common.validate.group.Update;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 专业实体类
 *
 * @author qkmango
 */
public class Specialized implements Serializable {
    private static final long serialVersionUID = -7352076058910279778L;

    @NotNull(groups = {Update.class})
    private Integer id;
    @NotNull(groups = {Insert.class})
    private Integer faculty;
    private String facultyName;
    @NotBlank(groups = {Insert.class})
    private String name;
    private List<Clazz> clazzList;

    public Specialized() {
    }

    public Specialized(Integer id, Integer faculty, String name, List<Clazz> clazzList) {
        this.id = id;
        this.faculty = faculty;
        this.name = name;
        this.clazzList = clazzList;
    }

    public Specialized(Integer id, Integer faculty, String facultyName, String name, List<Clazz> clazzList) {
        this.id = id;
        this.faculty = faculty;
        this.facultyName = facultyName;
        this.name = name;
        this.clazzList = clazzList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clazz> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<Clazz> clazzList) {
        this.clazzList = clazzList;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Specialized{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", facultyName='" + facultyName + '\'' +
                ", name='" + name + '\'' +
                ", clazzList=" + clazzList +
                '}';
    }
}
