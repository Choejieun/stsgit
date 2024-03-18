package com.peisia.service;

import com.peisia.db.Dao;
import com.peisia.db.Dto;
import com.peisia.list.Setting;

public class Service {
	Dao dao = new Dao();

	public Dto read(String topick,String num) {
		return dao.read(topick,num);
	}
	
	public void write(Dto dto) {
		if (dto.topick == null) { //토픽 검사
			dto.topick = "all";
		}
		dao.insert(dto);
	}
	public void modify(Dto d, String num) {
		dao.edit(d,num);
	}

	public Setting list(String topick, String word, String page, String old) {
		if (page == null) { //1번째 페이지 인지 검사
			page = "1";
		}
		System.out.println("리스트 old : "+old);
		if (old.equals("null")) { //정렬 검사
			old = "";
		}
		Setting blp = new Setting(dao,topick,word,page,old); //Setting 클래스에서 작업 완료
		return blp;
	}



}
