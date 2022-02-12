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
		
		StringBuffer sb = new StringBuffer(); //�о�� ������ ����
		String line = null; //���۾ȿ� ������ ������ ���(�ӽ�����)
		
		BufferedReader reader = request.getReader(); //��û������ ������ ���
		while((line = reader.readLine()) != null) {//���� �����Ͱ� ������ �ݺ� ����
			sb.append(line); //�о�µ����͸� sb(StringBuffer)�� �߰�
		}
		
		JsonParser parser = new JsonParser(); //�Ľ�(���ڿ� -> JSON)
		JsonElement element = parser.parse(sb.toString());
		
		String id = element.getAsJsonObject().get("id").getAsString(); //Ű���� id�� ������
		String pw = element.getAsJsonObject().get("pw").getAsString(); //Ű���� pw�� ������
		
		System.out.println("���̵� : "+ id);
		System.out.println("��й�ȣ : "+ pw);
		
		
		
		//�α��� ������ ��� �ܼ�â�� : �α��� ���� ���(�������̵�x)
		//�α��� �Ұ����� ��� �ܼ�â�� : �α��� ���� (�������̵�x)
		
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
				
				//db���� �о�� ����� ������ -> MemberVO ��ü �ʱ�ȭ
				MemberVO vo = new MemberVO(getid, getpw, nick);
				
				System.out.println("�α��� ����");
				
				//������ �����Ǳ� ������ �α����� ������� ���� ���
				HttpSession session = request.getSession();
				session.setAttribute("member", vo);
				
				//"success" ����
				out.print("success");
			}else {
				System.out.println("�α��� ����");
				//"fail" ����
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
