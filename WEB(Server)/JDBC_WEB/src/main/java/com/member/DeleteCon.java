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


@WebServlet("/DeleteCon") //URL Mapping
//�����ּ� : JEBC_WEB.commember.DeleteCon
//����ȭ
public class DeleteCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr"); //���ڵ�
		String id = request.getParameter("id");

		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
			if(conn!=null) {
				System.out.println("���Ἲ��");
			}
			else {
				System.out.println("�������");
			}
	
		String sql = "delete from web_member where id=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		
		int cnt = psmt.executeUpdate();

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
