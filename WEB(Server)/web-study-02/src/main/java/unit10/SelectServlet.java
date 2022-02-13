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
		out.print("당신이 선택한 직업 : <b>");
		out.print(job);
		
		
		out.print("</b><hr>당신이 선택한 관심분야 : <b>");
		if(interests==null) {
			out.print("선택한 분야가 없습니다.");
		
			
		}
		
		else {
		
			for(String s : interests) {
				out.print(s + " ");
			}
		}
			
		}
		

	

}
