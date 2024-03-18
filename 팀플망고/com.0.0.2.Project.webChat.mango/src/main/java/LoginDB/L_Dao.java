package LoginDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class L_Dao extends L_Db {

// 로그인 
	private static L_Dto send = null;
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static void start() {
		try {
			Class.forName(DB_LINK);
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void close() {
		try {
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean login(L_Dto idCk) {
		boolean ck = false;
		send = idCk;
		String sql = String.format("SELECT COUNT(*) FROM %s WHERE id = '%s' AND pw = '%s'", DB_TABLE, send.id, send.pw);
		try {
			start();
			rs = st.executeQuery(sql);
			rs.next();
			String count = rs.getString("COUNT(*)");
			if (count.equals("1")) {
				ck = true;
			} else {
				send = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	public static boolean joinIdCk(String id) { // 아이디 중복
		boolean ck = false;
		String sql = String.format("SELECT COUNT(*) FROM %s WHERE id = '%s'", DB_TABLE, id);
		try {
			start();
			rs = st.executeQuery(sql);
			rs.next();
			String idCk = rs.getString("COUNT(*)");
			if (idCk.equals("0")) {
				ck = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return ck;
	}

	public static void join(L_Dto a) {
		int userTag = userTag(a.userName);
		String sql = String.format("INSERT INTO %s (id,pw,userName,userTag) values ('%s','%s','%s',%d)", DB_TABLE, a.id,
				a.pw, a.userName, userTag);
		start();
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}

	private static int userTag(String name) {
		int num = 0;
		String sql = String.format("SELECT MAX(userTag) FROM %s WHERE userName = '%s' ", DB_TABLE, name);
		try {
			start();
			rs = st.executeQuery(sql);
			rs.next();
			num = rs.getInt("MAX(userTag)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return num + 1;
	}

}
