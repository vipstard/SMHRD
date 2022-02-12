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
		//1. �����ε� (Servlet������ �츮�� � DBMS�� ����ϴ��� �𸣱� ������)
		//DB->DBMS(oracle, mysql, mssql ...)
		
		//�ڹٿ����� ũ�� 2��������
		//1. �����Ͽ��� : �������� ����
		//2. ��Ÿ�ӿ��� : ������ �ؾ������� �� �� �ִ� ����(ä��, ����...)
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. oracle�� ���� id/pw�� �����޾ƾ���
			
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
			
		//3. SQL�غ�
		String sql = "insert into web_member values(?, ?, ?)";
		
		 psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		psmt.setString(3, nick);
		
		//4. SQL����
		int cnt = psmt.executeUpdate();
		
		//5. ���� �� ó��
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
