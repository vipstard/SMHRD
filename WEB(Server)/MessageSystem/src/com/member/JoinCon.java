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

import com.DAO.memberDAO;


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. main.jsp에서 사용자가 보내주는 정보를 받으시오(POST)
		
		request.setCharacterEncoding("euc-kr");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		memberDAO dao = new memberDAO();
		
		int cnt = dao.join(email, pw, phone, address);
		
		
		if(cnt>0) {
			//3. 저장 완료 후 main.jsp 이동하시오
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("main.jsp");
		}
		
	}

}
