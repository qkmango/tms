package cn.qkmango.tms.domain.entity;

import cn.qkmango.tms.common.validate.group.Delete;
import cn.qkmango.tms.common.validate.group.Insert;
import cn.qkmango.tms.common.validate.group.Update;

import javax.validation.constraints.NotBlank;
import java.util.StringJoiner;

/**
 * 系统键值对类
 *
 * @author qkmango
 * @version 1.0
 * @date 2022-07-28 19:20
 */
public class SystemKeyValue {
    @NotBlank(groups = {Insert.InsertSystemKeyValue.class, Delete.DeleteSystemKeyValue.class, Update.UpdateSystemKeyValue.class})
    private String key;
    @NotBlank(groups = {Insert.InsertSystemKeyValue.class})
    private String value;
    @NotBlank(groups = {Insert.InsertSystemKeyValue.class})
    private String description;

    @NotBlank(groups = {Update.UpdateSystemKeyValue.class,})
    private String newKey;
    @NotBlank(groups = {Update.UpdateSystemKeyValue.class})
    private String newValue;
    @NotBlank(groups = {Update.UpdateSystemKeyValue.class})
    private String newDescription;

    public SystemKeyValue() {
    }

    public SystemKeyValue(String key, String value, String description, String newKey, String newValue, String newDescription) {
        this.key = key;
        this.value = value;
        this.description = description;
        this.newKey = newKey;
        this.newValue = newValue;
        this.newDescription = newDescription;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewKey() {
        return newKey;
    }

    public void setNewKey(String newKey) {
        this.newKey = newKey;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SystemKeyValue.class.getSimpleName() + "[", "]")
                .add("key='" + key + "'")
                .add("value='" + value + "'")
                .add("description='" + description + "'")
                .add("newKey='" + newKey + "'")
                .add("newValue='" + newValue + "'")
                .add("newDescription='" + newDescription + "'")
                .toString();
    }
}
