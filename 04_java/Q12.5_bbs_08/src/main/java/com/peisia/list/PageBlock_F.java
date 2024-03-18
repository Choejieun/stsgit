package com.peisia.list;

import com.peisia.db.Board;

public class PageBlock_F {
	public int npageNum = 0;
	public int Full_Block = 0;
	public int now_Block = 0;
	public int start_Block = 0;
	public int end_Block = 0;
	
//	 public int npageNum_set() {
//		 npageNum = Integer.parseInt(pageNum);
//		return npageNum;
//	}
	
	public void PageBlock_F(int totalPage) {
		//전체 블럭 수 구하기
		Full_Block = (int)Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);
	
		//현재 블럭 구하기
		now_Block = (int)Math.ceil((double)npageNum / Board.PAGE_LINK_AMOUNT);

		//시작 페이지 블럭 구하기 (결과값이 1 이상이면 *블럭에 보이는 수+1 하여 블럭당 첫번째 숫자다.)
		 start_Block =(int)Math.ceil((double) (now_Block-1) * Board.PAGE_LINK_AMOUNT+1);
		
		 //마지막 페이지 블럭 구하기 (결과값이 현재 블럭에서 보이는 블럭당 마지막 숫자다.)
		end_Block =(int)Math.ceil((double) now_Block * Board.PAGE_LINK_AMOUNT);
		if(end_Block > totalPage){
			end_Block = totalPage;
		}
	}
}
