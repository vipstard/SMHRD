<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% 
		Cookie[] cookies = request.getCookies();
		//사용자의 PC에 있는 쿠키값을 가져옴
		
		for(int i=0; i<cookies.length; i++){
			out.print(cookies[i].getName() + "<br>");
			out.print(cookies[i].getValue() + "<br>");
		}
		
		//사용자의 PC에 있는 쿠키값을 출력
		
	%>

</body>
</html>