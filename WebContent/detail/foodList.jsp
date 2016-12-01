<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="foodList" method="post">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        	<c:if test="${list!=null}">
        		<c:forEach items="${list}" var="f">
        			<tr class="TableDetail1">
						<td>${f.foodId}&nbsp;</td>
						<td>${f.foodName}&nbsp;</td>
						<td>${f.foodType}&nbsp;</td>
						<td>${f.price}&nbsp;</td>
		                <td>${f.mprice}&nbsp;</td>
						<td>
							<a href="selectById?foodId=${f.foodId}"  class="FunctionButton">更新</a>				
							<a href="deleteFood?foodId=${f.foodId}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
						</td>
					</tr>
        		</c:forEach>
        	</c:if>
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="beforeSaveFood">添加</a></div>
		<div class="FunctionButton">
				<a href="foodList?currentPage=1">首页</a>
			</div>
			<c:choose>
				<c:when test="${FcurrentPage>1}">
					<div class="FunctionButton">
						<a href="foodList?currentPage=${FcurrentPage-1}">上一页</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="FunctionButton">
						<a href="#">上一页</a>
					</div>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="1" end="${FtotalPage}" var="p">
				<c:choose>
					<c:when test="${p==FcurrentPage}">
						<div class="FunctionButton">
							<a href="foodList?currentPage=${p}"
								style="background: #FFF; border: #89bdd8 solid 1px; color: #067db5">${p}</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="FunctionButton">
							<a href="foodList?currentPage=${p}">${p}</a>
						</div>
					</c:otherwise>
				</c:choose>>
			</c:forEach>
			<c:choose>
				<c:when test="${FcurrentPage<FtotalPage}">
					<div class="FunctionButton">
						<a href="foodList?currentPage=${FcurrentPage+1}">下一页</a>
					</div>
				</c:when>
				<c:otherwise>
					<div class="FunctionButton">
						<a href="#">下一页</a>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="FunctionButton">
				<a href="foodList?currentPage=${FtotalPage}">尾页</a>
			</div>
    </div> 
</div>
</body>
</html>
