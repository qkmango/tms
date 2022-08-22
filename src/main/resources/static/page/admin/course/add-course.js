// var $ = layui.jquery;
// var cocoMessage = window.parent.cocoMessage;
let form;
let table;
let layer;
let tree;
let util;
let $;
let clazzTreeData;
let teacherTreeData;
const cocoMessage = window.top.cocoMessage;
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
            clazzTreeData = copyTransFunc(res.data, [
                {key: 'name', value: 'title'},
                {key: 'specializedList', value: 'children'},
                {key: 'clazzList', value: 'children'},
            ])
            //将学院和专业的id前加上前缀，防止与clazz的id重复
            for (let i = 0; i < clazzTreeData.length; i++) {
                clazzTreeData[i].id = 'f' + clazzTreeData[i].id;
                for (let j = 0; j < clazzTreeData[i].children.length; j++) {
                    clazzTreeData[i].children[j].id = 's' + clazzTreeData[i].children[j].id;
                }
            }
            console.log(clazzTreeData)
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
            //将对象的属性名name换成title，teacherList换成children
            teacherTreeData = copyTransFunc(res.data, [
                {key: 'name', value: 'title'},
                {key: 'teacherList', value: 'children'}
            ])
            //将学院的id前加上前缀，防止与teacher的id重复
            for (let i = 0; i < teacherTreeData.length; i++) {
                teacherTreeData[i].id = 'f' + teacherTreeData[i].id;
            }
            console.log(teacherTreeData)
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

    //获取选中数据 按钮事件
    util.event('lay-select-tree-data', {
        //将选中的数据 拼接 ID_班级名，并弹窗显示
        getClazzChecked: function (othis) {
            let checkedData = tree.getChecked('selectClazz'); //获取选中节点的数据
            let selectClazzNameListStr = '';

            let arr = getTreeCheckedDataListDeep3(checkedData);
            for (let arrElement of arr) {
                selectClazzNameListStr += `${arrElement.id}_${arrElement.title}<br/>`
            }

            layer.alert(selectClazzNameListStr, {
                title:'选中的班级',
                shadeClose: true,
                closeBtn: 0,
                btn:false
            });
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
    util.event('lay-select-tree-data', {
        //将选中的数据 拼接 ID_老师名，并弹窗显示
        getTeacherChecked: function (othis) {
            let checkedData = tree.getChecked('selectTeacher'); //获取选中节点的数据
            let selectTeacherNameListStr = '';
            let arr = getTreeCheckedDataListDeep2(checkedData);
            for (let arrElement of arr) {
                selectTeacherNameListStr += `${arrElement.id}_${arrElement.title}<br/>`
            }
            layer.alert(selectTeacherNameListStr,{
                title:'选中的老师',
                shadeClose: true,
                closeBtn: 0,
                btn:false
            });

        }
    });


    form.verify(layui_verify_config);

    //获取选中数据 按钮事件
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

    // 监听提交操作
    form.on('submit(data-submit-btn)', function (data) {
        let selectClazzList = tree.getChecked('selectClazz')
        let selectTeacherList = tree.getChecked('selectTeacher')

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
                    courseType: data.field[`courseInfo_${i}.courseType`],
                    weekType: data.field[`courseInfo_${i}.weekType`],
                    beginWeek: data.field[`courseInfo_${i}.beginWeek`],
                    lengthWeek: data.field[`courseInfo_${i}.lengthWeek`],
                    weekDay: data.field[`courseInfo_${i}.weekDay`],
                    begin: data.field[`courseInfo_${i}.begin`],
                    length: data.field[`courseInfo_${i}.length`],
                    address: data.field[`courseInfo_${i}.address`]
                })
            } else {
                break
            }
        }


        //传入后台的参数
        let requestData = {
            course: {
                name: data.field.name,
                credit: data.field.credit,
                teacher: teacherList[0],
                courseYear: data.field.courseYear,
                term: data.field.term
            },
            clazzList,
            courseInfoList
        }

        console.log(requestData)

        layer.msg('确认提交吗？', {
            icon: 3,
            time: 0,
            btn: ['确定', '取消'],
            offset: '100px',
            btn2: function (index) {
                layer.close(index);
            },
            yes: function (index) {
                layer.close(index);
                $.ajax({
                    url: 'insert/insertCourse.do',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(requestData),
                    type: 'post',
                    dataType: 'json',
                    success: function (data) {
                        console.log(data)
                        if (data.success) {
                            cocoMessage.success(data.message)
                        } else {
                            cocoMessage.error(data.message)
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        cocoMessage.error(jqXHR.status + '');
                    }
                })
            }
        });


        return false;
    });


});


//获取节次的HTML
function getHTML(index) {
    return `
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
                <input type="number" name="courseInfo_${index}.beginWeek" autocomplete="off" class="layui-input" lay-verify="required|int|courseInfoWeek"></div>
            </div>
            
        <div class="layui-inline">
            <label class="layui-form-label">持续周</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.lengthWeek" autocomplete="off" class="layui-input" lay-verify="required|int|courseInfoWeek">
            </div>
        </div>
        
        <div class="layui-inline">
            <label class="layui-form-label">星期</label>
            <div class="layui-input-inline">
                <select name="courseInfo_${index}.weekDay" lay-verify="required">
                    <option value="">全部</option>
                    <option value="1">周一</option>
                    <option value="2">周二</option>
                    <option value="3">周三</option>
                    <option value="4">周四</option>
                    <option value="5">周五</option>
                    <option value="6">周六</option>
                    <option value="7">周日</option>
                </select>
            </div>
        </div>
        
        <div class="layui-inline">
            <label class="layui-form-label">起始节</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.begin" autocomplete="off" class="layui-input" lay-verify="required|int|courseInfoBegin">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">持续节</label>
            <div class="layui-input-inline">
                <input type="number" name="courseInfo_${index}.length" autocomplete="off" class="layui-input" lay-verify="required|int|courseInfoLength" placeholder="1-4">
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

