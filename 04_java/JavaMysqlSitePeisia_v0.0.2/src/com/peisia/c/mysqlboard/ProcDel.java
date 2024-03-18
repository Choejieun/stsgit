package com.peisia.c.mysqlboard;

import java.sql.SQLException;

import com.peisia.c.member.ProcLogin;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcDel {
	static public void run() {
		dellist();
		if(!nulllist()) {
			ProcBoard.run();
		}
		String delNo = Ci.r("삭제할 글번호를 입력해주세요:");
		if(dlepossible(delNo)) {
		Db.dbExecuteUpdate("delete from board where b_no="+delNo);
		};
	}
	
	static public boolean nulllist() {
		String count = ""; 
		String sql = "select count(*) from board where b_id='"
	+ProcLogin.ProcLogin_on+"';";
		try {
			Db.result = Db.st.executeQuery(sql);
			Db.result.next();
			count = Db.result.getString("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		if(intCount > 0) {
			return true;
		}
		else {
			Cw.wn("-----------------------------.");
			Cw.wn("삭제 가능한 글이 없습니다.");
			Cw.wn("-----------------------------.");
			return false;
		}

	}
	
	
	static public boolean dlepossible(String no) {
		String count = ""; 
		String sql = "select count(*) from board where b_id='"
	+ProcLogin.ProcLogin_on+"' and b_no ="+no+";";
		try {
			Db.result = Db.st.executeQuery(sql);
			Db.result.next();
			count = Db.result.getString("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		if(intCount > 0) {
			Cw.wn("삭제 성공");
			return true;
		}
		else {
			Cw.wn("삭제실패-----------------------");
			Cw.wn("올바른 글번호를 입력해주세요");
			return false;
		}

	}
	
	static public void dellist() {
		String sql = "select * from board where b_id='"+ProcLogin.ProcLogin_on+"';";
		try {
			Db.result = Db.st.executeQuery(sql);
			while (Db.result.next()) {
				String no = Db.result.getString("b_no");
				String title = Db.result.getString("b_title");
				String id = Db.result.getString("b_id");
				String datetime = Db.result.getString("b_datetime");
				Cw.wn("["+no+"] "+title+" "+id+" "+datetime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
