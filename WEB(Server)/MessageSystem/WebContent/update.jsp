<%@page import="com.VO.memberVO"%>
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
	<body style="text-align: center;">
	
	

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
						<form action="UpdateCon" method="post">
							<li><h5>ȸ����������</h5></li>
							<%
							memberVO vo = (memberVO)session.getAttribute("loginvo");
							%>
								<%--����ִ� li�±׿� �̸������, ��ȭ��ȣ/���ּ� ���� ������ ��� --%>
								<%--1. ���� �α��� �� ����� EMAIL�� �Ʒ���  li�±� �ȿ� ����Ͻÿ�.--%>
								
								<%--2. �Է��� ������ UpdateCon���� �����Ͻÿ�.--%>
								<li><%=vo.getEmail() %></li>
								<li><input  name='pw' type="password" placeholder="PW�� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
								<li><input name='tel' value="<%=vo.getTel()%>"  type="text" placeholder="��ȭ��ȣ�� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
								<li><input name='address' value="<%=vo.getAddress()%>" type="text" placeholder="���ּҸ� �Է��ϼ���" style="width: 500px; margin: 0 auto;"></li>
								<li><input type="submit" value="Update" class="button fit" style="width: 500px; margin: 0 auto;"></li>
						</form>
						
						
						
						</ul>
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
	</body>
</html>

