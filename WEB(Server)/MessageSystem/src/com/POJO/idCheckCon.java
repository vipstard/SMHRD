package com.POJO;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class idCheckCon implements Command{
	
			@Override
			public String execute(HttpServletRequest request, HttpServletResponse response) {
				// TODO Auto-generated method stub
			
				
				//1. email �� �ޱ� (getParameter���)
				
				String email = request.getParameter("email");
				
				//2. memberDAO email�� ����� �� �ִ� email���� Ȯ�����ִ� �޼��� (idCheck())
				//��ȯ�� : �ִ� ���̵�� true / ���� ���̵�� false
				memberDAO dao = new memberDAO();
				boolean ck = dao.email_Check(email);
				
				System.out.println(email);
				System.out.println(ck);
				//3. console�� true/false(��ȯ��) ���
			
				return String.valueOf(ck); // boolean -> string
			}
			
		
}
