<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1 align='center'>메인화면 입니다.</h1>
<br>

<div align='center'>
<a href="Join.html"><button>회원가입</button></a>
<a href="Delete.html"><button>회원삭제</button></a>
<a href="Update.html"><button>회원수정</button></a>

<a href="Select.jsp"><button>회원전체검색</button></a>
<a href="OneSelect.html"><button>회원검색</button></a>




	<%/* 쿠키를 통한 로그인 처리(로그인/로그아웃버튼생성)
		Cookie[] cookies = request.getCookies();
		
	if(cookies != null){
	for(int i=0; i<cookies.length; i++){
		
		if(cookies[i].getName().equals("loginid")){
			out.print("<a href='#'><button>로그아웃</button></a>");
		}
		
		if(cookies[i].getName()==""){
			out.print("<a href='login.html'><button>로그인</button></a>");
		}
	}
	}else{
		out.print("<a href='login.html'><button>로그인</button></a>");
		
	}
	*/
	
	//jsp에는 내장 session 객체 있음
	String login = (String)session.getAttribute("loginid");
	
	if(login == null){
		out.print("<a href='login.html'><button>로그인</button></a>");
	}
	
	else{
		out.print("<br>"+login + "님 접속을 환영 합니다.");
		out.print("<a href='LogoutCon'><button>로그아웃</button></a>");
		
	}
	
		
	
	
	%>
	</div>

</body>
</html>