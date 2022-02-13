package uni09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		String items[] = request.getParameterValues("item");
		
		if(items == null) {
			out.print("������ �׸��� �����ϴ�.");
			
		}else {
			out.println("����� ������ �׸��Դϴ�. <hr>");
			for(String item : items) {
				out.print(item + " " );
			}
		}
		
		out.println("<br><a href='javascript:history.go(-1)'>�ٽ�</a>");
		out.print("</body></html>");
		
	}

}
