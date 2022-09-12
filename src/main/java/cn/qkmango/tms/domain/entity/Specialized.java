package cn.qkmango.tms.domain.entity;


import java.util.List;

/**
 * 专业实体类
 *
 * @author qkmango
 */
public class Specialized {

    private Integer id;
    private Integer faculty;
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

    @Override
    public String toString() {
        return "Specialized{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                ", clazzList=" + clazzList +
                '}';
    }
}
