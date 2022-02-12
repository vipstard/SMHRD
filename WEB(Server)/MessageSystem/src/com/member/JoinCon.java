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
		Connection conn = null;
		PreparedStatement psmt = null;
		
		//1. main.jsp에서 사용자가 보내주는 정보를 받으시오(POST)
		
		request.setCharacterEncoding("euc-kr");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		
		//2. JDBC를 통해 DB와 연결하여 message_member테이블에 사용자의 정보를 저장하시오.
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. oracle에 가서 id/pw를 인증받아야함
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
		
			

		String sql = "insert into message_member values(?, ?, ?, ?, sysdate)";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
		psmt.setString(2, pw);
		psmt.setString(3, phone);
		psmt.setString(4, address);
		
		int cnt = psmt.executeUpdate();
		
		if(cnt>0) {
			//3. 저장 완료 후 main.jsp 이동하시오
			response.sendRedirect("main.jsp");
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
