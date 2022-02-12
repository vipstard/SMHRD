<%@page import="com.model.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style>
	body{
		background-image : url('asset/img/bg.jpg');
		font-family: 'Do Hyeon', sans-serif;
		font-size : 30px;
	}
	.container{
		background-color : whitesmoke;
		margin-top : 100px;
		padding-top : 20px;
	}
	th,td{
		text-align:center;
	}

</style>
</head>
<body>
	<%
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> al = dao.getList();
		System.out.print(al.size());
	%>
	<div class="container">
	<table class="table">
		<tr>
		    <th>글 제목</th>
		    <th>작성자</th>
		    <th>조회수</th>
		</tr>
	<%-- 
		<%
			for(int i = 0;i < al.size();i++){
				out.print("<tr><td>"+al.get(i).getName()+"</td>");
				out.print("<td>"+al.get(i).getWriter()+"</td>");
				out.print("<td>"+al.get(i).getViews()+"</td></tr>");
		%>
		
		<%} %>
	--%>
	<%
		for(int i = al.size()-1;i >= 0;i--){
	%>
	<tr>
		<td><a href="board_main.jsp?num=<%=al.get(i).getNum()%>"><%=al.get(i).getName() %></a></td>
		<td><%=al.get(i).getWriter() %></td>
		<td><%=al.get(i).getViews() %></td>
	</tr>
	
	<%
		}
	%>
	
	</table>
	</div>

</body>
</html>