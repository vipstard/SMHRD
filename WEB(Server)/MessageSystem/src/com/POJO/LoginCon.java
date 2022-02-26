package com.POJO;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

public class LoginCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 사용자가 입력한 email 과 pw를 받아오시오.

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		memberDAO dao = new memberDAO();
		memberVO vo = dao.login(email, pw);

		if (vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginvo", vo);

		}

		return "main.jsp"; // 어디로 이동할건지
	}

}
