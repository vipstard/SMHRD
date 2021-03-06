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
		//1. 동적로딩 (Servlet파일은 우리가 어떤 DBMS를 사용하는지 모르기 때문에)
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
				System.out.println("연결성공");
			}
			else {
				System.out.println("연결실패");
			}

		String sql = "select * from web_member where id=? and pw=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		
		rs = psmt.executeQuery();
		
		//사용자가 입력한 pw와 DB 가져온 pw가 일치하면 'LoginS.jsp' 이동하고
		//일치하지 않으면 'LoginF.jsp' 이동하시오
		if(rs.next()){
			
			//Cookie cook = new Cookie("loginid", id);
			//response.addCookie(cook); 
			//쿠키를 활용한 아이디값 저장
			
			
			//Servlet은 내장객체가 없기 때문에 session객체 생성
			HttpSession session = request.getSession();
			
			//session영역에 데이터 생성
			session.setAttribute("loginid", id);
			
			response.sendRedirect("LoginS.jsp?id="+id); //쿼리스트링으로 아이디 전송
			
			//URL을 통해서 데이터를 전송하는 방식
			//QueryString
			// ex04 ?
			//보내려하는 파일이름 QueryString시작
			//	name = value
			//보내려는 데이터에 이름표
		
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
		
		//out.print("<br><a href='Main.html'>메인페이지로 돌아가기</a>");
	}
}
