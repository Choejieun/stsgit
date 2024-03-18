package com.peisia.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	/* (2/5)글쓰기 */
	public void insert(Dto dto) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		String a = String.format("INSERT INTO main_board_3 (title, id, content, datatime, topick) "
				+ "VALUES ('%s','%s','%s',now(),'%s');"
				, dto.title,dto.id,dto.content,dto.topick);
		Cw.Wn("글 생성됨 "+a);
		super.update(a);
		dto.topick="free";

		super.close(); // [고정4,5]
	}

	/* (3/5)글 읽기 */
	public Dto read(String topick,String num) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		Dto post = null;
			try {
				ResultSet rs = st.executeQuery("select * from main_board_3 where num = " + num + ";");
				rs.next();
				post = new Dto(
						num,
						rs.getString("title"),
						rs.getString("id"),
						rs.getString("content"),
						rs.getString("datatime"),
						topick
						);
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			super.close(); // [고정4,5]
			return post;
		}
	

	/* (4/5)글 수정 */
	public void edit(Dto d,String num) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		System.out.println("널 사랑해"+num);
    	String sql = "update main_board_3 set title = '"+d.title+"',content = '"+d.content+"', topick = '"+d.topick+"' where num = "+num+";";
		Cw.Wn("글 수정됨 "+sql);
		super.update(sql);

		super.close(); // [고정4,5]
	}

	/* (1/5)글 리스트 */
	public ArrayList<Dto> list(int startIndex,String old,String topick) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			
			String sql = String.format("select * from %s WHERE topick LIKE '%s' ORDER BY num %s limit %d,%s;", Db.TABLE_PS_BOARD_FREE,
					topick,old,startIndex, Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 기본 : " + sql);
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
	

	/* (1/5)글 리스트 */
	public ArrayList<Dto> listAll(int startIndex,String old) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			
			String sql = String.format("select * from %s ORDER BY num %s limit %d,%s;", Db.TABLE_PS_BOARD_FREE,
					old,startIndex, Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 기본 : " + sql);
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
	
	/* (1/5)글 리스트<검색> */
	public ArrayList<Dto> list(String word,int startIndex,String old,String toipick) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			
			String sql = String.format("select * from %s WHERE topick LIKE '%s' and title like '%%%s%%' ORDER BY num %s limit %d,%s;", Db.TABLE_PS_BOARD_FREE,
					toipick,word,old,startIndex, Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 검색 : " + sql);
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
	
	/* (1/5)글 리스트<검색> */
	public ArrayList<Dto> list(String word,int startIndex,String old) {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
		try {
			
			String sql = String.format("select * from %s WHERE title like '%%%s%%' ORDER BY num %s limit %d,%s;", Db.TABLE_PS_BOARD_FREE,
					word,old,startIndex, Board.LIST_AMOUNT);
			Cw.Wn("글 리스트 검색(토픽x) : " + sql);
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
		int count = 0; // 총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s;", Db.TABLE_PS_BOARD_FREE);
			Cw.Wn("총 글 수 :"+sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
		}
		super.close(); // [고정4,5]
		return count; // 총 글 수 반환
	}

	/* 총 글 수 구하기 */
	public int getPostcount(String topick) {
		int count = 0; // 총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s where topick like '%%%s%%';", Db.TABLE_PS_BOARD_FREE,topick);
			Cw.Wn("총 글 수 :"+sql);
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

		if (count % 3 == 0) { // 나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		} else { // 나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}

	/* 총 페이지 수 구하기 */
	public int getTotalPagecount(String topick) {
		int totalPageCount = 0;
		int count = getPostcount(topick); // 전체 글 수

		if (count % 3 == 0) { // 나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		} else { // 나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}

	/* 총 글 수 구하기<검색> */
	public int getSearchPostcount(String word,String topick) {
		int count = 0; // 총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s  where title like '%%%s%%' and topick like '%s';", Db.TABLE_PS_BOARD_FREE,
					word,topick);
			Cw.Wn("총글 수(검색) :"+sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
		}
		super.close(); // [고정4,5]
		return count; // 총 글 수 반환
	}
	/* 총 글 수 구하기<검색> */
	public int getSearchPostcount(String word) {
		int count = 0; // 총 글 수
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		try {
			String sql = String.format("select count(*) from %s  where title like '%%%s%%';", Db.TABLE_PS_BOARD_FREE,
					word);
			Cw.Wn("총글 수(검색/토픽X) :"+sql);
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
	public int getSearchTotalPagecount(String word,String topick) {
		int totalPageCount = 0;
		int count = getSearchPostcount(word,topick); // 전체 글 수

		if (count % 5 == 0) { // 나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		} else { // 나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}
	
	/* 총 페이지 수 구하기<검색> */
	public int getSearchTotalPagecount(String word) {
		int totalPageCount = 0;
		int count = getSearchPostcount(word); // 전체 글 수

		if (count % 5 == 0) { // 나머지 없는 경우
			totalPageCount = count / Board.LIST_AMOUNT;
		} else { // 나머지가 있어서 짜투리 페이지가 있는 경우
			totalPageCount = count / Board.LIST_AMOUNT + 1;
		}
		return totalPageCount;
	}


}


///* (1/5)글 리스트<검색> */
//public ArrayList<Dto> searchlist(String page, String word) {
//	super.Number_check();
//	super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
//	ArrayList<Dto> posts = new ArrayList<Dto>(); // 컬렉션 워크프레임 생성
//	try {
//		/* 현재 페이지 구하기 */
//		int startIndex = ((Integer.parseInt(page)) - 1) * Board.LIST_AMOUNT; // arrayList 0부터 시작임
//
////		String sql = String.format("select * from %s  where title like '%%%s%%' limit %s,%d ORDER BY num desc; ", Db.TABLE_PS_BOARD_FREE,word,startIndex,Board.LIST_AMOUNT);
//		String sql = String.format("SELECT * FROM %s WHERE title LIKE '%%%s%%' ORDER BY num DESC LIMIT %d, %d;",
//				Db.TABLE_PS_BOARD_FREE, word, startIndex, Board.LIST_AMOUNT);
//
//		Cw.Wn(sql);
//		ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.
//		while (rs.next()) { // 테이블 안에 있는 데이터 전부 탐색
//			posts.add(new Dto( // 테이블 안에 있는 함수를 가져와 배열에 저장
//					rs.getString("num"), rs.getString("title"), rs.getString("id"), rs.getString("content"),
//					rs.getString("datatime"), rs.getString("topick")));
//		}
//
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	super.close(); // [고정4,5]
//	return posts;
//}

