package com.peisia.list;

import java.util.ArrayList;

import com.peisia.db.Board;
import com.peisia.db.Dao;
import com.peisia.db.Dto;

public class Setting {
	// 2024.02.06 업데이트

	public int Full_Block = 0;
	public int now_Block = 0;
	public int start_Block = 0;
	public int end_Block = 0;

	public int prevPage = 0;
	public int naxtPage = 0;
	public boolean hasPrev = true;
	public boolean hasNext = true;

	public int pageNum = 0;
	public int getPageNum() {
		return pageNum;
	}
	public String searchWord;
	public String getSearchWord() {
		return searchWord;
	}
	public String arrayOld;
	public String getArrayOld() {
		return arrayOld;
	}
	public String topick;
	public String getTopick() {
		return topick;
	}
	public int totalPage = 0; // 전체 페이지 변수 선언
	ArrayList<Dto> posts;
	private Dao dao;

	public Setting(Dao dao, String topick, String word, String nowpage, String old) {
		System.out.println("럽럽럽");
		this.dao = dao;
		this.topick = topick;
		this.searchWord = word;
		this.arrayOld = old;
		this.pageNum = Integer.parseInt(nowpage);
		
		if(topick.equals("all")&&(searchWord == null || searchWord.equals("null"))) {
			totalPage = dao.getTotalPagecount(); // 검색, 토픽이 없는 경우
			getListAll(arrayOld);
		}else {
		if (searchWord == null || searchWord.equals("null")) {
			System.out.println("토픽O,검색X 도달");
			totalPage = dao.getTotalPagecount(topick); // 검색이 없는 경우
			getList(arrayOld, topick);
		} else {
			if(topick.equals("all")){
				totalPage = dao.getSearchTotalPagecount(searchWord); // 검색O/토픽X 경우
				getListAll(word, arrayOld);
			}else {
				System.out.println("토픽O,검색O 도달");
			totalPage = dao.getSearchTotalPagecount(searchWord, topick); // 검색이 있는 경우
			getList(word, arrayOld, topick);
			}
		}
		}
		// 전체 블럭 수 구하기
		Full_Block = (int) Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);
		// 현재 블럭 구하기
		now_Block = (int) Math.ceil((double) pageNum / Board.PAGE_LINK_AMOUNT);
		// 시작 페이지 블럭 구하기 (결과값이 1 이상이면 *블럭에 보이는 수+1 하여 블럭당 첫번째 숫자다.)
		start_Block = (int) Math.ceil((double) (now_Block - 1) * Board.PAGE_LINK_AMOUNT + 1);
		// 마지막 페이지 블럭 구하기 (결과값이 현재 블럭에서 보이는 블럭당 마지막 숫자다.)
		end_Block = (int) Math.ceil((double) now_Block * Board.PAGE_LINK_AMOUNT);
		if (end_Block > totalPage) {
			end_Block = totalPage;
		}
		
		System.out.println("현재 블럭"+now_Block);
		// [이전] 블럭 버튼 활성화 유무 검색
		hasPrev = true;
		if (now_Block == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
			prevPage = (now_Block - 1) * Board.PAGE_LINK_AMOUNT; // 페이징 시 최대 페이지를 저장
		}
		// [다음] 블럭 버튼 활성화 유무 검색
		hasNext = true;
		if (now_Block >= Full_Block) {
			hasNext = false;
		} else {
			hasNext = true;
			naxtPage = now_Block * Board.PAGE_LINK_AMOUNT + 1;// 페이징 시 최소 페이지를 저장
		}

	}
	public void getListAll(String old) {
		int startIndex = (pageNum - 1) * Board.LIST_AMOUNT;
		posts = dao.listAll(startIndex, old); // 전체 기준 데이터 가져오기}
	}

	public void getList(String old, String topick) {
		int startIndex = (pageNum - 1) * Board.LIST_AMOUNT;
		posts = dao.list(startIndex, old, topick); // 전체 기준 데이터 가져오기}
	}
	
	public void getListAll(String word, String old) {
		int startIndex = (pageNum - 1) * Board.LIST_AMOUNT;
		posts = dao.list(word, startIndex, old); // 전체 기준 데이터 가져오기}
	}

	public void getList(String word, String old, String topick) {
		int startIndex = (pageNum - 1) * Board.LIST_AMOUNT;
		posts = dao.list(word, startIndex, old, topick); // 전체 기준 데이터 가져오기}
	}
	

	/* 글 리스트 객체 얻는 함수 */
	public ArrayList<Dto> getPosts() {
		return posts;
	}

	public String getHtmlPageList_prev() {
		String htmla = "";

		if (hasPrev) { 	//이전 버튼
			if (searchWord == null) { // 키워드 X
				htmla = htmla + String.format("<a href='/board/list?page=%d&topick=%s&old=%s'>Prev</a>",prevPage,topick,arrayOld);
			} else {
				htmla = htmla + String.format("<a href='/board/list?page=%d&topick=%s&old=%s&word=%s'>Prev</a>",prevPage,topick,arrayOld,searchWord);
			}}
		System.out.println("이전버튼 : "+htmla);
		return htmla;
	}
	public String getHtmlPageList_next() {
		String html = "";

		if (hasNext) { 	//다음 버튼
			if (searchWord == null) { // 키워드 X
				html = html + String.format("<a href='/board/list?page=%d&topick=%s&old=%s'>Next</a>",naxtPage,topick,arrayOld);
			} else {
				html = html + String.format("<a href='/board/list?page=%d&topick=%s&old=%s&word=%s'>Next</a>",naxtPage,topick,arrayOld,searchWord);
			}}
		System.out.println("다음버튼 : "+html);
		return html;
	}
	
	public String getHtmlPageList_num() {
		String html = "";

		if (hasPrev) { 	//최초 페이지로
			if (searchWord == null) { // 키워드 X
				html = html +String.format("<a href='/board/list?page=1&old=%s&topick=%s'>1 ···</a>",arrayOld,topick);
			} else {
				html = html +String.format("<a href='/board/list?page=1&word=%s&old=%s&topick=%s'>1 ···</a>",searchWord,arrayOld,topick);
			}}
		
		for(int i = this.start_Block; i <= this.end_Block; i++ ){ //블럭당 리스트 노출
			if(i == pageNum){
				html = html+String.format("<strong>[ %d ]</strong>", i);
			}else{
				if(searchWord == null){ //키워드 X
					html = html+String.format("<a href='/board/list?page=%d&topick=%s&old=%s'>%d</a>", i,topick,arrayOld,i);
				}else {
					html = html+String.format("<a href='/board/list?page=%d&topick=%s&old=%s&word=%s'>%d</a>", i,topick,arrayOld,searchWord,i);
				}
			}}
		
		if (hasNext) { 	//최종 페이지로
			if (searchWord == null) { // 키워드 X
				html = html +String.format("<a href='/board/list?page=%d&topick=%s&old=%s'>··· %d</a>",totalPage,topick,arrayOld,totalPage);
			} else {
				html = html +String.format("<a href='/board/list?page=%d&word=%s&topick=%s&old=%s''>··· %d</a>",totalPage,searchWord,topick,arrayOld,totalPage);
			}}
		
		return html;
	}
	
	public String getarrayOld_buttom() {
		String html = "";
		if (searchWord == null) { // 키워드 X
			System.out.println("정렬실행");
			html = html+String.format("<li><a href='/board/list?page=%d&old=desc&topick=%s'>최신순</a></li>",pageNum,topick);
			html = html+String.format("<li><a href='/board/list?page=%d&old= &topick=%s'>오래된순</a></li>",pageNum,topick);
		}else {
			System.out.println("정렬실행-검색");
			html = html+String.format("<li><a href='/board/list?page=%d&old=desc&topick=%s&word=%s'>최신순</a></li>",pageNum,topick,searchWord);
			html = html+String.format("<li><a href='/board/list?page=%d&old= &topick=%s&word=%s'>오래된순</a></li>",pageNum,topick,searchWord);
		}
		return html;
	}
	
	public Setting() {System.out.println("널널널");};
}

//	//문자 데이터 가져오기
//	public ArrayList<Dto> posts_void() {
//		Dao dao = new Dao(); // Dao 불러오기
//		if (searchWord == null || searchWord.equals("null")) {
//			if (arrayOld == null || arrayOld.equals("null")) {
//					posts = dao.list(pageNum); // 전체 기준 데이터 가져오기}
//				} else {
//					posts = dao.oldlist(pageNum); // 전체 기준 데이터 가져오기
//				}
//			}else {
//				if (arrayOld == null || arrayOld.equals("null")) {
//					posts = dao.searchlist(pageNum, searchWord); // 검색 기준 데이터 가져오기
//				} else {
//					posts = dao.oldsearchlist(pageNum, searchWord); // 전체 기준 데이터 가져오기}
//				}
//			}
//		return posts;
//
//	}
