package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04")
public class ex04 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num1"));
		
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
	
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1px solid'>");
		out.print("<tr>");
		
		for(int i=1; i<=num; i++) out.print("<td>"+i+"</td>");
		out.print("</tr>");
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
