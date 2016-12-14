<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style/css/index.css" />
	<script type="text/javascript" src="style/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript">
		// 通知服务员结账
		function callPay(node) {
			window.location.href = "jiezhang";
		}
	</script>
</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
				 		<td align="center" width="20%">菜名</td>
				 		<td align="center" width="20%">单价</td>
				 		<td align="center" width="20%">数量</td>
				 		<td align="center" width="20%">小计</td>
				 	</tr>
					<c:if test="${odList!=null }">
						<c:forEach items="${odList}" var="od">
							<tr height="60">
					 		<td align="center" width="20%">${od.foodName}</td>
					 		<td align="center" width="20%">&yen;${od.price}</td>
					 		<td align="center" width="20%">${od.foodCount}</td>
					 		<td align="center" width="20%">&yen;${od.price*od.foodCount}</td>
				 		</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;</span>
							<label
								id="counter" style="font-size:36px">${totalPay}</label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							<input type="button" value="结账" class="btn_next" lang="" onclick="callPay(this)" />
						</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
					<li class="dish_num"></li>
					<li><a href="cart"> <img
							src="style/images/call2.gif" />
					</a></li>
				</ul>
			</div>

			<div id="dish_2">
			<input id="btn_top" type="button" value="上一页" style="background:none">
			<input id="currentPage" name="当前页" type="hidden" value="${FTcurrentPage}"/>
			<input id="totalPage"name="总页数" type="hidden" value="${FTtotalPage}"/>
				<ul id="typeList">
					<c:if test="${ftl!=null }">
						<c:forEach items="${ftl}" var="ft">
							<li><a
								href="menusByType?foodtypeid=${ft.foodtypeid}&&foodName=${null}&&FFcurrentPage=1&&type=1">${ft.typename}</a></li>
						</c:forEach>
					</c:if>
				</ul>
				<input id="btn_foot"  type="button" value="下一页" style="background:none">
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="menus" method="post">
					<table width="166px">
						<tr>
							<td><input type="text" id="dish_name" name="foodName"
								class="select_value" /> <input type="hidden" value="selectFood"
								name="method"></td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td><a href="menus?foodName=${null}&&type=0"> <img src="style/images/look.gif" />
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		
	</div>
</body>
</html>
