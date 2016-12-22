$(function() {
	$("#NAME").blur(function() {
		var name = $(this).val();
		//var changeUrl = "register?action=Register&name="+name;
		if(name==null){
			name="****";
		}
		$("#name_msg").html("正在检测");
		$.ajax({
			type : "POST",
			url : "checkName",
			data : {
				"checkName" : name,
				
			},
			dataType : "json",
			success : function(json) {
				$("#name_msg").empty();
				var list = eval("(" + json + ")");
				var result = list.result;
				$("#name_msg").html(result);
			},
		});
	});
});
$(function() {
	$(".ipt_confirm").blur(function() {
		var pwd = $(".ipt_pwd").val();
		var cpwd=$(this).val();
		if(pwd==cpwd){
			$("#pwd_msg").html(null);
			
		
		}else{
			$("#pwd_msg").html("两次输入不同，密码不可用");
		}
		
	})	
		
})
	

function check() {

	var msg = document.getElementById("name_msg").innerHTML;
	var flag = true;
	if ((msg == "登录名已经存在")) {
		flag = false;
	}
	if (msg == "登录名不能为空") {
		flag = false;
	}
	if (flag == false) {
		return false;
	}
	var msg1 = document.getElementById("pwd_msg").innerHTML;
	
	
	if ((msg1 == "两次输入不同，密码不可用")) {
		flag = false;
	}
	if (flag == false) {
		return false;
	}
}






