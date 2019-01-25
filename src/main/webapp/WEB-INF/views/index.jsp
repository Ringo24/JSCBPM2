<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>카페</title>
<link rel="stylesheet" href="resources/css/dataroom.css">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/search.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="resources/js/summon.js"></script>
<script type="text/javascript">
	$(function(){
		connectSummonEvent();
		connectSummonAddrInputEvent();
		connectIdCheck();
	});
</script>
</head>
<body>
<table id="siteTitleArea">
	<tr>
		<td>
			<table id="loginArea">
				<tr>
					<td align="right">
						<jsp:include page="${loginPage }"></jsp:include>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table id="titleArea">
				<tr>
					<td align="center">자 바보안코 딩빅데 이터개 발자양 성과정카페<br>ver.Spring</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table id="menuArea">
				<tr>
					<td align="center">
						<a href="index.do" class="menu">홈</a> 
						<a href="data.do" class="menu">자료실</a> 
						<a href="search.go" class="menu">검색</a>
						<a href="map.go" class="menu">지도</a>
						<a href="calendar.go" class="menu">일정</a> ${r }
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table id="siteContentArea">
	<tr>
		<td>
			<jsp:include page="${contentPage }"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>