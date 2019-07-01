$(function() {

	/*商品列表，鼠标移入时加阴影、移出移除阴影*/
	$(".goods-panel").hover(function() {
		$(this).css("box-shadow", "0px 0px 8px #888888");

	}, function() {
		$(this).css("box-shadow", "");
	})
	//加入收藏时，♥的实心空心切换
	$(".add-fav").toggle(function() {
		$(this).html("<span class='fa fa-heart-o'></span>加入收藏");
	}, function() {
		$(this).html("<span class='fa fa-heart'></span>取消收藏");
	})
})


var page=1;
$(document).ready(function() {
	if ($.query.get("page")) {
		page = $.query.get("page");
	}else {
		insertParam("page",1);
	}
	$('#pagenum').val(page);
	showList();
});
function showList() {
	var search=$('#search').val();
	var greatprice=$('#greatprice').val();
	var lessprice=$('#lessprice').val();

	$.ajax({
		"url":"/collection/"+page,
		"type":"GET",
		'data':"search="+search+"&greatprice="+greatprice+"&lessprice="+lessprice,
		"dataType":"json",
		"success":function(json) {
			if (json.state == 200) {
				var list = json.data;
				$("#div01").empty();
				for (var i = 0; i < list.length; i++) {
					console.log(list[i].title);
					var html = '\t<div class="col-md-3">\n' +
						'\t\t\t\t<div class="goods-panel">\n' +
						'\t\t\t\t\t<div class="move-img img-search" />\n' +
						'\t\t\t\t\t\n' +
						'\t\t\t\t\t<img src="..#{image}/collect.png" width="100%" />\n' +
						'\t\t\t\t\t</div>\n' +
						'\t\t\t\t\t<h4>¥#{price}</h4>\n' +
						'\t\t\t\t\t<h5  class="text-row-3"><a href="product.html"><small>#{title}</small></a></h5>\n' +
						'\t\t\t\t\t\n' +
						'\t\t\t\t\t<span>\n' +
						'\t\t\t\t\t\t<a href="javascript:void(0)" onclick="deleteCollection(#{cid}) " class="btn btn-default btn-xs add-fav"><span class="fa fa-heart"></span>取消收藏</a>\n' +
						'\t\t\t\t\t\t<a  href="javascript:void(0)" onclick="addCart(#{cid}) " class="btn btn-default btn-xs add-cart"><span class="fa fa-cart-arrow-down"></span>加入购物车</a>\n' +
						'\t\t\t\t\t</span>\n' +
						'\n' +
						'\t\t\t\t</div>\n' +
						'\t\t\t</div> ';
					html = html.replace(/#{cid}/g, list[i].cid);
					html = html.replace(/#{image}/g, list[i].image);
					html = html.replace(/#{title}/g, list[i].title);
					html = html.replace(/#{price}/g, list[i].price);

					$('#div01').append(html)
				}
				var  totalPage=Math.ceil(parseFloat(json.count)/16.0);

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


function addCart(id) {
		$.ajax({
			"url":"/carts/add",
			"data":"gid=" + id + "&num= 1" ,
			"type":"POST",
			"dataType":"json",
			"success":function(json) {
				if (json.state == 200) {
					alert("添加成功！");
				} else {
					alert(json.message);
				}
			},
			"error":function() {
				alert("您还没有登录，或登录信息已经过期，请重新登录！");
				location.href = "login.html";
			}
		});
}

function deleteCollection(id) {
	$.ajax({
		"url":"/collection/del",
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
}