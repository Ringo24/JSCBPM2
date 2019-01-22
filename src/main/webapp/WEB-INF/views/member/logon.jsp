<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginForm">
		<tr>
			<td>
				${sessionScope.loginMember.jm_name }(${sessionScope.loginMember.jm_id })님 안녕하세요~
			</td>
			<td>
				<button class="logintBtn" onclick="memberUpdate()">회원정보</button>
			</td>
			<td>
				<form action="mySns.go">
					<input name="search" type="hidden" value="js_id">
					<input name="searchRep" type="hidden" value="jr_id">
					<input name="query" type="hidden" value="${sessionScope.loginMember.jm_id }">
					<button class="logintBtn">작성글</button>
				</form>
			</td>
			<td>
				<button class="logintBtn" onclick="logout()">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>