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

	/* (1/5)글 리스트 */
	public ArrayList<Dto> list() {
		super.Number_check();
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]
		ArrayList<Dto> posts = new ArrayList<Dto>(); //컬렉션 워크프레임 생성
		try {
			String sql = String.format("select * from %s;", Db.TABLE_PS_BOARD_FREE);
			Cw.Wn(sql);
			ResultSet rs = st.executeQuery(sql); // select * 범위를 기준으로 한다.

			while (rs.next()) { //테이블 안에 있는 데이터 전부 탐색
//				num = rs.getInt("num");
				posts.add(new Dto(  //테이블 안에 있는 함수를 가져와 배열에 저장
						rs.getString("num"), 
						rs.getString("title"), 
						rs.getString("id"),
						rs.getString("content"), 
						rs.getString("datatime"),  
						rs.getString("topick")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close(); // [고정4,5]
		return posts;
	}
}
