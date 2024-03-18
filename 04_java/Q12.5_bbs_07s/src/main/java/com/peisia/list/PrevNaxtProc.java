package com.peisia.list;

import com.peisia.db.Board;

public class PrevNaxtProc {
	static public int prevPage = 0;
	static public int naxtPage = 0;
	static public boolean hasPrev;
	static public boolean hasNext;
public static void PrevNaxtProc() {
	// [이전] 블럭 버튼 활성화 유무 검색
	hasPrev = true;
	if(PageBlock_F.now_Block == 1){
		hasPrev = false;
	}else{
		hasPrev = true;
		prevPage = (PageBlock_F.now_Block -1)* Board.PAGE_LINK_AMOUNT; //페이징 시 최대 페이지를 저장
	}
	// [다음] 블럭 버튼 활성화 유무 검색
	hasNext = true;
	System.out.println("최대 블록 : "+PageBlock_F.Full_Block);
	if(PageBlock_F.now_Block >= PageBlock_F.Full_Block){
		hasNext = false;
	}else{
		hasNext = true;
		naxtPage = PageBlock_F.now_Block * Board.PAGE_LINK_AMOUNT+1;//페이징 시 최소 페이지를 저장
	}
}
	
}
