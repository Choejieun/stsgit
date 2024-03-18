package com.peisia.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.peisia.list.Setting;
import com.peisia.util.Cw;

public class Dao extends Da {
	/* (1/5)삭제 */
	public void del(String no) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]

		String sql = String.format("delete from %s where num=%s", Db.TABLE_PS_BOARD_FREE, no);
		Cw.Wn(sql);
		super.update(sql);

		super.close(); // [고정4,5]
	}

	/* (1/5)글 리스트 */
	public ArrayList<Dto> list(String page) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {

			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;

			String sql = String.format("select * from %s ORDER BY num desc limit %s,%s;", Db.TABLE_PS_BOARD_FREE,startIndex,Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 기본 : "+sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
//				num = rs.getInt("num");
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
	
	/* (1/5)글 리스트<검색> */
	public ArrayList<Dto> searchlist(String page, String word) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			/*현재 페이지 구하기*/
			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT; //arrayList 0부터 시작임

//			String sql = String.format("select * from %s  where title like '%%%s%%' limit %s,%d ORDER BY num desc; ", Db.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
			String sql = String.format("SELECT * FROM %s WHERE title LIKE '%%%s%%' ORDER BY num DESC LIMIT %d, %d;", Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);

			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}

	
	
	/* 총 글 수 구하기 */
	public int getPostcount() {
		int count = 0; //총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s;", Db.TABLE_PS_BOARD_FREE);
			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
		}
		super.close(); // [고정4,5]
		return count; // 총 글 수 반환
	}
	/* 총 페이지 수 구하기 */
	public int getTotalPagecount() {
		int totalPageCount = 0;
		int count = getPostcount(); // 전체 글 수
		
		if (count % 3 == 0) { 	//나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}
		else { 							//나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	
	
	/* 총 글 수 구하기<검색> */
	public int getSearchPostcount(String word) {
		int count = 0; //총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s  where title like '%%%s%%';", Db.TABLE_PS_BOARD_FREE,word);
			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
		}
		super.close(); // [고정4,5]
		return count; // 총 글 수 반환
	}
	/* 총 페이지 수 구하기<검색> */
	public int getSearchTotalPagecount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostcount(word); // 전체 글 수
		
		if (count % 5 == 0) { 	//나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}
		else { 							//나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	} 
	
	
	
	
	
	
	
	/* 총 글 수 구하기<토픽> */
	public int getTopickPostcount(String word) {
		int count = 0; //총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s  where topink like '%%%s%%';", Db.TABLE_PS_BOARD_FREE,word);
			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
		}
		super.close(); // [고정4,5]
		return count; // 총 글 수 반환
	}
	/* 총 페이지 수 구하기<토픽> */
	public int getTopickTotalPagecount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostcount(word); // 전체 글 수
		
		if (count % 3 == 0) { 	//나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		}
		else { 							//나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* (1/5)글 리스트  <정렬>*/
	public ArrayList<Dto> oldlist(String page) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {

			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;

			String sql = String.format("select * from %s ORDER BY num limit %s,%s;", Db.TABLE_PS_BOARD_FREE,startIndex,Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 기본 : "+sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
//				num = rs.getInt("num");
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
	
	/* (1/5)글 리스트<검색>  <정렬>*/
	public ArrayList<Dto> oldsearchlist(String page, String word) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			/*현재 페이지 구하기*/
			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT; //arrayList 0부터 시작임

//			String sql = String.format("select * from %s  where title like '%%%s%%' limit %s,%d ORDER BY num desc; ", Db.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
			String sql = String.format("SELECT * FROM %s WHERE title LIKE '%%%s%%' ORDER BY num LIMIT %d, %d;", Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);

			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* (1/5)글 리스트  <최신순 토픽 검색없음>*/
	public ArrayList<Dto> topinkList(String page) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
//			list.jsp?topink=sotory
			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT;

			String sql = String.format("select * from %s WHERE topick desc LIKE '%%%s%%' ORDER BY num  limit %s,%s;", 
					Db.TABLE_PS_BOARD_FREE,Setting.topink,startIndex,Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 기본 : "+sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
//				num = rs.getInt("num");
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
	
	/* (1/5)글 리스트<검색>  <정렬>*/
	public ArrayList<Dto> topinklistSearchList(String page, String word) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			/*현재 페이지 구하기*/
			int startIndex = ((Integer.parseInt(page))-1)*Board.LIST_AMOUNT; //arrayList 0부터 시작임

//			String sql = String.format("select * from %s  where title like '%%%s%%' limit %s,%d ORDER BY num desc; ", Db.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
			String sql = String.format("SELECT * FROM %s WHERE title LIKE '%%%s%%' ORDER BY num LIMIT %d, %d;", Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);

			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
			while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
				posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
						rs.getString("datatime"), rs.getString("topick")));
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
	

}
