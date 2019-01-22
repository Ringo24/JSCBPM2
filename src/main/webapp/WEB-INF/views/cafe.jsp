<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페</title>
</head>
<body>
<div class="search" id="search">
	<form action="search.sns" name="SnsSearchForm" onsubmit="return snsSearchCheck();" method="post">
		<select name="search" class="sInput sSelect">
			<option value="js_id">아이디</option>
			<option value="jm_name">이름</option>
			<option value="js_txt">내용</option>
		</select>
		<input name="query" class="sInput sQuery" placeholder="검색">
	</form>
</div>

<div class="container" id="container">
<c:if test="${sessionScope.loginMember != null }">
	<div class="write" id="write">
	<div class="hideBtn" id="hideBtn"></div>
	<!-- <img src="resources/img/arrow-down-01_186411.png" class="openBtn"/> -->
	<form action="write.sns" method="post" name="writeForm" onsubmit="return writeCheck();">
		<table id="wTable" class="pad">
			<tr>
				<td align="center">
					<textarea name="js_txt" class="wInput" rows="3" maxlength="700"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="wBtn">글쓰기</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</c:if>

<div class="page pad" id="page">
	<c:forEach var="p" begin="1" end="${pageCount }">
		<c:choose>
			<c:when test="${p == curPage }">
				${p }
			</c:when>
			<c:otherwise>
				<a href="page.sns?p=${p }">${p }</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
	


<div class="snsList" id="snsList">
<c:forEach var="s" items="${snsAl }">
	<input type="hidden" name="js_no" value="${s.js_no }">
	<table class="snsListTable pad">
		<tr>
			<td width="40px">
				<img src="resources/file/${s.jm_photo }" class="jm_photo">
			</td>
			<td class="nameTd">
				<b>${s.jm_name }</b> @${s.js_id }
			</td>
			<td align="right" style="font-size: 8pt">
				<fmt:formatDate value="${s.js_date }" pattern="YYYY년 MM월 dd일(E) HH시 mm분 ss초"/> 
			</td>
		</tr>
		<tr>
			<td colspan="3" style="padding-bottom: 10px;">
				${s.js_txt }
			</td>
		</tr>
		<c:if test="${s.js_id == sessionScope.loginMember.jm_id }">
			<tr>
				<td colspan="3" align="right">
					<button class="logintBtn" onclick="snsUpdate(${s.js_no })">수정</button>
					<button class="logintBtn" onclick="snsDelete(${s.js_no })">삭제</button>
				</td>
			</tr>
		</c:if>
		<tr>
		<td colspan="3">
		
 			<table class="replyTable">
				<c:forEach var="re" items="${s.js_repls }">
					<tr>
						<td class="replyId">
							${re.jm_name }
						</td>
						<td class="replyTxt">
							${re.jr_txt } 
							<c:if test="${re.jr_id == sessionScope.loginMember.jm_id }">
								<button class="logintBtn" onclick="replyUpdate(${re.jr_no })">수정</button>
								<button class="logintBtn" onclick="replyDelete(${re.jr_no })">삭제</button>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${sessionScope.loginMember != null }">
					<tr>
						<td class="replyId">
							<span class="">
							${sessionScope.loginMember.jm_name }
							</span>
						</td>
						<td class="replyTxt">
							<form action="write.reply" onsubmit="return replWriteCheck(this);">
								<input name="jr_jsno" value="${s.js_no }" type="hidden">
								<input name="jr_txt" class="cInput" maxlength="300" autocomplete="off">
								<button class="logintBtn">작성</button>
							</form>
						</td>
					</tr>
				</c:if>
			</table>
			
		</td>
		</tr>
	</table>
</c:forEach>
</div>

<div class="controller" id="controller">
	<a href="#"><img src="resources/img/arrow-up-01_186407.png" class="cntImg"></a><br>
	<a href="#bottom"><img src="resources/img/arrow-down-01_186411.png" class="cntImg"></a>
</div>

<div class="bottom" id="bottom"></div>

<div class="ad">
	<iframe width="314" height="559" src="https://www.youtube.com/embed/atU7oGQORH4?vq=hd1080&autoplay=0&loop=1&rel=0&playlist=atU7oGQORH4" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope"></iframe>
</div>
</div>
</body>
</html>