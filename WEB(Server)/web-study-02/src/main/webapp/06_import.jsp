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
	SimpleDateFormat today=new SimpleDateFormat("yyyy�� MM�� dd��");
	SimpleDateFormat now=new SimpleDateFormat("hh�� MM�� dd��");
%>

������ <b><%= today.format(date.getTime()) %> </b>�Դϴ�. <br>
���ݽð��� <b> <%= now.format(date.getTime()) %></b> �Դϴ�.
</body>
</html>