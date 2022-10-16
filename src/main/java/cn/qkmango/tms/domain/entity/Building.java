package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.domain.bind.building.BuildingType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 教学楼
 *
 * @author qkmango
 */
public class Building implements Serializable {

    private static final long serialVersionUID = 7827741338676466017L;
    private Integer id;
    /**
     * 楼号
     * 如 12 12A S4 S4A
     */
    @Pattern(regexp = "^[A-Z]?\\d{1,3}[A-Z]?$", message = "楼号长度在1-4，由数字和最多1个大写字母构成")
    private String number;
    @NotNull
    private String name;
    @NotNull
    private BuildingType buildingType;

    public Building() {
    }

    public Building(Integer id, String number, String name, BuildingType buildingType) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.buildingType = buildingType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", buildingType=" + buildingType +
                '}';
    }
}
