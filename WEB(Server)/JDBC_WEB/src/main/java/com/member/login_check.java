package com.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_check")
public class login_check extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResultSet rs = null;
		response.setContentType("text/html");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out =response.getWriter();
		
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		
		//JDBC
		//1. �����ε� (Servlet������ �츮�� � DBMS�� ����ϴ��� �𸣱� ������)
		//DB->DBMS(oracle, mysql, mssql ...)
		
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

		String sql = "select * from web_member where id=? and pw=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		
		rs = psmt.executeQuery();
		
		//����ڰ� �Է��� pw�� DB ������ pw�� ��ġ�ϸ� 'LoginS.jsp' �̵��ϰ�
		//��ġ���� ������ 'LoginF.jsp' �̵��Ͻÿ�
		if(rs.next()){
			
			//Cookie cook = new Cookie("loginid", id);
			//response.addCookie(cook); 
			//��Ű�� Ȱ���� ���̵� ����
			
			
			//Servlet�� ���尴ü�� ���� ������ session��ü ����
			HttpSession session = request.getSession();
			
			//session������ ������ ����
			session.setAttribute("loginid", id);
			
			response.sendRedirect("LoginS.jsp?id="+id); //������Ʈ������ ���̵� ����
			
			//URL�� ���ؼ� �����͸� �����ϴ� ���
			//QueryString
			// ex04 ?
			//�������ϴ� �����̸� QueryString����
			//	name = value
			//�������� �����Ϳ� �̸�ǥ
		
		}
		
		else {
			response.sendRedirect("LoginF.jsp");
			
		}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			try {
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		//out.print("<br><a href='Main.html'>������������ ���ư���</a>");
	}
}