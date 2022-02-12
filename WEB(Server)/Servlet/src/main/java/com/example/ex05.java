package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex05")
public class ex05 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		// Post����϶� ���ڵ����(���� ó�� ����°� ����.)
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		
		String gender = request.getParameter("gender");
		String hobby_res="";
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		String PW_R = request.getParameter("PW_R");
		String ABO = request.getParameter("ABO");
		String date = request.getParameter("date");
		String color = request.getParameter("color");
		String textarea = request.getParameter("textarea");
		String[] hobby = request.getParameterValues("hobby");
		
		out.println("ID : " + ID+"<br>");
		out.println("PW : " + PW+"<br>");
		out.println("PW_R : " + PW_R+"<br>");
		out.println("���� : " + gender+"<br>");
		out.println("������ : " + ABO+"<br>");
		out.println("���� : " + date+"<br>");
		
		for(int i=0; i<hobby.length; i++) {
			hobby_res+=hobby[i]+" ";
	}
		
	out.println("��� : "+ hobby_res+"<br>");
	out.println("�����ϴ� �� : " + color+"<br>");
	out.println("�ϰ���� �� : " + textarea+"<br>");
	out.println();
	}

}
