package com.model;

public class BoardVO {
	private int num;
	private String name;
	private String writer;
	private String location;
	private String content;
	private int views;
	
	public BoardVO(String name, String writer, String location, String content) {
		super();
		this.name = name;
		this.writer = writer;
		this.location = location;
		this.content = content;
	}

	public BoardVO(int num, String name, String writer, int views) {
		super();
		this.num = num;
		this.name = name;
		this.writer = writer;
		this.views = views;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getWriter() {
		return writer;
	}

	public String getLocation() {
		return location;
	}

	public String getContent() {
		return content;
	}

	public int getViews() {
		return views;
	}
}