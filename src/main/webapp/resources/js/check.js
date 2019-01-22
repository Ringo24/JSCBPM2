function joinCheck(){
	var id = document.joinForm.jm_id;
	var pw = document.joinForm.jm_pw;
	var pw2 = document.joinForm.jm_pw2;
	var name = document.joinForm.jm_name;
	var addr = document.joinForm.jm_addr;
	var photo = document.joinForm.jm_photo;
	
	if (isEmpty(id) || containsHS(id) || lessThan(id, 4) || $("#joinIdCheckMsg").text()=="중복된 ID") {
		alert("아이디");
		id.value = "";
		id.focus();
		return false;
	} else if (isEmpty(pw) || containsHS(pw) || lessThan(pw, 4)) {
		alert("비번");
		pw.value = "";
		pw.focus();
		return false;
	} else if (notEquals(pw2, pw)) {
		alert("비번확인");
		pw2.value = "";
		pw2.focus();
		return false;
	} else if (isEmpty(name)) {
		alert("이름");
		name.value = "";
		name.focus();
		return false;
	} else if (isEmpty(addr)) {
		alert("주소");
		addr.value = "";
		addr.focus();
		return false;
	} else if (isEmpty(photo) || (isNotType(photo, "png") && isNotType(photo, "jpg") && isNotType(photo, "gif") && isNotType(photo, "jpeg"))) {
		alert("사진");
		photo.value = "";
		photo.focus();
		return false;
	}
}

function connectIdCheck(){
	$("#id").keyup(function(){
		var id = $(this).val();
		$.ajax({
			url : "member.id.check",
			data : {jm_id:id},	// {파라메터명:값, 파라메터명:값, ..}
			success : function(data){
				if (id.length == 0) {
					$("#joinIdCheckMsg").text("ID 입력").css("color", "");
				} else if (id.length < 4) {
					$("#joinIdCheckMsg").text("4자 이상").css("color", "");
				} else if ($(data).find("member").length == 1) {
					$("#joinIdCheckMsg").text("중복된 ID").css("color", "red");
				} else {
					$("#joinIdCheckMsg").text("OK").css("color", "green");
				}
			}
		});
	});
}

function loginCheck(){
	var id = document.loginForm.jm_id;
	var pw = document.loginForm.jm_pw;
	
	if (isEmpty(id) || containsHS(id) || lessThan(id, 4)) {
		alert("아이디");
		id.value = "";
		id.focus();
		return false;
	} else if (isEmpty(pw) || containsHS(pw) || lessThan(pw, 4)) {
		alert("비번");
		pw.value = "";
		pw.focus();
		return false;
	}
}

function writeCheck(){
	var txt = document.writeForm.jm_txt;
	
	if (isEmpty(txt)) {
		alert("글");
		txt.value = "";
		txt.focus();
		return false;
	}
}
function snsSearchCheck(){
	var query = document.writeForm.query;
	
	if (isEmpty(query)) {
		alert("검색어");
		query.value = "";
		query.focus();
		return false;
	}
}
function updateCheck(){
	var txt = document.updateForm.jm_txt;
	
	if (isEmpty(txt)) {
		alert("글");
		txt.value = "";
		txt.focus();
		return false;
	}
}

function replWriteCheck(replyForm){
	var txt = replyForm.jr_txt;
	
	if (isEmpty(txt)) {
		alert("내용");
		txt.value = "";
		txt.focus();
		return false;
	}
}

function dataWriteCheck(){
	var title = document.dataWriteForm.jd_title;
	var file = document.dataWriteForm.jd_file;
	
	if (isEmpty(title)) {
		alert("제목");
		title.value = "";
		title.focus();
		return false;
	} else if (isEmpty(file)) {
		alert("파일");
		file.value = "";
		file.focus();
		return false;
	}
}
function dataUpdateCheck(){
	var title = document.dataWriteForm.jd_title;
	
	if (isEmpty(title)) {
		alert("제목");
		title.value = "";
		title.focus();
		return false;
	}
}