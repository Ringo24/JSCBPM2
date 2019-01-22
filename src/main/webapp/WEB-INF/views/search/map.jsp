<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7d59a19ccee2485f7bedede2b51ec6f9"></script>
<script type="text/javascript" src="resources/js/daumMap.js"></script>
<link rel="stylesheet" href="resources/css/map.css">
</head>
<body>
<div class="search">

</div>

<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
	
    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="솔데스크" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
    <div id="roadview"></div>
</div>
	<table id="siteSM">
		<tr>
			<td align="center" id="searchArea">
			<input id="loc" placeholder="어디">&nbsp;&nbsp;<input id="what" placeholder="뭐"></td>
		</tr>
		<tr>
			<td align="center">
				<img src="search.png" id="summonSearchArea">
			</td>
		</tr>
	</table>
	<table id="resultArea">
		<tr>
			<td align="center" id="resultArea2">
				
			</td>
		</tr>
	</table>
</body>
</html>