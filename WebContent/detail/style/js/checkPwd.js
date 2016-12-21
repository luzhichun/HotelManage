$(function() {
	$(".ipt_confirm").blur(function() {
		var pwd = $(".ipt_pwd").val();
		var cpwd=$(this).val();
		if(pwd==cpwd){
			
			$("#pwd_msg").html("密码可用");
		
		}else{
			$("#pwd_msg").html("两次输入不同，密码不可用");
		}
		
	})	
		
})
	

function check() {
	var msg = document.getElementById("pwd_msg").innerHTML;
	var flag = true;
	if (msg == "密码可用") {
		flag = true;
		return true ;
	}
	if ((msg == "两次输入不同，密码不可用")) {
		flag = false;
	}
	if (flag == false) {
		return false;
	}
}