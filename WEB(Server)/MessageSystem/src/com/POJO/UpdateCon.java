package com.POJO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Command.Command;
import com.DAO.memberDAO;
import com.VO.memberVO;

public class UpdateCon	implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		

		HttpSession session = request.getSession();
		memberVO vo = (memberVO)session.getAttribute("loginvo");
		
		
		String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
	
		// DAO��ü �����ؼ� DAO ���� ������Ʈ �޾ƿ��� 
		memberDAO dao = new memberDAO();
		
		int cnt=dao.update(email, pw, tel, address);
		
		if(cnt>0) {
			//3. ���� �Ϸ� �� main.jsp �̵��Ͻÿ�
			System.out.println("��������");
			
			//������� ������ ���� ������ �ִ� vo��ü
			memberVO vo2 = new memberVO(email, tel, address);
			
			session.setAttribute("loginvo", vo2);
			
			
		}
		return "main.jsp";
	}

	
}