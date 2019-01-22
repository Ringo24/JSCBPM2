function changeMenu(controllerName){
	location.href = controllerName;
}
function showAlert(txt){
	alert(txt);
}


function goJoin(){
	location.href = "join.go";
}
function logout(){
	if (confirm("로그아웃?")) {
		location.href = "logout.member";
	}
}
function memberUpdate(){
	location.href = "update.go";
}
function goMySns(){
	location.href = "mySns.member";
}
function memberDelete(){
	if (confirm("정말탈퇴? 돌이킬 수 없음")) {
		location.href = "delete.member";
	}
}

function snsUpdate(no){
//	var txt = prompt("������ ����");
	location.href = "updateSns.go?js_no=" + no;
}
function snsDelete(no){
	if (confirm("정말 삭제? 돌이킬 수 없음")) {
		location.href = "delete.sns?js_no=" + no;
	}
}

function replyUpdate(no){
	var txt = prompt("수정할 내용?");
	if (txt != null) {
		location.href = "update.reply?jr_no=" + no +"&jr_txt=" + txt;
	}
}
function replyDelete(no){
	if (confirm("정말 삭제? 돌이킬 수 없음")) {
		location.href = "delete.reply?jr_no=" + no;
	}
}

function dataUpdate(no){
	location.href = "updateData.go?jd_no=" + no;
}
function dataDelete(no){
	if (confirm("정말 삭제? 돌이킬 수 없음")) {
		location.href = "delete.data?jd_no=" + no;
	}
}

