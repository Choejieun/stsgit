package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	static Connection con = null;
	static Statement st = null;
	static ResultSet result = null;
	static String count = "";
	
	static void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static public int getPostCount() {
		count = "";
		try {
			Data.result = Data.st.executeQuery("select count(*) from board where b_reply_orino is not null;");
			Data.result.next();
			count = Data.result.getString("count(*)");
//			Cw.wn("글 수  : "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int intCount = Integer.parseInt(count);
		return intCount;
	}
	
	
	
	private void dbExecuteQuery(String query) {
		try {
			Data.result = Data.st.executeQuery(query);
			while (Data.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				String name = Data.result.getString("p_name");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				System.out.println(name);
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}	

}
