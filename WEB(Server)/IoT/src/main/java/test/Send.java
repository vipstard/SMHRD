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
		
		
		// LED의 값을 저장하는 서블릿
		
		led = request.getParameter("led");
		
		// index.html 로 되돌려 보내주자
		
		response.sendRedirect("index.html");
		
	}

}
