package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BackEnd.Character;
import BackEnd.Inventory;
import BackEnd.ItemObject;
import Item_Public.MakingTHEWorld;
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
		try {
			MakingTHEWorld.Basic_item_payment();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	            // ★ 이미 연결이 열려있는지 확인
	            if (con == null || con.isClosed()) {
	                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RPG", "root", "root");
	                st = con.createStatement();
	            }
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
