package com.peisia.db;

public class Dto {
	public String num;
	public String title;
	public String id;
	public String content;
	public String datatime;
	public String topock;

	public Dto(String title, String id, String content, String datatime) {
		this.title = title;
		this.id = id;
		this.content = content;
		this.datatime = datatime;
	}

	public Dto(String num, String title, String id, String content, String datatime, String topock) {
		this.num = num;
		this.title = title;
		this.id = id;
		this.content = content;
		this.datatime = datatime;
		this.topock = topock;
	}

	public Dto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

}
