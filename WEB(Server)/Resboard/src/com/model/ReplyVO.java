package com.model;

public class ReplyVO {
	private int num;
	private int boardnum;
	private String content;
	private String writer;
	
	public ReplyVO(String content, String writer) {
		super();
		this.content = content;
		this.writer = writer;
	}

	public int getNum() {
		return num;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
}