package com.FrontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.POJO.DeleteCon;
import com.POJO.JoinCon;
import com.POJO.LoginCon;
import com.POJO.LogoutCon;
import com.POJO.UpdateCon;

//확장자패턴 사용 : 어떤 요청 이던 간에 뒤에 .do 가 붙어있으면 이 서블릿에서
//받아서 처리
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도착");
		request.setCharacterEncoding("euc-kr");
		//요청 URI
		String reqURI = request.getRequestURI();
		System.out.println("요청 URI : " + reqURI);
		
		//프로젝트 명
		String path = request.getContextPath();
		System.out.println("프로젝트 명 : " + path);
		
		//문자열 자르기 -> reqURI - 프로젝트명/
		String result = reqURI.substring(path.length()+1);
		System.out.println("URI : " + result);
		
		Command command=null;
		
		if(result.equals("LoginCon.do")) {
			//LoginCon (Command구현)
			//execute 메서드 호출
			command = new LoginCon();
		}
		
		else if(result.equals("JoinCon.do")) {
			
			command = new JoinCon();
		}
		
		else if(result.equals("UpdateCon.do")) {
			command = new UpdateCon();		
		}
				
		else if(result.equals("DeleteCon.do")) {
			command = new DeleteCon();
		}
				
		else if(result.equals("LogoutCon.do")) {
			command = new LogoutCon();
		}
		
		else if(result.equals("IdCheckCon.do")) {
					
		}
		
		String url =  command.execute(request, response);
		response.sendRedirect(url);
	}
	

}
