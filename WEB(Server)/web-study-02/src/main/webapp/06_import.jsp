<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
	 Calendar date = Calendar.getInstance();
	SimpleDateFormat today=new SimpleDateFormat("yyyy년 MM월 dd일");
	SimpleDateFormat now=new SimpleDateFormat("hh시 MM분 dd초");
%>

오늘은 <b><%= today.format(date.getTime()) %> </b>입니다. <br>
지금시각은 <b> <%= now.format(date.getTime()) %></b> 입니다.
</body>
</html>