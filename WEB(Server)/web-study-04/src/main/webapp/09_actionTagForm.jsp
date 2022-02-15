<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="09_actionTagTest.jsp">
	아이디 : <input type="text" name="userID"><br>
	암호 : <input type="password" name="userPwd"><br>
	<input type="radio" name ="loginCheck" value="user" checked = "checked"> 사용자
	<input type="radio" name="loginCheck" value="manager"> 관리자 <br>
	<input type ="submit" value="로그인">
</form>
	

</body>
</html>