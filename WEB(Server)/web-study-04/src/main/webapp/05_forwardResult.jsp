<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%
	String age = request.getParameter("age");
	String name = (String)request.getAttribute("name");
	%>
	
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor=pink>
forward ������� �̵��� ������ <br>
 ���� : <%=age %>
 �̸� : <%=name %>


</body>
</html>