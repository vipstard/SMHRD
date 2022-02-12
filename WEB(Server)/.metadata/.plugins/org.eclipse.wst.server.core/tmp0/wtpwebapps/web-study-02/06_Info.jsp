<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> get 방식에서 한글 깨짐 방지</h3>
<form action="InfoServlet" method="get">
	이름 : <input type="text" name="name"><br>
	주소 : <input type="text" name="addr"><br>
	<input type="submit" value="전송">
</form>

</body>
</html>