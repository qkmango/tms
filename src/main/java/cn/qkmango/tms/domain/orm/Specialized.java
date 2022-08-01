package cn.qkmango.tms.domain.orm;


/**
 * 专业实体类
 */
public class Specialized {

    private Integer id;
    private Integer faculty;
    private String name;

    public Specialized() {
    }

    public Specialized(Integer id, Integer faculty, String name) {
        this.id = id;
        this.faculty = faculty;
        this.name = name;
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

    @Override
    public String toString() {
        return "Specialized{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                '}';
    }
}
