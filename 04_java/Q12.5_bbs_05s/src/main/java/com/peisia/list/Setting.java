package com.peisia.list;

import java.util.ArrayList;

import com.peisia.db.Dao;
import com.peisia.db.Dto;

public class Setting {
	static public String pageNum;
	static public String searchWord;
	static public int totalPage = 0; //전체 페이지 변수 선언
	
	public static String PageNum_void() {
		if (pageNum == null) {
			pageNum = "1";
		}
		return pageNum;
	}
	
	 public static int totalPage_void() {
	Dao dao = new Dao(); //Dao 불러오기
	if (searchWord == null || searchWord.equals("null")) {
		totalPage = dao.getTotalPagecount();
	} else {
		totalPage = dao.getSearchTotalPagecount(searchWord);
	};
	return totalPage;
}
	 public static ArrayList<Dto> posts_void(ArrayList<Dto> posts) {
	Dao dao = new Dao(); //Dao 불러오기
	if (searchWord == null || searchWord.equals("null")) {
		posts = dao.list(pageNum); //전체 기준 데이터 가져오기
	} else {
		posts = dao.searchlist(pageNum, searchWord); //검색 기준 데이터 가져오기
	};
	return posts;
}
	 
}
