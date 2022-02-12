<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>회원전체검색 페이지</h1>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NICK</th>
		</tr>
		<%
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			if (conn != null) {
				System.out.println("연결성공");
			} else {
				System.out.println("연결실패");
			}

			String sql = "select * from web_member";

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString(1); //인덱스 1번열 데이터를 가져오겠다.
				String pw = rs.getString(2);
				String nick = rs.getString(3);

				//출력 방법 두가지가 있다. 여기서는 2번 방법이 편함
				//1. Scriptlet

				//2. out내장객체

				out.print("<tr>");
				out.print("<td>" + id + "</td>");
				out.print("<td>" + pw + "</td>");
				out.print("<td>" + nick + "</td>");
				out.print("<td><a href='DeleteCon?id=" + id + "'> 삭제</td>");
				
				//DeleteCon으로 이동하고 QueryString 방식을 통해 
				//name(id) = value(변수id)를 보내시오
				out.print("</tr>");

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				psmt.close();
				conn.close();

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		%>
	</table>
	<br>
	<a href="Main.jsp">메인페이지로 돌아가기</a>

</body>
</html>