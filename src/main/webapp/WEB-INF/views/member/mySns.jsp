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
<table class="mySnsTable">
	<tr>
		<th class="msTh">
			내가 작성한 글
		</th>
	</tr>
	<c:forEach var="s" items="${snsAl }">
		<tr>
			<td class="msTd">
				<form action="search.sns" method="post">
					<input type="hidden" name="search" value="js_txt">
					<input type="hidden" name="query" value="${s.js_txt }">
					<button class="msBtn">${s.js_txt }</button>
				</form>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>
			<div class="page pad">
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
		</td>
	</tr>
</table>
<%-- <table class="mySnsTable">
	<tr>
		<th class="msTh">
			내가 작성한 댓글
		</th>
	</tr>
	<c:forEach var="r" items="${searchReplyAl }">
		<tr>
			<td class="msTd">
				${r.jr_txt }
			</td>
		</tr>
	</c:forEach>
</table> --%>
</body>
</html>