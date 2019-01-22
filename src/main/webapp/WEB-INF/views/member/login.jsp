<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<table id="loginForm">
		<tr>
			<form action="login.member" method="post" name="loginForm" onsubmit="return loginCheck();">
				<td>
					<input name="jm_id" placeholder="ID" maxlength="16" class="id"> 
				</td>
				<td>
					<input name="jm_pw" placeholder="PW" type="password" maxlength="16" class="id">
				</td>
				<td>
					<input type="checkbox" name="autoLogin" value="on">자동로그인
				</td>
				<td>
					<button class="logintBtn">로그인</button>
				</td>
			</form>
			<td>
				<button class="logintBtn" onclick="goJoin()">회원가입</button>
			</td>
		</tr>
	</table>
</body>
</body>
</html>