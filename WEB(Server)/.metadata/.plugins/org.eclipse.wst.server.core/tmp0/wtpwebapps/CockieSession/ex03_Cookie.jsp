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
		Cookie cook = new Cookie("NewCookie", "");
	
		cook.setMaxAge(3000); //��Ű�� �����ֱ� ����
		
		response.addCookie(cook);
	%>

</body>
</html>