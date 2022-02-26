package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberDAO;

public class DeleteCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");

		memberDAO dao = new memberDAO(); // DAO 객체 선언
		int cnt = dao.delete(email); // DAO 객체의 회원삭제 함수 호출 (delete 함수)

		return "selectMember.jsp";
	}

}
