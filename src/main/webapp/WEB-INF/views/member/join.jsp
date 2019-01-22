<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="join.member" method="post" onsubmit="return joinCheck();" name="joinForm" enctype="multipart/form-data">
	<table id="joinTable">
		<tr>
			<td>
				<h3 class="joinLabel"><label for="id">아이디</label></h3>
				<input name="jm_id" id="id" maxlength="16" class="joinInput" placeholder="영문 4자이상" >
				<span id="joinIdCheckMsg"></span>
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="pw">비밀번호</label></h3>
				<input name="jm_pw" id="pw" type="password" maxlength="16" class="joinInput" placeholder="4자 이상">
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="pw2">비밀번호 재확인</label></h3>
				<input name="jm_pw2" id="pw2" type="password" maxlength="16" class="joinInput">
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="name">이름</label></h3>
				<input name="jm_name" id="name" maxlength="10" class="joinInput">
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="post">우편번호</label></h3>
				<input name="jm_addr1" id="post" class="joinInput" readonly="readonly">
				<span id="joinAddrSearchBtn">주소 검색</span>
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="addr">주소</label></h3>
				<input name="jm_addr2" id="addr" class="joinInput" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="detailAddr">상세주소</label></h3>
				<input name="jm_addr3" id="detailAddr" class="joinInput">
			</td>
		</tr>
		<tr>
			<td>
				<h3 class="joinLabel"><label for="photo">사진</label></h3>
				<input name="jm_photo" id="photo" type="file" class="joinInput">
			</td>
		</tr>
		<tr>
			<td>
				<button class="joinB">회원가입</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>