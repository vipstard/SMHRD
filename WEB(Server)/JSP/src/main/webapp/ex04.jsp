<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
		<!--  1~20���� ���ڸ� �Ʒ��� td�±׿� ����Ͻÿ� -->
		<%-- ex04.html ������ ���� �Է� ���� �� ��ŭ �Ʒ��� �ݺ��� �ݺ��Ͻÿ� --%>
		
		
		
		<%
		
		int name = Integer.parseInt(request.getParameter("num"));
		
		for(int i=1;i<=name;i++) {
	
			out.print("<td>" + i + "</td>");
			
		}
		
		%>
		
		
		</tr>
		
		
	</table>

</body>
</html>