<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	$(function(){
		$("#file").change(function(){
			var fileName = $("#file").val();//获取到文件列表
			console.debug(fileName);
			$("#showImage").attr("src","../upload/"+fileName);
		});
	});
</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 更新新菜品
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<!-- 表单内容 -->
		<form action="updateFood" method="post" enctype="multipart/form-data">
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
								<td><select name="foodType_id" style="width: 80px">
										<c:if test="${foodType!=null}">
											<c:forEach items="${foodType}" var="ft">
												<c:choose>
													<c:when test="${ft.foodtypeid==nf.foodType_id}">
														<option value="${ft.foodtypeid}" selected="selected">${ft.typename}</option>
													</c:when>
													<c:otherwise>
														<option value="${ft.foodtypeid}">${ft.typename}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</c:if>
								</select> *<input type="hidden" name="id" value="${nf.foodId}" /></td>
							</tr>
							<tr>
								<td width="80px">菜名<input type="hidden" id="ckname" value="${nf.foodName}"/></td>
								<td><input type="text" name="foodName" class="InputStyle"
									value="${nf.foodName}" /> *<span id="name_msg"></span></td>
							</tr>
							<tr>
								<td>价格</td>
								<td><input type="text" name="price" class="InputStyle"
									value="${nf.price}" /> *</td>
							</tr>
							<tr>
								<td>会员价格</td>
								<td><input type="text" name="mprice" class="InputStyle"
									value="${nf.mprice}" /> *</td>
							</tr>

							<tr>
								<td>简介</td>
								<td><textarea name="remark" class="TextareaStyle">${nf.remark}</textarea></td>
							</tr>
							<tr>
								<td width="80px">菜品图片</td>
								<td>
								<img id="showImage"
									style='max-width: 68px; width: 68px; width: expression(width &gt; 68 ? "68px" : width "px"); max-width: 68px;'
									src="../upload/${nf.img}"> <input type="hidden"
									name="imageName" value="${nf.img}"> <input id="file" type="file"
									name="file" /> *</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="submit" onclick="return check();" value="修改" class="FunctionButtonInput">
				<a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
			</div>
		</form>
	</div>
</body>
</html>
