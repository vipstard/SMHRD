package com.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.VO.memberVO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 사용자가 입력한 email 과 pw를 받아오시오.
	
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		response.setContentType("text/html");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out =response.getWriter();
		
		String id = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
			 
			//2. jdbc를 통해 member_message테이블에 있는 email의 정보를 검색하시오.
			if(conn!=null) {
				System.out.println("연결성공");
			}
			else {
				System.out.println("연결실패");
			}

		String sql = "select * from message_member where email=? and pw=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		
		rs = psmt.executeQuery();
		
		
		

		
		//3. 검색된 정보의 pw와 사용자가 입력한 pw가 일치할 때
		// session에 'loginmail'라는 name값으로 로그인에 성공한 email을 저장하시오.
		
	
		//4. 성공 후에는 'main.jsp로' 이동하시오.
		if(rs.next()){
			
			String getEmail = rs.getString(1);
			String getPw = rs.getString(2);
			String getTel = rs.getString(3);
			String getAdress = rs.getString(4);
			String getDate = rs.getString(5);
			
			System.out.println("이메일: " + getEmail);
			System.out.println("비밀번호: " + getPw);
			System.out.println("전화번호: " + getTel);
			System.out.println("주소: " + getAdress);
			System.out.println("가입날짜: " + getDate);
			
			memberVO vo = new memberVO(getEmail,getTel,getAdress);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginvo", vo);	
			
			response.sendRedirect("main.jsp"); 
			
	
		}
		
		//5. 실패 했을 때 (id가 없을 때/ pw가 틀렸을 때 ) 이동하지마시오.
		else {
			
			
		}

		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				psmt.close();
				conn.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		
		

		
		
	}

}
