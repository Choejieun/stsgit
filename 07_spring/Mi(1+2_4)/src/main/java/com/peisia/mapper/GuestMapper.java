package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.Dto;
import com.peisia.dto.GuestDto;

public interface GuestMapper {
//	public ArrayList<GuestDto> getList(); //[1]리스트
	public ArrayList<GuestDto> getList(Dto dto); //[1]리스트
    public int getTotalCount();     // [1-1] 전체 행 수를 가져오는 메서드 추가
	public GuestDto read(long bno); //[2]읽기
	public void del(long bno); //[3]삭제
	public void write(GuestDto dto);//[4].방명록-write ★얘는 다수 안됨
	public void modify(GuestDto dto);//[5].방명록-modify
	public void noRe();
	public void noRe2();
}
