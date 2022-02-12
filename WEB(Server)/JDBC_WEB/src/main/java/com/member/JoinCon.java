package com.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		//JDBC
		//1. 동적로딩 (Servlet파일은 우리가 어떤 DBMS를 사용하는지 모르기 때문에)
		//DB->DBMS(oracle, mysql, mssql ...)
		
		//자바에서는 크게 2가지오류
		//1. 컴파일오류 : 문법적인 오류
		//2. 런타임오류 : 실행을 해야하지만 알 수 있는 오류(채팅, 파일...)
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. oracle에 가서 id/pw를 인증받아야함
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("연결성공");
			}
			else {
				System.out.println("연결실패");
			}
			
		//3. SQL준비
		String sql = "insert into web_member values(?, ?, ?)";
		
		 psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		psmt.setString(3, nick);
		
		//4. SQL실행
		int cnt = psmt.executeUpdate();
		
		//5. 실행 후 처리
		if(cnt>0) {
			response.sendRedirect("Main.jsp");
		}
		
	
			
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			
			try {
				psmt.close();
				conn.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
	}

}
