<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="login/style/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">登录</h1>
		<h2 class="sub-title">您身边的美食专家 - Thousands Food</h2>
	</div>

	<div class="cont-main clearfix">

		<!--
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="login.jsp" class="active">登录</a>
				<a href="register.jsp">注册</a>
				<div class="slide-bar"></div>
			</div>
		</div>
	-->

		<div class="login form">
			<div class="group">
			<form action="Login">
			<div class="group-ipt email">
					<input type="text" name="name" id="email" class="ipt" placeholder="输入您的登录账号" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="pwd" id="password" class="ipt" placeholder="输入您的登录密码" required>
				</div>
				<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>
			</form>
				
				<!--  <div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" maxlength="4" placeholder="输入验证码" required>
					<img src="qcode.jsp" class="imgcode">
				</div>-->
			</div>
		</div>

		

		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<!--
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		-->
		</div>
	</div>
</div>

<div class="footer">
	<p>好吃么 - 您身边的美食专家</p>
	<p>Designed By NJTechCISE & <a href="http://cise.njtech.edu.cn" target="_blank">cise.njtech.edu.cn</a> @2016</p>
</div>

<script src='login/js/particles.js' type="text/javascript"></script>
<script src='login/js/background.js' type="text/javascript"></script>
<script src='login/js/jquery.min.js' type="text/javascript"></script>
<script src='login/js/layer/layer.js' type="text/javascript"></script>
<script src='login/js/index.js' type="text/javascript"></script>
<script>
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','qcode.jsp?id=' + Math.random());
	});
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
</script>
</body>
</html>
