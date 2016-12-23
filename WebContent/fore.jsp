<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->
<title>选桌页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="wdetail/style/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="wdetail/style/js/page_common.js"></script>
<link href="wdetail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="wdetail/style/css/index_1.css" />
<style type="text/css">
* {
	margin: 0px;
	padding: 0px
}

#dish_2 a {
	text-decoration: none;
	font-size: 36px;
	color: #000;
}

#dish_2 ul {
	list-style: none;
}

#dish_2 li {
	background: url(style/images/img/btn.gif);
	width: 164px;
	height: 47px;
	text-align: center;
	padding-top: 5px;
}
#pageSize:hover{
	cursor:pointer;
}
</style>
<script type="text/javascript">
	$(function(){
		$(".left").click(function(){
			var currentPage=parseInt($("#currentPage").val())-1;
			if(currentPage==0){
				currentPage=1;
				confirm("已经是第一页");
				return;
			}
			$("#currentPage").val(currentPage);
			fun(currentPage);
		});
		$(".right").click(function(){
			var currentPage=parseInt($("#currentPage").val())+1;
			if(currentPage>parseInt($("#totalPage").val())){
				confirm("已经是最后一页");
				return;
			}
			$("#currentPage").val(currentPage);
			fun(currentPage);
		});
		fun(1);
		function fun(currentPage){
			var currentPage=currentPage;
			$.ajax({
				url:"tableList",
				type:"POST",
				data:{"OcurrentPage":currentPage},
				dataType:"json",
				success:function(json){
					$("#tableList").empty();
					var list = eval("(" + json + ")");
					var result = list.list;
					for(var i=0;i<result.length;i++){
						var tableName=result[i].tableName;
						var tableId=result[i].tableId;
						var l_li="<li><a href='menus?tableId="+tableId+"'>"+tableName+"</a></li>";
						var $li=$(l_li);
						$li.data("tableId",tableId);
						$("#tableList").append($li);
					}
				}
			});
		}
	});
	
</script>
</head>
<body style="text-align: center">
	<!--外部的大层-->
	<div class="index_all" style="text-align: center;">
		<!--上面的背景层-->
		<div>
			<!--img src="wdetail/style/images/flower.gif"  -->
			<img src="wdetail/style/images/top01.png" />
		</div>
		<!--中间层-->
		<div id="index_center">
			<!--中间层的空白层-->
			<div id="space"></div>
			<!--中间层的菜单层-->
			<div>
				<!--菜单层的左边-->
				<div id="index_centerleft"></div>
				<!--菜单层的中间-->
				<div class="bg_middle">
					<img src="wdetail/style/images/topic01.png" border="0"
						usemap="#Map" />
					<map name="Map" id="Map">
						<area shape="rect" coords="164,99,354,199" href="#" />
					</map>
				</div>
				<!--中间层的右边-->
				<div id="index_centerright"></div>
			</div>

			<!--放桌子的层-->
			<div id="center_bottom">
				<input id="currentPage" name="当前页" type="hidden" value="${OcurrentPage}"/>
				<span id="pageSize" class="left">&lt;&lt;</span>
				<ul style="display: inline-table" id="tableList">
					<li><a href='#'></a></li>
				</ul>
				<span id="pageSize" class="right">&gt;&gt;</span>
				<input id="totalPage"name="总页数" type="hidden" value="${OtotalPage}"/>
			</div>
		</div>

		<!--下面的背景层-->
		<div>
			<!--img src="wdetail/style/images/flower.gif"  -->
			<img src="wdetail/style/images/bottom01.png" />
		</div>
	</div>
</body>
</html>