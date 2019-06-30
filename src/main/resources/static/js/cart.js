/*按加号数量增*/
function addNum(rid) {
	var n = parseInt($("#goodsCount"+rid).val());

	$("#goodsCount"+rid).val(n + 1);
	calcRow(rid);
}
/*按减号数量减*/
function reduceNum(rid) {
	var n = parseInt($("#goodsCount"+rid).val());
	if (n == 0)
		return;
	$("#goodsCount"+rid).val(n - 1);
	calcRow(rid);
}
/*全选全不选*/
function checkall(ckbtn) {
	$(".ckitem").prop("checked", $(ckbtn).prop("checked"));
	calcTotal();
}
//删除按钮
function delCartItem(btn,id) {
	$.ajax({
		"url":"/carts/del",
		"data":"id=" + id  ,
		"type":"POST",
		"dataType":"json",
		"success":function(json) {
			if (json.state == 200) {
				alert("取消成功！");
				location.reload();
			} else {
				alert(json.message);
			}
		},
		"error":function() {
			alert("您还没有登录，或登录信息已经过期，请重新登录！");
			location.href = "login.html";
		}
	});
	$(btn).parents("tr").remove();
	calcTotal();
}
//批量删除按钮
function selDelCart() {
	//遍历所有按钮
	for (var i = $(".ckitem").length - 1; i >= 0; i--) {
		//如果选中
		if ($(".ckitem")[i].checked) {
			//删除
			$($(".ckitem")[i]).parents("tr").remove();
		}
	}
	calcTotal();
}
$(function() {

})


function selectGoods() {
	//开始时计算价格
	calcTotal();
}

//计算单行小计价格的方法
function calcRow(rid) {
	//取单价
	var vprice = parseFloat($("#goodsPrice"+rid).html());
	//取数量
	var vnum = parseFloat($("#goodsCount"+rid).val());
	//小计金额
	var vtotal = vprice * vnum;
	//赋值
	$("#goodsCast"+rid).html("¥" + vtotal);



}

//计算总价格的方法

function calcTotal() {
	//选中商品的数量
	var vselectCount = 0;
	//选中商品的总价
	var vselectTotal = 0;

	//循环遍历所有tr
	for (var i = 0; i < $(".cart-body tr").length; i++) {
		//计算每个商品的价格小计开始
		//取出1行
		var $tr = $($(".cart-body tr")[i]);
		//取单价
		var vprice = parseFloat($tr.children(":eq(3)").children("span").html());
		//取数量
		var vnum = parseFloat($tr.children(":eq(4)").children(".num-text").val());
		//小计金额
		var vtotal = vprice * vnum;
		//赋值
		$tr.children(":eq(5)").children("span").html("¥" + vtotal);
		//计算每个商品的价格小计结束

		//检查是否选中
		if ($tr.children(":eq(0)").children(".ckitem").prop("checked")) {
			//计数
			vselectCount++;
			//计总价
			vselectTotal += vtotal;
		}
		//将选中的数量和价格赋值
		$("#selectTotal").html(vselectTotal);
		$("#selectCount").html(vselectCount);
	}

}



var  page=1;
$(document).ready(function() {
	if ($.query.get("page")) {
		page = $.query.get("page");
	}else {
		insertParam("page",1);
	}
	showCartList();
	selectGoods();
});




function showCartList() {
	$.ajax({
		"url":"/carts/",
		"type":"GET",
		"data":"page="+page,
		"dataType":"json",
		"success":function(json) {
			if (json.state == 200) {
				var list = json.data;
				$("#cart-list").empty();
				for (var i = 0; i < list.length; i++) {
					console.log(list[i].title);
					var html = '<tr>'
						+ '<td><input name="cids" value="#{cid}" onclick="selectGoods()" type="checkbox" class="ckitem" /></td>'
						+ '<td><img src="..#{image}collect.png" width="110" /></td>'
						+ '<td>#{title}</td>'
						+ '<td>¥<span id="price-#{cid}">#{price}</span></td>'
						+ '<td>'
						+ '<input type="button" value="-" class="num-btn" onclick="subNum(#{cid})" />'
						+ '<input id="num-#{cid}" type="text" size="2" readonly="readonly" class="num-text" value="#{num}">'
						+ '<input class="num-btn" type="button" value="+" onclick="addNum(#{cid})" />'
						+ '</td>'
						+ '<td>¥<span id="total-price-#{cid}">#{totalPrice}</span></td>'
						+ '<td><input type="button" onclick="delCartItem(this,#{cid})" class="cart-del btn btn-default btn-xs" value="删除"/></td>'
						+ '</tr>';

					html = html.replace(/#{cid}/g, list[i].cid);
					html = html.replace(/#{image}/g, list[i].image);
					html = html.replace(/#{title}/g, list[i].title);
					html = html.replace(/#{price}/g, list[i].price);
					html = html.replace(/#{num}/g, list[i].num);
					html = html.replace(/#{totalPrice}/g, list[i].price * list[i].num);

					$("#cart-list").append(html);
				}
				var  totalPage=Math.ceil(parseFloat(json.count)/4.0);

				console.log("totalPage"+totalPage)
				var options={
					bootstrapMajorVersion:1, //版本
					currentPage:page, //当前页数
					numberOfPages:5, //最多显示Page页
					totalPages:totalPage, //所有数据可以显示的页数
					onPageClicked:function(e,originalEvent,type,page){
						console.log("e");
						console.log(e);
						console.log("originalEvent");
						console.log(originalEvent);
						console.log("type");
						console.log(type);
						console.log("page");
						console.log(page);
						replaceParamVal("page",page);
					},
				}
				$("#pagehtml").bootstrapPaginator(options);
			} else {
				alert(json.message);
			}
		}
	});
}
function addNum(cid) {
	$.ajax({
		"url":"/carts/" + cid + "/add_num",
		"type":"POST",
		"dataType":"json",
		"success":function(json) {
			if (json.state == 200) {
				// showCartList();
				var n = parseInt($("#num-" + cid).val()) + 1;
				$("#num-" + cid).val(n);
				var tp = parseInt($("#price-" + cid).html()) * n;
				$("#total-price-" + cid).html(tp);
			} else {
				alert(json.message);
			}
		},
		"error":function() {
			alert("您的登录信息已经过期，请重新登录！");
			location.href = "login.html";
		}
	});
}

function subNum(cid) {
	$.ajax({
		"url":"/carts/" + cid + "/sub_num",
		"type":"POST",
		"dataType":"json",
		"success":function(json) {
			if (json.state == 200) {
				// showCartList();
				var n = parseInt($("#num-" + cid).val()) - 1;
				$("#num-" + cid).val(n);
				var tp = parseInt($("#price-" + cid).html()) * n;
				$("#total-price-" + cid).html(tp);
			} else {
				alert(json.message);
			}
		},
		"error":function() {
			alert("您的登录信息已经过期，请重新登录！");
			location.href = "login.html";
		}
	});
}


