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
	<form action="search.data" name="SnsSearchForm" onsubmit="return snsSearchCheck();" method="post">
		<select name="search" class="sInput sSelect">
			<option value="jd_id">아이디</option>
			<option value="jm_name">이름</option>
			<option value="jd_title">제목</option>
			<option value="jd_file">파일명</option>
		</select>
		<input name="query" class="sInput sQuery" placeholder="검색">
	</form>
</div>

<div class="container">
<c:if test="${sessionScope.loginMember != null }">
	<div class="write">
		<div class="hideBtn" id="hideBtn"></div>
		<!-- <img src="resources/img/arrow-down-01_186411.png" class="openBtn"/> -->
	<form action="write.data" method="post" enctype="multipart/form-data" name="dataWriteForm" onsubmit="return dataWriteCheck();">
		<table id="wTable" class="pad">
			<tr>
				<td>
					<input name="jd_title" class="dwInput" maxlength="100" placeholder="제목">
				</td>
			</tr>
			<tr>
				<td>
					<input name="jd_file" type="file" class="dwInput">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="wBtn">업로드</button>
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

<div class="snsList">
<c:forEach var="f" items="${files }">
	<c:if test="${modify == f.jd_no }">
		<form action="update.data" method="post" name="dataWriteForm" onsubmit="return dataUpdateCheck();" enctype="multipart/form-data">
	</c:if>
	<input type="hidden" name="jd_no" value="${modify }">
	<table class="snsListTable pad">
		<tr>
			<td width="40px">
				<img src="resources/file/${f.jm_photo }" class="jm_photo">
			</td>
			<td class="nameTd">
				<b>${f.jm_name }</b> @${f.jd_id }
			</td>
			<td align="right" style="font-size: 8pt">
				<fmt:formatDate value="${f.jd_date }" pattern="YYYY년 MM월 dd일(E) HH시 mm분 ss초"/> 
			</td>
		</tr>
		<tr>
			<td colspan="3" style="padding-bottom: 10px;">
				<c:choose>
					<c:when test="${modify == f.jd_no }">
						<input name="jd_title" class="wInput" value="${f.jd_title }"></input>
					</c:when>
					<c:otherwise>
						${f.jd_title } <br>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="3" class="downTd" style="padding-bottom: 10px;">
				<c:choose>
					<c:when test="${modify == f.jd_no }">
						<input name="jd_file" class="wInput" type="file"></input>
					</c:when>
					<c:otherwise>
						<a href="resources/file/${f.jd_file }">${f.jd_file }</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<c:if test="${f.jd_id == sessionScope.loginMember.jm_id }">
			<tr>
				<td colspan="3" align="right">
					<c:choose>
						<c:when test="${modify == f.jd_no }">
							<button class="logintBtn">수정완료</button>
							</form>
						</c:when>
						<c:otherwise>
							<button class="logintBtn" onclick="dataUpdate(${f.jd_no })">수정</button>
						</c:otherwise>
					</c:choose>
					<button class="logintBtn" onclick="dataDelete(${f.jd_no })">삭제</button>
				</td>
			</tr>
		</c:if>
	</table>
</c:forEach>
</div>

<div class="controller" id="controller">
	<a href="#"><img src="resources/img/arrow-up-01_186407.png" class="cntImg"></a><br>
	<a href="#bottom"><img src="resources/img/arrow-down-01_186411.png" class="cntImg"></a>
</div>

<div class="bottom" id="bottom"></div>

</div>
</body>
</html>