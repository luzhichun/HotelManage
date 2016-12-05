<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/css/index.css" />
<script type="text/javascript" src="style/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	 // 删除菜品项
	function removeSorder(food_id,orderId) {
		console.debug(food_id);
		console.debug(orderId);
		window.location.href = "deleteDetail?orderId="+orderId+"&food_id="+food_id;
	}
	// 修改菜品项数量
	function alterSorder(food_id,price,orderId,node) {
		var count=node.value;
		$(function(){
			$("#sun").html(count*price);
			$.ajax({
				type:"POST",
				url:"changeCount",
				data:{"orderId":orderId,"food_id":food_id,"foodCount":count},
				dataType : "json",
				success:function(json){
					var list = eval("(" + json + ")");
					var totalPay=list.totalPay
					$("#total").html(totalPay);
				}
			});
		});
	}
	// 下单
	function genernateOrder() {
		window.location.href = "createOrder";
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
						<td align="center" width="20%">操作</td>
					</tr>
					<c:if test="${odList!=null }">
						<c:forEach items="${odList}" var="od">
							<tr height="60">
								<td align="center" width="20%">${od.foodName}</td>
								<td id="price" align="center" width="20%">&yen;${od.price}</td>
								<td align="center" width="20%"><input class="count" type="text"
									value="${od.foodCount}" size="3" lang="3"
									onchange="alterSorder(${od.food_id},${od.price},${od.orderId },this)" /></td>
								<td id="sun" align="center" width="20%">&yen;${od.price*od.foodCount}</td>
								<td align="center" width="20%"><input type="button"
									value="删除" class="btn_next" lang="3"
									onclick="removeSorder(${od.food_id},${od.orderId })" /></td>

							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td colspan="6" align="right">总计: <span id="total"
							style="font-size: 36px;">&yen;&nbsp;${totalPay }</span> <label id="counter"
							style="font-size: 36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"
							align="right"><input type="hidden" name="bId" value="">
							<input type="button" value="下单" class="btn_next"
							onclick="genernateOrder()" /></td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
					<li class="dish_num"></li>
					<li><a href="clientOrderList.jsp"> <img
							src="style/images/call2.gif" />
					</a></li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					<c:if test="${ftl!=null }">
						<c:forEach items="${ftl}" var="ft">
							<li><a href="menusByType?foodtypeid=${ft.foodtypeid}&&foodName=${null}">${ft.typename}</a></li>
						</c:forEach>
					</c:if>
				</ul>
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
							<td><a href="menus?foodName=${null}"> <img src="style/images/look.gif" />
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
