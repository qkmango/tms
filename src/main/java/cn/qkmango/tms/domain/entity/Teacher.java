package cn.qkmango.tms.domain.entity;

import java.io.Serializable;

/**
 * 教师
 *
 * @author qkmango
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 4107824742769684166L;
    private Integer id;
    private String name;
    private Integer sex;
    private String password;
    private Integer faculty;
    /** 职称*/
    private String profes;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer sex, String password, Integer faculty, String profes) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.faculty = faculty;
        this.profes = profes;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public String getProfes() {
        return profes;
    }

    public void setProfes(String profes) {
        this.profes = profes;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", faculty=" + faculty +
                ", profes='" + profes + '\'' +
                '}';
    }
}
