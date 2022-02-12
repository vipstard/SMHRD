package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02")
public class ex02 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 =Integer.parseInt(request.getParameter("num1")) ;
		int num2 =Integer.parseInt(request.getParameter("num2")) ;
		String op = request.getParameter("op");
		//사용자가 입력한 정보를 가져오는 기능
		response.setContentType("text/html; charset=euc-kr");
		
		//클라이언트 - 서버 연결해주는 통로(스트림)
		PrintWriter out = response.getWriter();
		//사용자가 선택한 값을 통해서 해당하는 사칙연산 결과값을 출력하시오.
		//스트림을 통해서 출력
		if(op.equals("+")) {
		out.println(num1+ " + " + num2 + " = " + (num1+num2) );
	}
	else if (op.equals("-"))
	{
		out.println(num1+ " - " + num2 + " = " + (num1-num2) );
	}
	
	else if(op.equals("*")) {
		out.println(num1+ " * " + num2 + " = " + (num1*num2) );
	}
	
	else {
		out.println(num1+ " / " + num2 + " = " + (num1/num2) );
	}

}
}
