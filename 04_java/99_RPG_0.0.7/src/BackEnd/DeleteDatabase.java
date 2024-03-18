package BackEnd;

import java.sql.SQLException;

import Main.ProcBoard;
import uitn.Cw;

public class DeleteDatabase {
	static public boolean nulllist() {
		String count = ""; 
		String sql = "select count(*) from charinfo;";
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(sql);
			ProcBoard.result.next();
			count = ProcBoard.result.getString("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		if(intCount > 0) {
			return true;
		}
		else {
			Cw.Wn("-----------------------------.");
			Cw.Wn("★ 먼저 기억을 만들어주세요 ★");
			Cw.Wn("-----------------------------.");
			return false;
		}

	}
	
}
