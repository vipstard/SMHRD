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
<h3> ����ڷ� �α��� ����</h3>
<%=URLDecoder.decode(request.getParameter("userName"), "UTF-8") %>
(<%=request.getParameter("userID") %>) �� ȯ���մϴ�.



</body>
</html>