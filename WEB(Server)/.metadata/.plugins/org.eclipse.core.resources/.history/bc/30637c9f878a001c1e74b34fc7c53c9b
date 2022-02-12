<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="asset/css/main.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
	rel="stylesheet">
<style>
body {
	background-image: url('asset/img/bg.jpg');
	font-family: 'Do Hyeon', sans-serif;
	font-size: 30px;
}
#check{
	font-size : 20px;
	color : red;
}
</style>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">

			<!-- Login Form -->
			<form action="#">
				<input type="text" id="id" class="fadeIn second" name="id"placeholder="login" style="margin-top: 30px"> 
				<input type="password" id="password" class="fadeIn third" name="pw" placeholder="password"> 
				<p id="check"></p>
				<input type="button" id="submit" class="fadeIn fourth" value="Log In">
			</form>

		</div>
	</div>
	
	<script>
		let btn_submit = document.getElementById("submit");
		let check_p = document.getElementById("check");
		
		btn_submit.addEventListener("click", function(){
			//1. id칸이나 pw칸 둘중에 하나라도 비어있으면
			//p(id=check) "아이디/비밀번호를 입력해주세요" 문구 출력
			let id = document.getElementById("id").value;
			let pw = document.getElementById("password").value;
			
			// if(!id||!pw){
			if(id == "" || pw == ""){
				check_p.innerText="아이디/비밀번호를 입력해주세요";
			}else{
				//JSON({키 : 실제값}) 형식 데이터 만들기
				let data = {'id': id, 'pw':pw};
				
				let xhr = new XMLHttpRequest();
				
				//요청방식, 요청경로
				xhr.open("post", "loginService");
				//전송데이터의 형식
				xhr.setRequestHeader("Content-Type","application/json;charset=UTF-8");
				//요청 & 전송할 데이터
				xhr.send(JSON.stringify(data));
				
				xhr.onreadystatechange = function() {
					if(xhr.readyState === XMLHttpRequest.DONE){ //요청성공
						if(xhr.status===200){
							console.log("응답성공");
							console.log(xhr.responseText); //응답데이터 확인 //xml로 보내는경우=>(responseXML)
							
							if(xhr.responseText === "success"){
								location.href = "board_list.jsp";
							}else{
								check_p.innerText="아이디/비밀번호를 확인해주세요";
							}
							
						}else{
							console.log("응답실패");
						}
					}else{ // 요청실패
						console.log("요청실패");
					}
				}// end of function
			} // end of else
		});
		
	</script>
</body>
</html>