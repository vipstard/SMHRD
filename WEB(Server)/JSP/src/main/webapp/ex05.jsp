<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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

	//response.setContentType("text/html; charset=euc-kr");
	//PrintWriter out = response.getWriter(); JSP������ �̹� ������־ ������. 
	// �������� ���
	
	//response.sendRedirect("https://alphasquare.co.kr/");
	//�ܺ� /������������ �̵��ϴ� ���
		
	response.sendRedirect(request.getParameter("choice"));
	
	
	
	/*
	if(choice.equals("first")){
		response.sendRedirect("https://www.naver.com");
	}
	
	else if(choice.equals("second")){
		response.sendRedirect("https://www.daum.net");
	}
	
	else if (choice.equals("third")){
		response.sendRedirect("https://www.google.com");
	}
	*/
	
	
	

	%>

</body>
</html>