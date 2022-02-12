package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex01")
public class ex01 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Servlet : Server + Applet 
		//			WAS(Tomcat)���� ��ġ�Ǿ� �����ϴ� ���� ���α׷�
		//			java=main / Servlet=service
		//ip�ּ� : http://59.0.249.21:8081/Servlet/ex01
		//System.out.println("����������");
		
		//request : �������α׷��� ��û�ϴ� ������� ��� �����͸� �����ִ� ��ü
		String ip = request.getRemoteAddr(); //������� IP�� ������ �� �ִ� ���
		System.out.println("������ ������� IP : " + ip);
		
		//response : �������α׷����� ����ڿ��� ������ �� �� �ְ� ���ִ� ��ü
		response.setContentType("text/html; charset=euc-kr");
		
		//�����ϴ� ������ �����ϰ� ���ڵ� ��� ����
		PrintWriter out = response.getWriter();
		//�����ϴ� ���ϰ� ���� �۾��ϰ� �ִ� Servlet������ �̾��ִ� ��ΰ�ü ����
		out.print("����������<br>");
		
		
		
		// �������� �������� ���� "������ ȯ���մϴ�"�� ���
		// ������ �������� ���� "���� ȯ���մϴ�."�� ���
		// �ٸ� ������� ���� ���� ���� "�մ� ȯ���մϴ�"�� ���
		
		//String ip = request.getRemoteAddr();
		
		if(ip.equals("59.0.249.7")) {
			out.println("������ ȯ���մϴ�. >> " + ip);
		}
		
		else if(ip.equals("220.71.160.59"))
		{
			
			out.println("���� ȯ���մϴ�. >> " + ip);
		}
		
		else {
			out.println("�մ� ȯ���մϴ�. >> " + ip);
		}
		
		
	}

}
