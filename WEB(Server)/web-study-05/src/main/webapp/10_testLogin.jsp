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
String id = "pinksung";
String pwd = "1234";
String name = "성윤정";

if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))){
	session.setAttribute("loginUser", name);
	response.sendRedirect("10_main.jsp");
}else{
	System.out.println(request.getParameter("id"));
	System.out.println(request.getParameter("pwd"));
	
	response.sendRedirect("10_loginForm.jsp");
}
%>
</body>
</html>