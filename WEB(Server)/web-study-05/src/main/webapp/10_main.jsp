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
	if(session.getAttribute("loginUser")==null){
		response.sendRedirect("10_loginForm.jsp");
	}else{
		
	
%>
	
	<%= session.getAttribute("loginUser")%>�� �ȳ��ϼ���! <br>
	���� Ȩ�������� �湮�� �ּż� �����մϴ�.<br>
	��ſ� �ð� �Ǽ���...<br>
	
	<form method="post" action="10_logout.jsp">
		<input type="submit" value="�α׾ƿ�">
	</form>
	<% 
	}
	%>

</body>
</html>