package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Send")
public class Send extends HttpServlet {
	
	public static String led= "0";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// LED�� ���� �����ϴ� ����
		
		led = request.getParameter("led");
		
		// index.html �� �ǵ��� ��������
		
		response.sendRedirect("index.html");
		
	}

}
