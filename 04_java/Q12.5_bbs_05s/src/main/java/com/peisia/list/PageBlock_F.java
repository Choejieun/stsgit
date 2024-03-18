package com.peisia.list;

import com.peisia.db.Board;

public class PageBlock_F {
	static public int npageNum = 0;
	static public int Full_Block = 0;
	public static int now_Block = 0;
	public static int start_Block = 0;
	public static int end_Block = 0;
	
	 static public int npageNum_set() {
		 npageNum = Integer.parseInt(Setting.pageNum);
		return npageNum;
	}
	
	static public void PageBlock_F() {
		//전체 블럭 수 구하기
		Full_Block = (int)Math.ceil((double) Setting.totalPage / Board.PAGE_LINK_AMOUNT);
	
		//현재 블럭 구하기
		now_Block = (int)Math.ceil((double)npageNum / Board.PAGE_LINK_AMOUNT);
		System.out.println("현재 페이지 : "+npageNum);
		System.out.println("현재블록 : "+now_Block);
		
		//시작 페이지 블럭 구하기 (결과값이 1 이상이면 *블럭에 보이는 수+1 하여 블럭당 첫번째 숫자다.)
		 start_Block =(int)Math.ceil((double) (now_Block-1) * Board.PAGE_LINK_AMOUNT+1);
		//마지막 페이지 블럭 구하기 (결과값이 현재 블럭에서 보이는 블럭당 마지막 숫자다.)
		end_Block =(int)Math.ceil((double) now_Block * Board.PAGE_LINK_AMOUNT);
		if(end_Block > Setting.totalPage){
			end_Block = Setting.totalPage;
		}
	}
}
