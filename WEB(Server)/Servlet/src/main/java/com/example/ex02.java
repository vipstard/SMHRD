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
		//����ڰ� �Է��� ������ �������� ���
		response.setContentType("text/html; charset=euc-kr");
		
		//Ŭ���̾�Ʈ - ���� �������ִ� ���(��Ʈ��)
		PrintWriter out = response.getWriter();
		//����ڰ� ������ ���� ���ؼ� �ش��ϴ� ��Ģ���� ������� ����Ͻÿ�.
		//��Ʈ���� ���ؼ� ���
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
