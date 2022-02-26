package com.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.VO.memberVO;
import com.VO.memberVO;


//CRUD
//Create Read Update Delete

public class memberDAO {
	
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	
	
	
	public void conn() {
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	         String dbid = "hr";
	         String dbpw = "hr";
	         
	         conn = DriverManager.getConnection(url, dbid, dbpw);
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	
	
	
	public void close() {
		try {
			if(rs!=null) {
			rs.close();
			}
			
			if(psmt!=null) {
			psmt.close();
			}
			
			if(conn!=null) {
			conn.close();	
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	
	
	
	public ArrayList<memberVO> getList() {
		
		ArrayList<memberVO> al = new ArrayList<memberVO>();
	
		try {
			conn();
			
			String sql = "select email, tel, address from message_member";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				
				String email = rs.getString(1);
				String tel = rs.getString(2);
				String address = rs.getString(3);
				
				memberVO vo = new memberVO(email, tel, address);
				al.add(vo);
			}//end of while
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
		return al;
	}// end of getList
	
	
	
	
	
	
	
	public int delete(String email) {
		int cnt = 0;
		
		
		try {
			conn();
			
			if(conn!=null) {
				System.out.println("연결성공");
			}
			else {
				System.out.println("연결실패");
				
			}
	
		String sql = "delete from message_member where email=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
		
		cnt = psmt.executeUpdate();
				
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			
			close();
		}
	
		return cnt;
	}
	
	
	
	
	
	
	
	
	//LoginCon -> login()
	
	public memberVO login(String email, String pw) {

		memberVO vo =null;
		try {
			
			conn();

			//2. jdbc를 통해 member_message테이블에 있는 email의 정보를 검색하시오.
			if(conn!=null) {
				System.out.println("연결성공");
			}
			else {
				System.out.println("연결실패");
			}

		String sql = "select * from message_member where email=? and pw=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
		psmt.setString(2, pw);
		
		rs = psmt.executeQuery();
		

		if(rs.next()) {
			
			String getEmail = rs.getString(1);
			String getPw = rs.getString(2);
			String getTel = rs.getString(3);
			String getAdress = rs.getString(4);
			String getDate = rs.getString(5);
			
			System.out.println("이메일: " + getEmail);
			System.out.println("비밀번호: " + getPw);
			System.out.println("전화번호: " + getTel);
			System.out.println("주소: " + getAdress);
			System.out.println("가입날짜: " + getDate);

			vo = new memberVO(getEmail,getTel,getAdress);
			
		}


		} catch (Exception e) {

			e.printStackTrace();
		}finally {
			
			close();

		}
	return vo;
}
	
	
	
	
	
	//JoinCon -> join()
	
	public int join(String email, String pw, String phone, String address) {
		int cnt =0;
		
		try {
			
		conn();
		String sql = "insert into message_member values(?, ?, ?, ?, sysdate)";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
		psmt.setString(2, pw);
		psmt.setString(3, phone);
		psmt.setString(4, address);
		
		cnt = psmt.executeUpdate();

	
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			
			close();
			
			
		}
		
		return cnt;
	}
	


	
	//UpdateCon -> update()
	public int update(String email, String pw, String tel, String address) {

		int cnt=0;

		try {
			conn();
			
		String sql = "update message_member set pw=?, tel=?, address=? where email=?";
		
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, pw);
		psmt.setString(2, tel);
		psmt.setString(3, address);
		psmt.setString(4, email);
		
		cnt = psmt.executeUpdate();

	
		} catch (Exception e) {
	
			e.printStackTrace();
		}finally {
			
			close();
			
		}
				
		return cnt;
	}

	
	
	public boolean email_Check(String email) {
		
		boolean ck=false;
		
		try {
			
			conn();

			//2. jdbc를 통해 member_message테이블에 있는 email의 정보를 검색하시오.
			

		String sql = "select * from message_member where email=?";
		
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, email);
	
		rs = psmt.executeQuery();
	
		if(rs.next()) { //email 이 있는 경우 -> 사용 불가 email(true)
			ck=true;

		}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();

		}
	return ck;
}
	
	
}
