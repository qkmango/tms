// var $ = layui.jquery;
// var cocoMessage = window.parent.cocoMessage;
var form;
var table;
var layer;
let tree;
let util;
let $;
let clazzTreeData;
let teacherTreeData;
layui.use(['form', 'table', 'tree', 'util'], function () {

    form = layui.form;
    table = layui.table;
    layer = layui.layer;
    tree = layui.tree;
    util = layui.util;
    $ = layui.$;

    //获取班级列表
    $.ajax({
        url: '/query/list/tree/getClazzTreeList.do',
        // url: '/test/clazz.json',
        type: 'get',
        dataType: 'json',
        async: false,
        success: function (res) {
            clazzTreeData = copyTransFunc(res, [
                {key: 'name', value: 'title'},
                {key: 'specializedList', value: 'children'},
                {key: 'clazzList', value: 'children'},
            ])
        }
    })
    //获取老师列表
    $.ajax({
        url: '/query/list/tree/getTeacherTreeList.do',
        // url: '/test/teacher.json',
        type: 'get',
        dataType: 'json',
        async: false,
        success: function (res) {
            teacherTreeData = copyTransFunc(res, [
                {key: 'name', value: 'title'},
                {key: 'teacherList', value: 'children'}
            ])
        }
    })


    //基本演示
    tree.render({
        elem: '#selectClazz'
        , data: clazzTreeData
        , showCheckbox: true  //是否显示复选框
        , id: 'selectClazz'
        , isJump: false //是否允许点击节点时弹出新窗口跳转
        , click: function (obj) {
            console.log(obj.data)
            // var data = obj.data;  //获取当前点击的节点数据
            // layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
        }
    });

    //按钮事件
    util.event('lay-demo', {
        getClazzChecked: function (othis) {
            var checkedData = tree.getChecked('selectClazz'); //获取选中节点的数据

            layer.alert(JSON.stringify(checkedData), {shade: 0});

            console.log(checkedData);
        }
    });


    //基本演示
    tree.render({
        elem: '#selectTeacher'
        , data: teacherTreeData
        , showCheckbox: true  //是否显示复选框
        , id: 'selectTeacher'
        , isJump: false //是否允许点击节点时弹出新窗口跳转
        , click: function (obj) {
            console.log(obj.data)
            // var data = obj.data;  //获取当前点击的节点数据
            // layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
        }
    });

    //按钮事件
    util.event('lay-demo', {
        getTeacherChecked: function (othis) {
            var checkedData = tree.getChecked('selectTeacher'); //获取选中节点的数据
            layer.alert(JSON.stringify(checkedData), {shade: 0});
        }
    });


    //

    form.verify({
        //年份验证
        int: function (value, item) {
            return value % 1 === 0 ? false : "取值为整数"
        },
        year: function (value, item) {
            return value >= 2000 && value <= 2100 ? false : '年份取值范围为2000-2100';
        },
        //持续节验证
        length: function (value, item) {
            if (value >= 1 && value <= 4) {
                return false;
            }
            return "取值范围在1-4";
        },
        //验证起始节
        begin: function (value, item) {
            if (value >= 1 && value <= 11) {
                return false;
            }
            return "取值范围在1-11";
        },
        //周验证
        week: function (value, item) {
            if (value >= 1) {
                return false;
            }
            return "取值为>0";
        },
    });

    //添加节次按钮事件
    $('#add').click(function () {
        let len = $(".courseInfoItem").length;
        $("#btnArea").before(getHTML(len));
        form.render(null, 'addCourse');
    })


    //删除节次按钮事件
    $('#del').click(function () {

        let len = $(".courseInfoItem").length;
        if (len <= 1) {
            layer.msg('至少保留一个节次');
            return;
        }

        layer.msg('确认删除最后一个节次吗？', {
            icon: 3,
            time: 0,
            btn: ['取消', '确定'],
            yes: function (index) {
                layer.close(index);
            },
            btn2: function (index) {
                layer.close(index);
                $(".courseInfoItem").get(len - 1).remove();
                form.render(null, 'addCourse');
            }
        });

    })

    // 监听搜索操作
    form.on('submit(data-submit-btn)', function (data) {
        let selectClazzList = tree.getChecked('selectClazz')
        let selectTeacherList = tree.getChecked('selectTeacher')

        // console.log(data.field)
        // console.log(selectClazzList)
        // console.log(selectTeacherList)
        // console.log(Object.keys(data.field))
        // return false;

        let clazzList = [];
        let teacherList = [];
        let courseInfoList = [];

        //处理clazzList
        for (let i = 0; i < selectClazzList.length; i++) {
            for (let j = 0; j < selectClazzList[i].children.length; j++) {
                for (let k = 0; k < selectClazzList[i].children[j].children.length; k++) {
                    clazzList.push(selectClazzList[i].children[j].children[k].id);
                }
            }
        }
        if (clazzList.length === 0) {
            layer.msg("请选择班级", {icon: 5});
            return false;
        }

        //处理teacherList
        for (let i = 0; i < selectTeacherList.length; i++) {
            for (let j = 0; j < selectTeacherList[i].children.length; j++) {
                teacherList.push(selectTeacherList[i].children[j].id);
            }
        }
        if (teacherList.length !== 1) {
            layer.msg("请选择授课老师", {icon: 5});
            return false;
        }

        //处理courseInfoList
        for (let i = 0; true; i++) {
            if (data.field[`courseInfo_${i}.courseType`] !== undefined) {
                courseInfoList.push({
                    courseType:data.field[`courseInfo_${i}.courseType`],
                    weekType:data.field[`courseInfo_${i}.weekType`],
                    beginWeek:data.field[`courseInfo_${i}.beginWeek`],
                    lengthWeek:data.field[`courseInfo_${i}.lengthWeek`],
                    weekDay:data.field[`courseInfo_${i}.weekDay`],
                    begin:data.field[`courseInfo_${i}.begin`],
                    length:data.field[`courseInfo_${i}.length`],
                    address:data.field[`courseInfo_${i}.address`]
                })
            } else {
                break
            }
        }


        //传入后台的参数
        let queryData = {
            course:{
                name:data.field.name,
                credit:data.field.credit,
                teacher:teacherList[0],
                courseYear:data.field.courseYear,
                term:data.field.term
            },
            clazzList,
            courseInfoList
        }

        console.log(queryData)
        // return false

        layer.msg('确认提交吗？', {
            icon: 3,
            time: 0,
            btn: ['取消', '确定'],
            yes: function (index) {
                layer.close(index);
            },
            btn2: function (index) {
                layer.close(index);
                $.ajax({
                    url: 'insert/insertCourse2.do',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(queryData),
                    type: 'post',
                    dataType: 'json',
                    success: function (data) {
                        console.log(data)
                        if (data.success) {
                            layer.msg(data.message, {icon: 1});
                            // cocoMessage.success(2000,data.message);
                        } else {
                            // cocoMessage.error(2000,data.message);
                            layer.msg(data.message, {icon: 5});
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        // cocoMessage.error(2000,jqXHR.status+'');
                        layer.msg(data.message, {icon: 5});
                    }
                })
            }
        });


        return false;
    });


});


//获取节次的HTML
function getHTML(index) {
    // return '<fieldset class="table-search-fieldset courseInfoItem"><legend>节次${index}</legend><div class="layui-form-item"><div  class="layui-inline"><label class="layui-form-label">类型</label><div class="layui-input-inline"><select name="courseInfo_${index}.courseType" lay-verify="required"><option value="">全部</option><option value="theory">理论课</option><option value="practice">实践课</option></select></div></div><div  class="layui-inline"><label class="layui-form-label">单双周</label><div class="layui-input-inline"><select name="courseInfo_${index}.weekType" lay-verify="required"><option value="all">不限</option><option value="sgl">单周</option><option value="dbl">双周</option></select></div></div><div class="layui-inline"><label class="layui-form-label">起始周</label><div class="layui-input-inline"><input type="number" name="courseInfo_${index}.beginWeek" autocomplete="off" class="layui-input" lay-verify="required|int|week"></div></div><div class="layui-inline"><label class="layui-form-label">持续周</label><div class="layui-input-inline"><input type="number" name="courseInfo_${index}.lengthWeek" autocomplete="off" class="layui-input" lay-verify="required|int|week"></div></div><div class="layui-inline"><label class="layui-form-label">星期</label><div class="layui-input-inline"><select name="courseInfo_${index}.weekDay" lay-verify="required"><option value="">全部</option><option value="Monday">周一</option><option value="Tuesday">周二</option><option value="Wednesday">周三</option><option value="Thursday">周四</option><option value="Friday">周五</option><option value="Saturday">周六</option><option value="Sunday">周日</option></select></div></div><div class="layui-inline"><label class="layui-form-label">起始节</label><div class="layui-input-inline"><input type="number" name="courseInfo_${index}.begin" autocomplete="off" class="layui-input" lay-verify="required|int|begin"></div></div><div class="layui-inline"><label class="layui-form-label">持续节</label><div class="layui-input-inline"><input type="number" name="courseInfo_${index}.length" autocomplete="off" class="layui-input" lay-verify="required|int|length" placeholder="1-4"></div></div><div class="layui-inline"><label class="layui-form-label">教室ID</label><div class="layui-input-inline"><input type="number" name="courseInfo_${index}.address" autocomplete="off" class="layui-input" lay-verify="required"></div></div></div></fieldset>';
    return`
<fieldset class="table-search-fieldset courseInfoItem">
    <legend>节次${index}</legend>
    <div class="layui-form-item">
        <div  class="layui-inline">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-inline">
                <select name="courseInfo_${index}.courseType" lay-verify="required">
                    <option value="">全部</option>
                    <option value="theory">理论课</option>
                    <option value="practice">实践课</option>
                </select>
            </div>
        </div>
        
        <div  class="layui-inline">
            <label class="layui-form-label">单双周</label>
            <div class="layui-input-inline">
                <select name="courseInfo_${index}.weekType" lay-verify="required">
                    <option value="all">不限</option>
                    <option value="sgl">单周</option>
                    <option value="dbl">双周</option>
                </select>
            </div>
        </div>
        
        <div class="layui-inline">
            <label class="layui-form-label">起始周</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.beginWeek" autocomplete="off" class="layui-input" lay-verify="required|int|week"></div>
            </div>
            
        <div class="layui-inline">
            <label class="layui-form-label">持续周</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.lengthWeek" autocomplete="off" class="layui-input" lay-verify="required|int|week">
            </div>
        </div>
        
        <div class="layui-inline">
            <label class="layui-form-label">星期</label>
            <div class="layui-input-inline">
                <select name="courseInfo_${index}.weekDay" lay-verify="required">
                    <option value="">全部</option>
                    <option value="Monday">周一</option>
                    <option value="Tuesday">周二</option>
                    <option value="Wednesday">周三</option>
                    <option value="Thursday">周四</option>
                    <option value="Friday">周五</option>
                    <option value="Saturday">周六</option>
                    <option value="Sunday">周日</option>
                </select>
            </div>
        </div>
        
        <div class="layui-inline">
            <label class="layui-form-label">起始节</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.begin" autocomplete="off" class="layui-input" lay-verify="required|int|begin">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">持续节</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.length" autocomplete="off" class="layui-input" lay-verify="required|int|length" placeholder="1-4">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">教室ID</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.address" autocomplete="off" class="layui-input" lay-verify="required">
            </div>
        </div>
    </div>
</fieldset>`;
}

