package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutCon")
public class LogoutCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. ���� ��ü ����
		HttpSession session = request.getSession();
		
		//2. session (loginvo) �� ����
		session.removeAttribute("loginvo");
		
		//3. main.jsp �̵�
		response.sendRedirect("main.jsp");
		
		
	}

}
