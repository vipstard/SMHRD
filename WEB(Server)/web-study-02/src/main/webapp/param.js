function check() {
	if(document.frm.id.value == "" ) {
		alert("아이디를 입력해주세요.");
		return false;
	}else if (document.frm.age.value==""){
		alert("나이를 입력해주세요.");
		document.frm.age.focus();
		return false;
	}else if (isNaN(document.frm.age.value)) {
		alert("숫ㅈ로 입력해주세요.");
		document.frm.age.focus();
		return false;
	}else{
		return true;
	}
}