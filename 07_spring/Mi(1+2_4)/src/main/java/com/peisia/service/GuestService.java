package com.peisia.service;

import org.springframework.ui.Model;

import com.peisia.dto.GuestDto;


public interface GuestService {
//	public ArrayList<GuestDto> getList(); //[1]리스트
	public Model getList(int currentPage, Model model); //[1]리스트
//    public int getTotalCount();     // [1-1] 전체 행 수를 가져오는 메서드 추가
	public GuestDto read(long bno); //[2]읽기
	public void del(long bno);	//[3]삭제
	public void write(GuestDto dto);//[4].방명록-write
	public void modify(GuestDto dto);//[5].방명록-modify
	public void noRe();
	public void noRe2();
}
