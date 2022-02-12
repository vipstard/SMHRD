package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {
	
	public ArrayList<BoardVO> getList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> al = new ArrayList<BoardVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			String sql = "select num, name, writer, views from board";
			
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				
				int getNum = rs.getInt(1);
				String getName = rs.getString(2);
				String getWriter = rs.getString(3);
				int getViews = rs.getInt(4);
				
				BoardVO vo = new BoardVO(getNum, getName, getWriter, getViews);
				al.add(vo);
			}//end of while
			
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
		}
		return al;
	}// end of getList
	public BoardVO getOneList(int num) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			String sql = "select name, writer, location, content from board where num = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			
			if(rs.next()){
				
				String getName = rs.getString(1);
				String getWriter = rs.getString(2);
				String getLocation = rs.getString(3);
				String getContent = rs.getString(4);
				
				vo = new BoardVO(getName, getWriter, getLocation, getContent);
			}//end of while
			
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
		}
		return vo;
	}// end of getOneList
	public ArrayList<ReplyVO> getReply(int num) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ArrayList<ReplyVO> al = new ArrayList<ReplyVO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			
			conn = DriverManager.getConnection(url,dbid,dbpw);
			
			String sql = "select content, writer from reply where boardnum = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				String getContent = rs.getString(1);
				String getWriter = rs.getString(2);
				
				ReplyVO vo = new ReplyVO(getContent, getWriter);
				al.add(vo);
			}//end of while
			
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
		}
		return al;
	}// end of 
	
}// end of class