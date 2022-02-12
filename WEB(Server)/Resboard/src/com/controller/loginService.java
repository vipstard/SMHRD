package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.model.MemberVO;

@WebServlet("/loginService")
public class loginService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//application/x-www-form-urlencoded
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		StringBuffer sb = new StringBuffer(); //읽어온 데이터 저장
		String line = null; //버퍼안에 데이터 읽을때 사용(임시저장)
		
		BufferedReader reader = request.getReader(); //요청데이터 읽을때 사용
		while((line = reader.readLine()) != null) {//읽을 데이터가 있을때 반복 수행
			sb.append(line); //읽어온데이터를 sb(StringBuffer)에 추가
		}
		
		JsonParser parser = new JsonParser(); //파싱(문자열 -> JSON)
		JsonElement element = parser.parse(sb.toString());
		
		String id = element.getAsJsonObject().get("id").getAsString(); //키값이 id인 데이터
		String pw = element.getAsJsonObject().get("pw").getAsString(); //키값이 pw인 데이터
		
		System.out.println("아이디 : "+ id);
		System.out.println("비밀번호 : "+ pw);
		
		
		
		//로그인 가능할 경우 콘솔창에 : 로그인 성공 출력(페이지이동x)
		//로그인 불가능할 경우 콘솔창에 : 로그인 실패 (페이지이동x)
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			String sql = "select * from mem where id = ? and pw = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			
			PrintWriter out = response.getWriter();
			
			if(rs.next()){
				String getid = rs.getString(1);
				String getpw = rs.getString(2);
				String nick = rs.getString(3);
				
				//db에서 읽어온 사용자 데이터 -> MemberVO 객체 초기화
				MemberVO vo = new MemberVO(getid, getpw, nick);
				
				System.out.println("로그인 성공");
				
				//세션이 삭제되기 전까지 로그인한 사용자의 정보 기억
				HttpSession session = request.getSession();
				session.setAttribute("member", vo);
				
				//"success" 응답
				out.print("success");
			}else {
				System.out.println("로그인 실패");
				//"fail" 응답
				out.print("fail");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}// end of finally
	}//end of service
}//end of class
