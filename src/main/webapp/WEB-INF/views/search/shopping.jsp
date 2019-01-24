<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#query").keyup(function(e){
		if(e.keyCode == 13){
			var qq = $("#query").val();
			$.getJSON("search.shop?query="+qq, function(data){
				$("#s").css("opacity", "1");
				$(".slider").empty();
				var ar = data.items;
				$.each(ar, function(i, shop){
					var img = $("<img>").attr("src", shop.image).attr("width", "400px").css("max-height", "400px").css("margin-left", "auto").css("margin-right", "auto");
					var t = $("<a></a>").attr("href", shop.link).html(shop.title);
					var br = $("<br>")
					var p = $("<span></span").html(shop.lprice + "원");
					var d = $("<div></div>").append(img, t, br, p).css("text-align", "center");
					$(".slider").append(d);
				});
				sl.reloadSlider();
			});
		}
	});
	
	var sl = $('.slider').bxSlider({
		auto: true
	});
});
</script>
</head>
<body>
<div class="search">
	<!-- <form action="search.do" method="post" name="snsSearchForm" onsubmit="return snsSearchCheck();"> -->
		<select name="search" class="sInput sSelect">
			<option value="shop">쇼핑</option>
			<option value="movie">영화</option>
			<option value="book">책</option>
		</select>
		<input name="query" class="sInput sQuery" id="query" placeholder="검색">
	<!-- </form> -->
</div>

<%-- <div class="scList">
<c:forEach var="s" items="${searches }">
	<table class="scListTable pad">
		<tr>
			<td class="scImgTd" rowspan="2">
				<img class="scImg" width="140px" height="140px" src="${s.image }">
			</td>
			<td class="infoTd">
				<a class="infoA" href="${s.link }">${s.title }</a>
			</td>
		</tr>
		<tr>
			<td class="priceTd" style="padding-bottom: 10px;">
				${s.price } 
			</td>
		</tr>
	</table>
</c:forEach>
</div> --%>

<div id="s" style="width: 600px; margin-top: 55px; opacity: 0;">
	<div class="slider">
	</div>
</div>

</body>
</html>