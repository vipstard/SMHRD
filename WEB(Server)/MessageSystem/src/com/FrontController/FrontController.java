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

//Ȯ�������� ��� : � ��û �̴� ���� �ڿ� .do �� �پ������� �� ��������
//�޾Ƽ� ó��
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����");
		request.setCharacterEncoding("euc-kr");
		//��û URI
		String reqURI = request.getRequestURI();
		System.out.println("��û URI : " + reqURI);
		
		//������Ʈ ��
		String path = request.getContextPath();
		System.out.println("������Ʈ �� : " + path);
		
		//���ڿ� �ڸ��� -> reqURI - ������Ʈ��/
		String result = reqURI.substring(path.length()+1);
		System.out.println("URI : " + result);
		
		Command command=null;
		
		if(result.equals("LoginCon.do")) {
			//LoginCon (Command����)
			//execute �޼��� ȣ��
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
