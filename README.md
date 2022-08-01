# tms

> 教务管理系统

## 功能完成进度

### 系统整体

- [x] 系统登陆
- [x] 系统退出
- [x] 密码修改



### 学生



### 教师

- [x] 学生成绩录入和修改

### 管理员

- [x] 课程发布
- [x] 教学楼增删改查
- [x] 教室的增删改查（分页）
- [x] 年份的增删改查







## 参数校验



### `/insert/insertCourse.do`

> 所属前端页面：page/admin/course/add-course.html

所属数据库表：t_course

所属Java实体对象：Course

| 字段       | 输入类型 | 前端校验 | 后端校验 |
| ---------- | -------- | -------- | -------- |
| ~~id~~     |          |          |          |
| name       | input    |          |          |
| credit     | select   |          |          |
| clazz      | select   |          |          |
| teacher    | select   |          |          |
| courseYear | input    | √        |          |
| term       | select   |          |          |

所属数据库表：t_course_info

所属Java实体对象：CourseInfo

| 字段       | 输入类型 | 前端校验 | 后端校验 |
| ---------- | -------- | -------- | -------- |
| ~~id~~     |          |          |          |
| ~~course~~ |          |          |          |
| courseType | select   |          |          |
| weekType   | select   |          |          |
| startWeek  | input    | √        |          |
| endWeek    | input    | √        |          |
| weekDay    | select   |          |          |
| begin      | input    | √        |          |
| length     | input    | √        |          |
| address    | input    |          |          |



### `/insert/insertBuilding.do`

> 所属前端页面：page/admin/building/building-add.html

所属数据库表：t_building

所属Java实体对象：Building

| 字段         | 输入类型 | 前端校验 | 后端校验 |
| ------------ | -------- | -------- | -------- |
| ~~id~~       |          |          |          |
| number       | input    | √        |          |
| name         | input    |          |          |
| buildingType | radio    |          |          |

### `/update/updateBuilding.do`

> 所属前端页面：page/admin/building/building-edit.html

所属数据库表：t_building

所属Java实体对象：Building

| 字段         | 输入类型 | 前端校验 | 后端校验 |
| ------------ | -------- | -------- | -------- |
| ~~id~~       |          |          |          |
| number       | input    | √        |          |
| name         | input    |          |          |
| buildingType | radio    |          |          |





### `/insert/insertRoom.do`

> 所属前端页面：page/admin/building/room-add.html

所属数据库表：t_room

所属Java实体对象：Room

| 字段     | 输入类型 | 前端校验 | 后端校验 |
| -------- | -------- | -------- | -------- |
| ~~id~~   |          |          |          |
| number   | input    |          |          |
| name     | input    |          |          |
| building | select   |          |          |

### `/insert/updateRoom.do`

> 所属前端页面：page/admin/building/room-edit.html

所属数据库表：t_room

所属Java实体对象：Room

| 字段     | 输入类型 | 前端校验 | 后端校验 |
| -------- | -------- | -------- | -------- |
| ~~id~~   |          |          |          |
| number   | input    | √        |          |
| name     | input    |          |          |
| building | select   |          |          |



### `/insert/insertYear.do`

> 所属前端页面：page/admin/year/year-add.html

所属数据库表：t_year

所属Java实体对象：Year

| 字段     | 输入类型 | 前端校验 | 后端校验 |
| -------- | -------- | -------- | -------- |
| year     | input    | √        |          |
| ~~name~~ |          |          |          |

### `/insert/updateYear.do`

> 所属前端页面：page/admin/year/year-edit.html

所属数据库表：t_year

所属Java实体对象：

| 字段     | 输入类型          | 前端校验 | 后端校验 |
| -------- | ----------------- | -------- | -------- |
| ~~year~~ | input（readonly） |          |          |
| newYear  | input             | √        |          |



### `/update/updatePasswordVO.do`

> 所属前端页面：page/public/update-password.html

所属数据库表：t_student/t_teacher/t_admin

所属Java实体对象：

| 字段          | 输入类型 | 前端校验   | 后端校验 |
| ------------- | -------- | ---------- | -------- |
| oldPassword   | input    | 一致性校验 |          |
| againPassword | input    | 一致性校验 |          |



### `/update/updateStudentScore.do`

> 所属前端页面：page/teacher/edit-student-score.html

所属数据库表：t_elective

所属Java实体对象：

| 字段   | 输入类型 | 前端校验 | 后端校验 |
| ------ | -------- | -------- | -------- |
| course | input    |          |          |






# 国际化
## 控制器参数字段合法性验证消息
国际化文件
- classpath:valid_en_US.properties
- classpath:valid_zh_CN.properties

键名规范 
- `valid.类名.字段名.校验注解名`
- 如 `valid.User.password.NotEmpty=密码不能为空`

## 通过接口对数据库的操作
国际化文件
- classpath:db_en_US.properties
- classpath:db_zh_CN.properties
键名规范
- `db.接口.状态`
- 如 `db.insertCourse.success=插入课程成功`
