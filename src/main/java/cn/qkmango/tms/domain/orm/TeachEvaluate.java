package cn.qkmango.tms.domain.orm;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @className: TeachEvaluate
 * @Description: 教学评价对象
 * student   学生ID
 * elective  选课表ID
 * attitude  教材态度
 * prepare   教学准备
 * content   教学内容
 * method    教学方法
 * thinking  教学思路
 * talk      教学语言
 * tool      教学工具
 * coaching  作业与辅导
 * composite 综合评价
 * remark    评语
 *
 * @author: qkmango
 * @date: 2021-08-18 13:47
 * @version: 1.0
 */
public class TeachEvaluate {


    @NotNull private Integer elective;

    private Integer student;

    @NotNull @Range(min = 1,max = 5) private Integer attitude;
    @NotNull @Range(min = 1,max = 5) private Integer prepare;
    @NotNull @Range(min = 1,max = 5) private Integer content;
    @NotNull @Range(min = 1,max = 5) private Integer method;
    @NotNull @Range(min = 1,max = 5) private Integer thinking;
    @NotNull @Range(min = 1,max = 5) private Integer talk;
    @NotNull @Range(min = 1,max = 5) private Integer tool;
    @NotNull @Range(min = 1,max = 5) private Integer coaching;
    @NotNull @Range(min = 1,max = 5) private Integer composite;

    private String remark;


    public TeachEvaluate() {
    }

    public TeachEvaluate(@NotNull Integer elective, Integer student, @NotNull @Range(min = 1, max = 5) Integer attitude, @NotNull @Range(min = 1, max = 5) Integer prepare, @NotNull @Range(min = 1, max = 5) Integer content, @NotNull @Range(min = 1, max = 5) Integer method, @NotNull @Range(min = 1, max = 5) Integer thinking, @NotNull @Range(min = 1, max = 5) Integer talk, @NotNull @Range(min = 1, max = 5) Integer tool, @NotNull @Range(min = 1, max = 5) Integer coaching, @NotNull @Range(min = 1, max = 5) Integer composite, String remark) {
        this.elective = elective;
        this.student = student;
        this.attitude = attitude;
        this.prepare = prepare;
        this.content = content;
        this.method = method;
        this.thinking = thinking;
        this.talk = talk;
        this.tool = tool;
        this.coaching = coaching;
        this.composite = composite;
        this.remark = remark;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getElective() {
        return elective;
    }

    public void setElective(Integer elective) {
        this.elective = elective;
    }

    public Integer getAttitude() {
        return attitude;
    }

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    public Integer getPrepare() {
        return prepare;
    }

    public void setPrepare(Integer prepare) {
        this.prepare = prepare;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Integer getThinking() {
        return thinking;
    }

    public void setThinking(Integer thinking) {
        this.thinking = thinking;
    }

    public Integer getTalk() {
        return talk;
    }

    public void setTalk(Integer talk) {
        this.talk = talk;
    }

    public Integer getTool() {
        return tool;
    }

    public void setTool(Integer tool) {
        this.tool = tool;
    }

    public Integer getCoaching() {
        return coaching;
    }

    public void setCoaching(Integer coaching) {
        this.coaching = coaching;
    }

    public Integer getComposite() {
        return composite;
    }

    public void setComposite(Integer composite) {
        this.composite = composite;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TeachEvaluate{" +
                "elective=" + elective +
                ", student=" + student +
                ", attitude=" + attitude +
                ", prepare=" + prepare +
                ", content=" + content +
                ", method=" + method +
                ", thinking=" + thinking +
                ", talk=" + talk +
                ", tool=" + tool +
                ", coaching=" + coaching +
                ", composite=" + composite +
                ", remark='" + remark + '\'' +
                '}';
    }
}
