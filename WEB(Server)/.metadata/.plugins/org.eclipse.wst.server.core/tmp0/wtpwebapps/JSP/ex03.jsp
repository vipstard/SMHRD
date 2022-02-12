<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style>
	tr{
		height: 40px;
		text-align: center;
	}
	table{
		margin: 0 auto;
		table-layout:fixed;
	}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% //스크립틀릿(Scriptlet)
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		int java = Integer.parseInt(request.getParameter("java"));
		int web = Integer.parseInt(request.getParameter("web"));
		int iot = Integer.parseInt(request.getParameter("iot"));
		int android = Integer.parseInt(request.getParameter("android"));
		int sum = java+web+iot+android;
		int avg = sum/4;
		
		String grade = "";
		
		if(avg>=95) grade ="A+";
		
		else if(avg>=85) grade ="A";	
		
		else if(avg>=75) grade = "B";
		
		else grade = "F";
	%>
	

<fieldset>
			<legend>성적확인프로그램</legend>
			<table width="500">	
				<tr>
					<td>이름</td>
					<td><%=name %></td> <%-- 표현식 --%>
				</tr>
				<tr>
					<td>JAVA점수</td>
					<td><%=java %></td>
				</tr>
				<tr>
					<td>WEB점수</td>
					<td><%=web %></td>
				</tr>
					<tr>
					<td>IOT점수</td>
					<td><%= iot%></td>
				</tr>		
				<tr>
					<td>ANDROID점수</td>
					<td><%=android %></td>
				</tr>	
				<tr>
					<td>총합</td>
					<td><%=sum %></td>
				</tr>	
				<tr>
					<td>점수평균</td>
					<td><%=avg %></td>
				</tr>	
				<%--평균 : 100~95 A+/ 94~85 A / 84~75 B/ 74~65 C/ 65~F --%>
				<tr>
					<td>학점</td>
					<td><%=grade%></td>
				</tr>	
				
																																						
			</table>
		</fieldset>
</body>
</html>