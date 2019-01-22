function connectSummonEvent(){
	var summon = false;
	$(".hideBtn").click(function(){
		//css로 안보이게
		if (summon) {
			$("#wTable").css("visibility", "visible");
			$(".page").css("margin-top", "120px");
			$(".hideBtn").css("background-image", "url('resources/img/arrow-up-01_186407.png')").css("cursor", "zoom-out");
		} else {
			$("#wTable").css("visibility", "hidden");
			$(".page").css("margin-top", "23px");
			$(".hideBtn").css("background-image", "url('resources/img/arrow-down-01_186411.png')").css("cursor", "zoom-in");
		}
		summon = !summon;
	});
}

function connectSummonAddrInputEvent(){
	$("#joinAddrSearchBtn").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	        	$("#post").val(data.zonecode);
	        	$("#addr").val(data.address);
	        }
	    }).open();
	});
}