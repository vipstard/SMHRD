<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
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
		//내장객체 : JSP에서는 Servlet에서 자주 사용되는 객체를 미리 선언

		out.print("Hello~");

	%>
	
	<table border="1">
		<tr>
			<%--아래에 있는 td 태그를 10번 반복하시오. --%>
	 <% //1~100까지의 합을 출력하시오.
		for(int i=1;i<=10;i++) {
	
			out.print("<td>"+i+"</td>");	
		
		}%>
		</tr>
	</table>
	
	<%
		GregorianCalendar gre = new GregorianCalendar(Locale.KOREA);
		//현재 날짜와 시간을 가져오는 객체
		
		int year = gre.get(gre.YEAR);
		int month = gre.get(gre.MONTH)+1;
		int date = gre.get(gre.DATE);
		int hour = gre.get(gre.HOUR);
		int min = gre.get(gre.MINUTE);
		int sec = gre.get(gre.SECOND);	
	%>
	
	<%=year %>년 <%=month %>월 <%=date %><br>
	<%=hour %>시 <%=min %>분 <%=sec %>초

</body>
</html>