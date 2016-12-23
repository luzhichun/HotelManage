<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="login/style/register-login.css">
	<script type="text/javascript">
	/*
	$(function(){  
        var pwd1=$("#pwd1").val();  
          
        if(pwd1!=""){  
        $.ajax({  
               type: "POST",  
               url: "servletPwd",  
               data: $("#loginForm").serialize(),  
               success: function(ma){  
                   ma=$.parseJSON(ma);  
                     if(ma.success=="true"){  
                         document.getElementById("showmessage2").innerHTML="密码正确";    
                     }else{  
                         document.getElementById("showmessage2").innerHTML="两次输入的密码不一致";  
                           
                     }
            });  
        }else{  
            document.getElementById("showmessage2").innerHTML="请输入密码";  
        }  
          
    }  
      */
	</script>
	<style type="text/css">
		.cent-box-header .main-title{
			width: 160px;
			height: 74px;
			margin: 0 auto;
			background: url('login/images/register.png') no-repeat;
			background-size: contain;
		}
	</style>
</head>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">注册</h1>
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
			<form action="Register">
				
				<div class="group-ipt name">
					<input type="text" name="name" id="NAME" class="ipt" placeholder="输入您的登录账号" required>
				</div>
				<span id="name_msg"></span>
				<div class="group-ipt password">
					<input type="password" name="pwd" id="password" class="ipt_pwd" placeholder="输入您的登录密码" required>
				</div>
				
				<div class="group-ipt password">
					<input type="password" name="pwd_confirm" id="password" class="ipt_confirm" placeholder="确认您的登录密码" required>
				</div>
				<span id="pwd_msg"></span>
				<div >
					<select id="options" name="usertypeId" style="width: 100%;height:35px;align:center">
						<option   value="1" style="font-size:14px">管理员
						</option>
						<option   value="2">顾客
						</option>
					</select>
					
					
				</div>
				<div class="button">
					<button type="submit" class="login-btn register-btn" id="button" onclick="return check()">注册</button>
				</div>
	
		
			</form>
				
	</div>	<!--  <div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" maxlength="4" placeholder="输入验证码" required>
					<img src="qcode.jsp" class="imgcode">
				</div>-->
			</div>
				<div >已有账号？<a href="login.jsp" class=register>点击登录</a>
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
<script type="text/javascript" src="login/js/checkRegister.js"></script>
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
