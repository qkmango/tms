//是否正在执行ajax，防止过次点击执行
var isAjax = false;

$(function() {
	var $inputs = $("input");
	var id = $('#id')[0];
	var password = $('#password')[0];
	var button = $('#login_btn')[0];
	var $error_tips = $(".tip");
	var id_errorTip = $error_tips[0];
	var password_errorTip = $error_tips[1];
	

	id.onblur = chechid;
	
	password.onblur = checkPassword;
	
	function chechid() {
		if(check(id.value)) {
			id_errorTip.innerText='';
			return true;
		} else{
			id_errorTip.innerText='用户名长度不合法';
			return false;
		}
	}
	
	function checkPassword() {
		if(check(password.value)) {
			password_errorTip.innerText='';
			return true;
		} else{
			password_errorTip.innerText='密码长度不合法';
			return false;
		}
	}

	//登陆按钮绑定监听时间 登陆
	button.onclick = function() {
		if(chechid() & checkPassword()) {
			if(isAjax) {
				console.log('无效');
				return;
			}
			console.log('有效');
			isAjax = true;
			login();
		}
	}
	
	
	let locale = getLocale();
	if(locale == 'en-US') {
		document.querySelector('#en_US').className = 'this_locale_btn';
	} else {
		document.querySelector('#zh_CN').className = 'this_locale_btn';
	}

})

function check(str) {
	// if(str.length>=5 && str.length <=10) {
	// 	return true;
	// }
	// return false;
	
	return true;
}

function login() {
	console.log('ajax'+new Date())
	$.ajax({
		url:"system/login.do",
		async:false,
		data:{
			id:$.trim($("#id").val()),
			password:$.trim($("#password").val()),
			permissionType:$('#permissionType').val()
		},
		type:"post",
		dataType:"json",
		success:function (data) {
			if (data.success) {
				console.log("登陆成功");
				window.location.href = "index.html";
			} else{
				cocoMessage.error(2000,data.message,function() {
					isAjax = false;
				})
			}
		},
		error: function (jqXHR, textStatus, errorThrown) {
			console.log(jqXHR.status);
			cocoMessage.error(2000,jqXHR.status+'',function() {
				isAjax = false;
			});
		}
	})
}


/**
 * 获取本地语言，基于cookie
 */

function getLocale(name) {
	if(name == undefined) {
		name = 'org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE';
	}
	return getCookie(name);
}

/**
 * 更改语言
 */
function changeLocale(locale) {
	$.ajax({
		url:'system/setLocale.do',
		data:{
			locale
		},
		success:function(data){
			if(data.success) {
				window.location.reload();
			}
		}
	})
}