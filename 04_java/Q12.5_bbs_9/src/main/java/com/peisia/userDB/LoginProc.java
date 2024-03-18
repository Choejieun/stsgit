package com.peisia.userDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.peisia.db.Da;
import com.peisia.db.Db;
import com.peisia.util.Cw;

public class LoginProc  extends Da {
	public static int Login_check = 0;
	public static boolean Login_OK = false;
	public static  String USER_NAME = null;
	
	public boolean IDPWcheck(String id, String pw) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]

		String sql = String.format("select count(*) from %s where id like '%s' and pw like '%s';",Db.TABLE_LOGIN_USER_DB,id,pw);
		Cw.Wn("로그인체크 : "+sql);
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				Login_check = rs.getInt("count(*)");
			}
			if(Login_check == 1) {
				System.out.println("로그인 성공");
				Login_OK = true;
			}else {
				System.out.println("로그인 실패");
				Login_OK = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		super.close(); // [고정4,5]
		return Login_OK;
	}


	public String USER_NAMEcheck(String id, String pw) {
		super.connect(); // conect()라고 해도 됨. //[고정1,2,3]

		String sql = String.format("select * from %s where id like '%s' and pw like '%s';",Db.TABLE_LOGIN_USER_DB,id,pw);
		Cw.Wn("유저 이름 체크 : "+sql);
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				USER_NAME = rs.getString("userNAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		super.close(); // [고정4,5]
		return USER_NAME;
	}
}
