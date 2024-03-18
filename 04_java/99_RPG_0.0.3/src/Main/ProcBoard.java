package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BackEnd.Character;
import BackEnd.Inventory;
import BackEnd.ItemObject;
import Maps.Data;

public class ProcBoard {
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	public static int no = 0;

	public void runbag() {
		ProcBoard.dbInit();
		ItemObject.bag();
	}

	public void runshop() {
		ProcBoard.dbInit();
		ItemObject.shop();
	}

	public void saveMAIN_C() {
		ProcBoard.dbInit();
		Character.MAIN_C();
		Character.MAIN_C_give_item();
		Inventory.Inventory_load();
		Character.MAIN_C_find_item_in();
	}

	public void loadMAIN_C() {
		ProcBoard.dbInit();
		Character.saveDATA();
		Character.saveDATAchoice();
	}

	public void loadMAIN_C_DEL() {
		ProcBoard.dbInit();
		Character.saveDATA();
		Character.saveDATAdel();
	}

	static public void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPG", "root", "root");
			st = con.createStatement(); // Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열
										// 수있다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static public void dbExecuteUpdate(String query) {
		try {
			int resultCount = st.executeUpdate(query);
			if (resultCount >= 1) {
//			System.out.println("처리된 행 수:"+resultCount);
			} else {
				System.out.println("처리 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static public void dbExecuteUpdate2(String query, int sumCI) {
		try {
			int resultCount = st.executeUpdate(query);
			if (resultCount >= 1) {
//			System.out.println("처리된 행 수:"+resultCount);
				String updateCharinfo = String
						.format("update charinfo set C_MONEY = '%d' where C_NAME ='" + Data.Main_C_NAME + "';", sumCI);
				st.executeUpdate(updateCharinfo);
			} else {
				System.out.println("처리 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 호출시 돈을 바꿔줌 ^^
	static public void dbExecuteUpdate3(String query, int sumCI) {
		try {
			int resultCount = st.executeUpdate(query);
			if (resultCount >= 1) {
				// 이전 코드 생략...
				String updateCharinfo = String
						.format("update charinfo set C_MONEY = '%d' where C_NAME ='" + Data.Main_C_NAME + "';", sumCI);
				st.executeUpdate(updateCharinfo);
			} else {
				System.out.println("처리 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
