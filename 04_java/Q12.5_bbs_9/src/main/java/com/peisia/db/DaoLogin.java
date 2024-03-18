package com.peisia.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.peisia.util.Cw;

public class DaoLogin extends Da  {
	
	public int Duplicated(DtoLogin dtoLogin) {
		super.connect(); // connect()라고 해도 됨. //[고정1,2,3]
		int join_ck = 1;
		ResultSet rs;
		try {
			rs = st.executeQuery("select * from PS_MEMBER;");
			while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String userNAME = rs.getString("userNAME");
			
//			System.out.println("입력한거"+dtoLogin.id);
//			System.out.println("조회할거"+id);
			if(id.equals(dtoLogin.id)) {
				join_ck = 0;
				break;
			}
			if(pw.equals(dtoLogin.pw) && join_ck == 1) {
				join_ck = 0;
				break;
			}
			if(userNAME.equals(dtoLogin.userNAME) && join_ck == 1) {
				join_ck = 0;
				break;
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		super.close(); // [고정4,5]
		return join_ck;
	}

	public void insert(DtoLogin dtoLogin) {
		super.connect(); // connect()라고 해도 됨. //[고정1,2,3]
		String query = String.format("INSERT INTO PS_MEMBER (id, pw, userNAME) "
				+ "VALUES ('%s', '%s', '%s');"
				, dtoLogin.id, dtoLogin.pw, dtoLogin.userNAME);
		Cw.Wn("계정 생성됨 " + query);
		super.update(query);

		super.close(); // [고정4,5]
	}
}
