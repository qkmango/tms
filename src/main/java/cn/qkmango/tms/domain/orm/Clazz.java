package cn.qkmango.tms.domain.orm;

public class Clazz {

    private Integer id;
    private String name;
    private Integer specialized;
    private Integer clazzYear;

    public Clazz() {
    }

    public Clazz(Integer id, String name, Integer specialized, Integer clazzYear) {
        this.id = id;
        this.name = name;
        this.specialized = specialized;
        this.clazzYear = clazzYear;
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

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    public Integer getClazzYear() {
        return clazzYear;
    }

    public void setClazzYear(Integer clazzYear) {
        this.clazzYear = clazzYear;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz=" + specialized +
                ", year=" + clazzYear +
                '}';
    }
}
