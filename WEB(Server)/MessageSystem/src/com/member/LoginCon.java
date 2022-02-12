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
		
		//1. ����ڰ� �Է��� email �� pw�� �޾ƿ��ÿ�.
	
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
			
			 
			//2. jdbc�� ���� member_message���̺��� �ִ� email�� ������ �˻��Ͻÿ�.
			if(conn!=null) {
				System.out.println("���Ἲ��");
			}
			else {
				System.out.println("�������");
			}

		String sql = "select * from message_member where email=? and pw=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pw);
		
		rs = psmt.executeQuery();
		
		
		

		
		//3. �˻��� ������ pw�� ����ڰ� �Է��� pw�� ��ġ�� ��
		// session�� 'loginmail'��� name������ �α��ο� ������ email�� �����Ͻÿ�.
		
	
		//4. ���� �Ŀ��� 'main.jsp��' �̵��Ͻÿ�.
		if(rs.next()){
			
			String getEmail = rs.getString(1);
			String getPw = rs.getString(2);
			String getTel = rs.getString(3);
			String getAdress = rs.getString(4);
			String getDate = rs.getString(5);
			
			System.out.println("�̸���: " + getEmail);
			System.out.println("��й�ȣ: " + getPw);
			System.out.println("��ȭ��ȣ: " + getTel);
			System.out.println("�ּ�: " + getAdress);
			System.out.println("���Գ�¥: " + getDate);
			
			memberVO vo = new memberVO(getEmail,getTel,getAdress);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginvo", vo);	
			
			response.sendRedirect("main.jsp"); 
			
	
		}
		
		//5. ���� ���� �� (id�� ���� ��/ pw�� Ʋ���� �� ) �̵��������ÿ�.
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