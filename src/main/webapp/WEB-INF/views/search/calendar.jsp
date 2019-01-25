<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='resources/css/fullcalendar.min.css'>
<link rel='stylesheet' href='resources/css/fullcalendar.print.min.css' media='print'>
<script type="text/javascript" src='resources/js/moment.min.js'></script>
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src='resources/js/fullcalendar.min.js'></script>
<script type="text/javascript">
$(function(){
	var row = [];
	$.getJSON("http://openapi.seoul.go.kr:8088/4f6a6547456b6368333355736a714f/json/SearchConcertPeriodService/1/15/20190101/20191231/", function(data){
		$.each(data.SearchConcertPeriodService.row, function(i, r){
  		  row[i] = {title: r.TITLE, start: r.STARTDATE, end: r.END_DATE};
  	  });
    });
	$("#calendar").fullCalendar({
		header: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'month,basicWeek,basicDay'
	      },
	      defaultDate: '2019-01-25',
	      navLinks: true, // can click day/week names to navigate views
	      editable: true,
	      eventLimit: true, // allow "more" link when too many events
	      events: row
	});
});
</script>
</head>
<body>
<div class="search">
	<!-- <form action="search.do" method="post" name="snsSearchForm" onsubmit="return snsSearchCheck();"> -->
		<select name="search" class="sInput sSelect">
			<option value=""></option>
		</select>
		<input name="query" class="sInput sQuery" id="query" placeholder="검색">
	<!-- </form> -->
</div>

<div id="calendar" style="margin-top: 50px;max-width: 700px;"></div>
</body>
</html>