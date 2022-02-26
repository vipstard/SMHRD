<%@page import="com.VO.memberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DAO.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		
	</head>
	<style>
	
	</style>
	
	<% 
		memberDAO dao = new memberDAO();
		
		ArrayList<memberVO> al = dao.getList();
		System.out.print(al.size());
		
	%>
	<body style="text-align: center;">
		<!--  1. DAO ���� (memberDAO)
			  2. DAO - �޼��� (selectAll) ����  -> BoardDAO (getList() ����)
			  	(email, tel, address ���� ������ ����)
			  3. jsp ���� -> board_list.jsp ����
		 -->

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>ȸ������������</h2></caption>
							<tr>
								<td>Email</td>
								<td>HP</td>
								<td>Addr</td>						
							</tr>
							
							<%
		for(int i = 0;i <al.size();i++){
	%>
	<tr>
		<td>
			<%=al.get(i).getEmail() %></a></td>
		<td><%=al.get(i).getTel() %></td>
		<td><%=al.get(i).getAddress() %></td>
		<td><a href="DeleteCon.do?email=<%=al.get(i).getEmail() %>">����</a>
	</tr>
	
	<%
		}
	%>
	
						</table>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			
			<a  href="main.jsp">������������ ���ư���</a>
	</body>
</html>

