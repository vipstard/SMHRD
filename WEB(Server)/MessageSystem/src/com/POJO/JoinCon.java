package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

public class JoinCon implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		//1. main.jsp에서 사용자가 보내주는 정보를 받으시오(POST)
		
				String email = request.getParameter("email");
				String pw = request.getParameter("pw");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				
				memberDAO dao = new memberDAO();
				
				int cnt = dao.join(email, pw, phone, address);
				
			return "main.jsp";
			}
}
