const $ = layui.jquery;
const cocoMessage = window.parent.cocoMessage;
let form;
let table;
let tree;
let clazzTreeData;

layui.use(['form', 'table','tree'], function () {

	form = layui.form;
	table = layui.table;
	tree = layui.tree;

	form.val('queryParams',{
		teacher:JSON.parse(sessionStorage.user).id,
		courseYear:sessionStorage.currYear,
		term:sessionStorage.currTerm
	})

	//获取班级tree列表
	$.ajax({
		url: '/query/list/tree/getClazzTreeList.do',
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
		}
	})

	tree.render({
		elem: '#selectClazz'
		, data: clazzTreeData
		, showCheckbox: true  //是否显示复选框
		, id: 'selectClazz'
		, isJump: false //是否允许点击节点时弹出新窗口跳转
		, click: function (obj) {
			// var data = obj.data;  //获取当前点击的节点数据
			// layer.msg('状态：' + obj.state + '<br>节点数据：' + JSON.stringify(data));
		}
		,oncheck: function(obj){
			let checkedData = tree.getChecked('selectClazz')
			let arr = getTreeCheckedDataIDListDeep3(checkedData)
			let formQueryParams = form.val('queryParams')
			let queryParam = {
				clazz: arr.toString(),
				teacher: formQueryParams.teacher,
				courseYear: formQueryParams.courseYear,
				term: formQueryParams.term
			}
			getCourseList(queryParam)
		}
	});

	table.render({
		elem: '#dataGrid',
		url: 'query/pagination/getStudentScorePagination.do',
		toolbar: true,
		parseData: function(res){
		    return {
		      "code": res.success==true?0:-1,
		      "msg": res.message,
		      "count": res.count,
		      "data": res.data
		    };
		},
		defaultToolbar: ['filter', 'exports', 'print', {
			title: '单击分数框即可编辑更改分数',
			layEvent: 'LAYTABLE_TIPS',
			icon: 'layui-icon-tips'
		}],
		cols: [[
			{field: 'student', width: 100, title: '学生ID', sort: true},
			{field: 'name', width: 120, title: '姓名'},
			{field: 'courseName', width: 140, title: '课程'},
			{field: 'teacher', width: 100, title: '任课老师'},
			{field: 'clazz', title: '班级'},
			{field: 'specialized', title: '专业'},
			{field: 'faculty',title: '学院'},
			{field: 'courseYear',title: '学年',width:120,templet: function (data){
				return data.courseYear + ' - ' + (data.courseYear+1);
			}},
			{field: 'term',title: '学期',width:80},
			{field: 'elective',title: '选课表记录ID',hide:true},
			{field: 'score', width: 80, title: '分数',edit:true,
				style:'text-align:right;',
				templet:function (data) {
					if (data.score >= 60) {
						return `<div style="color: var(--green_3)">${data.score===undefined?'':data.score}</div>`
					} else {
						return `<div style="color: var(--danger)">${data.score===undefined?'':data.score}</div>`
					}
				}
			}
		]],
		limits: [20, 40, 60, 80, 100, 120],
		limit: 20,
		page: true,
		skin: 'line',
		method:'post',
		contentType:'application/json;charset=utf-8',
		where:(function () {
			const queryParams = form.val('queryParams')
			return {
				courseYear: queryParams.courseYear,
				term: queryParams.term
			}
		})()
	});


	//监听单元格编辑
  	table.on('edit(currentTableFilter)', function(obj){
		let value = obj.value //得到修改后的值
		let data = obj.data //得到所在行所有键值
		let field = obj.field; //得到字段

		if(value>100 || value<0) {
			cocoMessage.warning('分数取值在0-100');
			table.reload("dataGrid");
			return;
		}

		$.ajax({
			url:'update/updateStudentScore.do',
			data:{
				id:data.elective,
				score:data.score
			},
			type:'post',
			dataType:'json',
			success:function(data) {
				if(data.success) {
					cocoMessage.success(data.message);
				} else {
					table.reload("dataGrid");
					cocoMessage.error(data.message);
				}
			},
			error: function (jqXHR, textStatus, errorThrown) {
				table.reload("dataGrid");
				cocoMessage.error(jqXHR.status+'');
			}
		})
	  });

	// 监听搜索操作
	form.on('submit(data-search-btn)', function (data) {
		//执行搜索重载
		let checkedData = tree.getChecked('selectClazz');
		let arr = getTreeCheckedDataIDListDeep3(checkedData)
		let queryParam = {
			student: data.field.id,
			name: data.field.name,
			courseYear: data.field.courseYear,
			term: data.field.term,
			course:data.field.course,
			clazz: arr
		}

		table.reload('dataGrid', {
			page: {
				curr: 1
			},
			method:'post',
			contentType:'application/json;charset=utf-8',
			where:queryParam
		}, 'data');

		return false;
	});


});

// 获取指定专业的所有班级列表并渲染
function getCourseList(queryParam) {
	$.ajax({
		url:'query/list/getCourseList.do',
		data:queryParam,
		dataType:'json',
		success:function(data) {
			let html = '<option value="">全部</option>';
			$.each(data.data,function(index, value) {
				html += '<option value='+value.id+'>'+value.name+'</option>';
			});

			document.querySelector('#course').innerHTML = html;
			form.render('select','queryParams');
		}
	})
}
