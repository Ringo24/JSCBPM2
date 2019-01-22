<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="search">
	<form action="search.do" method="post" name="snsSearchForm" onsubmit="return snsSearchCheck();">
		<select name="search" class="sInput sSelect">
			<option value="shop">쇼핑</option>
			<option value="movie">영화</option>
			<option value="book">책</option>
		</select>
		<input name="query" class="sInput sQuery" placeholder="검색">
	</form>
</div>

<div class="scList">
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
</div>

</body>
</html>