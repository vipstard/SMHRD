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
		//1. email 값 받기 (getParameter사용)
		
		String email = request.getParameter("email");
		
		//2. memberDAO email이 사용할 수 있는 email인지 확인해주는 메서드 (idCheck())
		//반환값 : 있는 아이디면 true / 없는 아이디면 false
		memberDAO dao = new memberDAO();
		boolean ck = dao.email_Check(email);
		
		//3. console에 true/false(반환값) 출력
		PrintWriter out = response.getWriter();
		out.print(ck);
	}

}
