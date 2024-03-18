package com.peisia.db;

public class Dto {
//	public String category;
	public String num;
	public String title;
	public String id;
	public String content;
	public String datatime;
	public String topick;

	public Dto(String title, String id, String content, String datatime) {
		this.title = title;
		this.id = id;
		this.content = content;
		this.datatime = datatime;
	}
	
	public Dto(String title, String id, String content, String datatime,String topick) {
		this.title = title;
		this.id = id;
		this.content = content;
		this.datatime = datatime;
		this.topick = topick;
	}

	public Dto(String num, String title, String id, String content, String datatime, String topick) {
		this.num = num;
		this.title = title;
		this.id = id;
		this.content = content;
		this.datatime = datatime;
		this.topick = topick;
	}

	public Dto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Dto(String title, String content, String topick_new) {
		this.title = title;
		this.content = content;
		this.topick = topick_new;
	}

}
