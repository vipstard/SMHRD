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
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("06_application.jsp");
%>

웹 애플리케이션의 컨텍스트 패스명<br>
<b><%=appPath%></b><hr>
웹 애플리케이션의 파일 경로명<br>
<b><%=filePath %></b><br>
</body>
</html>