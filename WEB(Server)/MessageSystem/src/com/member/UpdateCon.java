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
import javax.servlet.http.HttpSession;

import com.VO.memberVO;


@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 데이터 인코딩
		request.setCharacterEncoding("euc-kr");
		
		
		//pw, tel, address / email -> session 
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginvo");
		
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. oracle에 가서 id/pw를 인증받아야함
			
			String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid="hr";
			String dbpw="hr";
			
			 conn = DriverManager.getConnection(url, dbid, dbpw);
			
		
			

		String sql = "update message_member set pw=?, tel=?, address=? where email=?";
		
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, pw);
		psmt.setString(2, tel);
		psmt.setString(3, address);
		psmt.setString(4, email);
		
		int cnt = psmt.executeUpdate();
		
		if(cnt>0) {
			//3. 저장 완료 후 main.jsp 이동하시오
			System.out.println("수정성공");
			
			//사용자의 수정된 값을 가지고 있는 vo객체
			memberVO vo2 = new memberVO(email, tel, address);
			
			session.setAttribute("loginvo", vo2);
			
			response.sendRedirect("main.jsp");
		}
		
		else {
			System.out.println("수정실패");
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