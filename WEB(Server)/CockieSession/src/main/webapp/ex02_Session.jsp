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
		String str = (String)session.getAttribute("NewSession");
	%>
	
	NewSession에 있는 데이터 : <%=str %>
	
	<a href="ex03_Session.jsp">세션삭제하기</a>

</body>
</html>