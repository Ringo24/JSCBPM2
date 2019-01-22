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
	<div class="write">
	<form action="DataUpdateController" method="post" enctype="multipart/form-data" name="dataWriteForm" onsubmit="return dataUpdateCheck();">
		<input type="hidden" name="jd_no" value="${d.jd_no }">
		<table id="wTable" class="pad">
			<tr>
				<td class="nameTd">
					<b>${d.jm_name }</b> @${d.jd_id }
				</td>
			</tr>
			<tr>
				<td>
					<input name="jd_title" value="${d.jd_title }" class="dwInput" maxlength="100" placeholder="제목">
				</td>
			</tr>
			<tr>
				<td>
					<input name="jd_file" type="file" class="dwInput">
				</td>
			</tr>
			<tr>
				<td>
					<button class="wBtn">업로드</button>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>