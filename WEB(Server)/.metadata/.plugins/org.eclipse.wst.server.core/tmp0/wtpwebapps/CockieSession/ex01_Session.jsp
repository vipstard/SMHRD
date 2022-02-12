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
		session.setAttribute("NewSession", "DongIlYoon");//세션 데이터 생성 session은 내장 객체
	%>
	<h1>세션생성</h1>

</body>
</html>