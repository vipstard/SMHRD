<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
<form action="ParamServlet" method="get" name="frm">
	아이디:<input type="text" name="id"><br>
	나 &nbsp; 이:<input type="text" name="age"><br>
	<input type="submit" value="전송" onclick="return check()">
	
</form>
</body>
</html>