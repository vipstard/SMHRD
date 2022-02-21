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
	session.invalidate();
%>

<script>
	alert("로그 아웃 되었습니다.");
	location.href="10_loginForm.jsp"
</script>

</body>
</html>