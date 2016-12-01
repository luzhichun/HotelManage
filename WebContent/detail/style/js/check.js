$(function() {
	$(".InputStyle").focus(function() {
		var name = $(".InputStyle").val();
		var cname=$("#ckname").val();
		if(cname==null){
			cname="****";
		}
		$("#name_msg").html("正在检测");
		$.ajax({
			type : "POST",
			url : "checkFoodName",
			data : {
				"checkFoodName" : name,
				"cname" : cname
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
function check() {
	var msg = document.getElementById("name_msg").innerHTML;
	var flag = true;
	if ((msg == "菜名不可用")) {
		flag = false;
	}
	if (msg == "菜名不能为空") {
		flag = false;
	}
	if (flag == false) {
		return false;
	}
}