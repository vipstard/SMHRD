package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;

public class LogoutCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//1. ���� ��ü ����
				HttpSession session = request.getSession();
				
				//2. session (loginvo) �� ����
				session.removeAttribute("loginvo");
				
				//3. main.jsp �̵�
				
		return "main.jsp";
	}

}
