package unit10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job= request.getParameter("job");
		String interests[] = request.getParameterValues("interest");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("����� ������ ���� : <b>");
		out.print(job);
		
		
		out.print("</b><hr>����� ������ ���ɺо� : <b>");
		if(interests==null) {
			out.print("������ �о߰� �����ϴ�.");
		
			
		}
		
		else {
		
			for(String s : interests) {
				out.print(s + " ");
			}
		}
			
		}
		

	

}
