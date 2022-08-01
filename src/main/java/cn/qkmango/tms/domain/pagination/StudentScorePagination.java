package cn.qkmango.tms.domain.pagination;

public class StudentScorePagination extends Pagination {

    //学生ID
    private Integer id;
    //学生姓名
    private String name;
    //授课老师ID
    private Integer teacher;
    //院系ID
    private Integer faculty;
    //专业ID
    private Integer specialized;
    //班级ID
    private Integer clazz;
    //学科（专业课）ID
    private Integer course;
    //学科 开设年份
    private Integer courseYear;
    //学期，false 上学期，true 下学期
    private Boolean term;
    //班级 年级（如 2020级）
    private Integer clazzYear;
    //课程 名称
    private String courseName;



    public StudentScorePagination() {
    }

    public StudentScorePagination(Integer page, Integer limit, Boolean pagination, Integer id, String name, Integer teacher, Integer faculty, Integer specialized, Integer clazz, Integer course, Integer courseYear, Integer clazzYear, Boolean term, String courseName) {
        super(page, limit, pagination);
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.faculty = faculty;
        this.specialized = specialized;
        this.clazz = clazz;
        this.course = course;
        this.courseYear = courseYear;
        this.clazzYear = clazzYear;
        this.term = term;
        this.courseName = courseName;
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

    public Integer getTeacher() {
        return teacher;
    }

    public void setTeacher(Integer teacher) {
        this.teacher = teacher;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(Integer courseYear) {
        this.courseYear = courseYear;
    }

    public Integer getClazzYear() {
        return clazzYear;
    }

    public void setClazzYear(Integer clazzYear) {
        this.clazzYear = clazzYear;
    }

    public Boolean getTerm() {
        return term;
    }

    public void setTerm(Boolean term) {
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "StudentScorePagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", pagination=" + pagination +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", faculty=" + faculty +
                ", specialized=" + specialized +
                ", clazz=" + clazz +
                ", course=" + course +
                ", courseYear=" + courseYear +
                ", term=" + term +
                ", clazzYear=" + clazzYear +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
