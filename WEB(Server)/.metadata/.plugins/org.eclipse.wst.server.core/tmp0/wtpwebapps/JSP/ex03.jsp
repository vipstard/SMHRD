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
	<% //��ũ��Ʋ��(Scriptlet)
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
			<legend>����Ȯ�����α׷�</legend>
			<table width="500">	
				<tr>
					<td>�̸�</td>
					<td><%=name %></td> <%-- ǥ���� --%>
				</tr>
				<tr>
					<td>JAVA����</td>
					<td><%=java %></td>
				</tr>
				<tr>
					<td>WEB����</td>
					<td><%=web %></td>
				</tr>
					<tr>
					<td>IOT����</td>
					<td><%= iot%></td>
				</tr>		
				<tr>
					<td>ANDROID����</td>
					<td><%=android %></td>
				</tr>	
				<tr>
					<td>����</td>
					<td><%=sum %></td>
				</tr>	
				<tr>
					<td>�������</td>
					<td><%=avg %></td>
				</tr>	
				<%--��� : 100~95 A+/ 94~85 A / 84~75 B/ 74~65 C/ 65~F --%>
				<tr>
					<td>����</td>
					<td><%=grade%></td>
				</tr>	
				
																																						
			</table>
		</fieldset>
</body>
</html>