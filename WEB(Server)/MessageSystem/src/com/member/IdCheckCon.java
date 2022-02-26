package com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.memberDAO;

@WebServlet("/IdCheckCon")
public class IdCheckCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. email �� �ޱ� (getParameter���)
		
		String email = request.getParameter("email");
		
		//2. memberDAO email�� ����� �� �ִ� email���� Ȯ�����ִ� �޼��� (idCheck())
		//��ȯ�� : �ִ� ���̵�� true / ���� ���̵�� false
		memberDAO dao = new memberDAO();
		boolean ck = dao.email_Check(email);
		
		//3. console�� true/false(��ȯ��) ���
		PrintWriter out = response.getWriter();
		out.print(ck);
	}

}
