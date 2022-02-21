<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3> 클라이언트로부터 얻어온 Cookie</h3>

<% Cookie[] cookies = request.getCookies();
	for (Cookie c : cookies){
		out.println(c.getName()+" : " + c.getValue() + " <br> " );
		}
		
		%>

</body>
</html>