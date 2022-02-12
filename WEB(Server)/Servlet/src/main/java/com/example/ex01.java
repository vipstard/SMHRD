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
		//			WAS(Tomcat)에서 설치되어 동작하는 서버 프로그램
		//			java=main / Servlet=service
		//ip주소 : http://59.0.249.21:8081/Servlet/ex01
		//System.out.println("누군가접속");
		
		//request : 서버프로그램을 요청하는 사용자의 모든 데이터를 갖고있는 객체
		String ip = request.getRemoteAddr(); //사용자의 IP를 가져올 수 있는 기능
		System.out.println("접속한 사용자의 IP : " + ip);
		
		//response : 서버프로그램에서 사용자에게 응답을 할 수 있게 해주는 객체
		response.setContentType("text/html; charset=euc-kr");
		
		//응답하는 파일을 생성하고 인코딩 방식 지정
		PrintWriter out = response.getWriter();
		//응답하는 파일과 현재 작업하고 있는 Servlet파일을 이어주는 통로객체 생성
		out.print("응답페이지<br>");
		
		
		
		// 선생님이 접속했을 때는 "선생님 환영합니다"를 출력
		// 팀원이 접속했을 때는 "팀원 환영합니다."를 출력
		// 다른 사람들이 접속 했을 때는 "손님 환영합니다"를 출력
		
		//String ip = request.getRemoteAddr();
		
		if(ip.equals("59.0.249.7")) {
			out.println("선생님 환영합니다. >> " + ip);
		}
		
		else if(ip.equals("220.71.160.59"))
		{
			
			out.println("팀원 환영합니다. >> " + ip);
		}
		
		else {
			out.println("손님 환영합니다. >> " + ip);
		}
		
		
	}

}
