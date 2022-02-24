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

import com.DAO.memberDAO;
import com.VO.memberVO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 사용자가 입력한 email 과 pw를 받아오시오.
		response.setContentType("text/html");
		request.setCharacterEncoding("euc-kr");
		PrintWriter out =response.getWriter();
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		System.out.println(email );
		System.out.println(pw );
		
		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);
		
		if(vo!=null){

			HttpSession session = request.getSession();
			session.setAttribute("loginvo", vo);	
			
			response.sendRedirect("main.jsp"); 
		}else { //vo=null
		response.sendRedirect("main.jsp");
	}
	}

}
