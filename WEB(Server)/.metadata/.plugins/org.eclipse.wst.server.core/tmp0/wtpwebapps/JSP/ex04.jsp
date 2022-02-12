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
		<!--  1~20까지 숫자를 아래에 td태그에 출력하시오 -->
		<%-- ex04.html 파일을 만들어서 입력 받은 값 만큼 아래의 반복문 반복하시오 --%>
		
		
		
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