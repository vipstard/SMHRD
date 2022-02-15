<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h3> 사용자로 로그인 성공</h3>
<%=URLDecoder.decode(request.getParameter("userName"), "UTF-8") %>
(<%=request.getParameter("userID") %>) 님 환영합니다.



</body>
</html>