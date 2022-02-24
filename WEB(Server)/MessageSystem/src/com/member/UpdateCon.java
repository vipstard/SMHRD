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

import com.DAO.memberDAO;
import com.VO.memberVO;


@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ������ ���ڵ�
		request.setCharacterEncoding("euc-kr");
		
		
		//pw, tel, address / email -> session 
		
		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginvo");
		
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
	
		// DAO��ü �����ؼ� DAO ���� ������Ʈ �޾ƿ��� 
		memberDAO dao = new memberDAO();
		
		int cnt=dao.update(email, pw, tel, address);
		
		if(cnt>0) {
			//3. ���� �Ϸ� �� main.jsp �̵��Ͻÿ�
			System.out.println("��������");
			
			//������� ������ ���� ������ �ִ� vo��ü
			memberVO vo2 = new memberVO(email, tel, address);
			
			session.setAttribute("loginvo", vo2);
			
			response.sendRedirect("main.jsp");
		}
		
		else {
			System.out.println("��������");
			response.sendRedirect("main.jsp");
		}
		
	}

}