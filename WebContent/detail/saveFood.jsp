<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
<script type="text/javascript" src="style/js/check.js"></script>
<script type="text/javascript">
	/*$(function() {
		$.ajax({
			type : "POST",
			url : "getFoodType",
			dataType : "json",
			success : function(json) {
				$("#selectType").empty();
				var list = eval("(" + json + ")");
				var result = list.list;
				for (var i = 0; i < result.length; i++) {
					var foodType_id = result[i].foodtypeid;
					var name = result[i].typename;
					var s_option = "<option>" + name + "</option>";
					var $option = $(s_option);
					$option.data("name", foodType_id);
					$("#selectType").append($option);
				}
			}
		});
	});
	$(function(){
		$(".InputStyle").focus(function(){
			var name=$(".InputStyle").val();
			$("#name_msg").html("正在检测");
			$.ajax({
				type : "POST",
				url : "checkFoodName",
				data:{"checkFoodName":name,"cname" :"****"},
				dataType : "json",
				success : function(json) {
					$("#name_msg").empty();
					var list = eval("(" + json + ")");
					var result = list.result;
					$("#name_msg").html(result);
				},
				
			});
		});
		$(".FunctionButtonInput").click(function(){
			var msg=$("#name_msg").val();
			var flag=false;
			if((msg="菜名不可用")||(msg="")){
				flag=true;
			}
			if(flag){
				alert(msg);
				return;
			}
		});
		
	});
	function check(){
		var msg=document.getElementById("name_msg").innerHTML;
		var flag=true;
		if((msg=="菜名不可用")){
			flag=false;
		}
		if(msg=="菜名不能为空"){
			flag=false;
		}
		if(flag==false){
			return false;
		}
	}*/
</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 添加新菜品
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="addFood" method="post" enctype="multipart/form-data">
			<!-- 本段标题（分段标题） -->
			<div class="ItemBlock_Title">
				<img width="4" height="7" border="0"
					src="style/images/item_point.gif"> 菜品信息&nbsp;
			</div>
			<!-- 本段表单字段 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<div class="ItemBlock2">
						<table cellpadding="0" cellspacing="0" class="mainForm">
							<tr>
								<td width="80px">菜系</td>
								<td><select id="selectType" name="foodType_id" style="width: 80px">
									<c:if test="${foodType!=null}">
	                            	<c:forEach items="${foodType}" var="ft">
	                            		<option value="${ft.foodtypeid}">${ft.typename}</option>
	                            	</c:forEach>
	                            </c:if>
								</select> *<input type="hidden" name="id" value="" /></td>
							</tr>
							<tr>
								<td width="80px">菜名</td>
								<td><input type="text" name="foodName" class="InputStyle"
									value="" /> *<span id="name_msg"></span></td>
							</tr>
							<tr>
								<td>价格</td>
								<td><input type="text" name="price" class="InputStyle"
									value="" /> *</td>
							</tr>
							<tr>
								<td>会员价格</td>
								<td><input type="text" name="mprice" class="InputStyle"
									value="" /> *</td>
							</tr>

							<tr>
								<td>简介</td>
								<td><textarea name="remark" class="TextareaStyle"></textarea></td>
							</tr>
							<tr>
								<td width="80px">菜品图片</td>
								<td><input type="file" name="file"/> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" onclick="return check();" value="添加"
					class="FunctionButtonInput"> <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
