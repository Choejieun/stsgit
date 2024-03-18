package Main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BackEnd.Character;
import BackEnd.ItemObject;
import Maps.Data;
import uitn.Cw;

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
		Character.MAIN_C_find_item();
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

	static public void public_item_load() {
		try {
			String delInventory = String.format("drop table stand;");
			ProcBoard.st.executeUpdate(delInventory);
			String CInventory = String.format("create table stand(" + "I_NAME char(50)," + "I_TEXT text," + "I_INT int,"
					+ "I_NO int primary key auto_increment," + "I_MONEY int," + "I_MY char(50)" + ");");
			ProcBoard.st.executeUpdate(CInventory); // 얘는 매대 생성
			Cw.Wn("정상");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 상점템 가져오기
	// 2024.01.15 정상작동 확인
	static public void public_item() {
		int a = 1;
		String imyn = "SELECT * FROM item WHERE I_MY = '0';";
		try (Statement newStatement = ProcBoard.con.createStatement()) {
			result = newStatement.executeQuery(imyn);
			// 결과 출력
			while (result.next()) {
				no = result.getInt("I_NO");
				String title = result.getString("I_NAME");
				String text = result.getString("I_TEXT");
				int price = result.getInt("I_MONEY");
				int eaint = result.getInt("I_INT");

				String saveItemQuery = String.format("INSERT INTO stand (I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ("
						+ "'" + title + "', '" + text + "', " + eaint + ", " + price + ", '" + '0' + "');");
//							title, text, eaint, price, '0');
//		            System.out.println(saveItemQuery);
				ProcBoard.st.executeUpdate(saveItemQuery);

				System.out.println("[ " + a + " ] 아이템명: " + title + " x " + eaint + " / 가격 : " + price + " G");
				a = a + 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			// 명시적으로 ResultSet을 닫음
			if (ProcBoard.result != null) {
				try {
					ProcBoard.result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ResultSet을 닫음
	public static void closeResultSet() {
		if (ProcBoard.result != null) {
			try {
				ProcBoard.result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

//	//상점템 가져오기
//	static public void public_item() {
//		
//				 String title = null;
//				 String text= null;
//				 int price = 0;
//				 int eaint = 0;
//		
//	    ResultSet columns = null;
//        int a = 1;
////        int no = 0;
//        String SQL_item = "SELECT * FROM item WHERE I_MY = '0';";
//	    try {
//	        // I_NO 열이 존재하는지 확인
//	        DatabaseMetaData metaData = con.getMetaData();
//	        columns = metaData.getColumns(null, null, "item", "I_NO");
//
//	        if (columns.next()) {
//	            // I_NO 열이 존재하면 삭제
//	            String dropAutoIncrementColumnQuery = "ALTER TABLE item DROP COLUMN I_NO;";
//	            st.executeUpdate(dropAutoIncrementColumnQuery);
//	        }
//
//	        // 새로운 열 추가
//	        String addAutoIncrementColumnQuery = "ALTER TABLE item ADD COLUMN I_NO INT AUTO_INCREMENT PRIMARY KEY;";
//	        st.executeUpdate(addAutoIncrementColumnQuery);
//
//	        // 아이템 확인을 위한 SQL 쿼리 실행
//	        result = st.executeQuery(SQL_item);
//	        // 결과 출력
//	        while (result.next()) {
////	           // 주석 처리된 부분을 다시 활성화하여 no 값을 업데이트
//	            no = result.getInt("I_NO");
//	            title = result.getString("I_NAME");
//	            text = result.getString("I_TEXT");
//	            price = result.getInt("I_MONEY");
//	            eaint = result.getInt("I_INT");
//	            
//		        String saveItemQuery = String.format(
//		        		"INSERT INTO stand (I_NO,I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ('0','%s', '%s', %d, %d, '%s');",
//		        		 title, text, eaint, price, '0');
//	            st.executeUpdate(saveItemQuery);
//	            
////	            ResultSet newResult2 = null;
////	            String Find_C = "select * from stand;";
////	            try (Statement newStatement = ProcBoard.con.createStatement()) {
////	                newResult2 = newStatement.executeQuery(Find_C);
////	                while (newResult2.next()) {
////	                    no = newResult2.getInt("I_NO");
////	                }
////	            } catch (SQLException e) {
////	                e.printStackTrace();
////	            } finally {
////	                if (newResult2 != null) {
////	                    try {
////	                        newResult2.close();
////	                    } catch (SQLException e) {
////	                        e.printStackTrace();
////	                    }
////	                }
////	            }
//	            System.out.println("[ " +a+ " ] 아이템명: " + title + "/ 가격 : " + price + " G");
//	            a = 1 + a;
//	        }
//	        
////	        String saveItemQuery = String.format(
////	        		"INSERT INTO stand (I_NO,I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ('%d','%s', '%s', %d, %d, '%s');",
////	        		no, title, text, eaint, price, '0');
//	        System.out.println(a);
//	    } catch (SQLException e1) {
//	        e1.printStackTrace();
//	 }
//	}
//	
//	public static void closeResultSet() {
//	    // 명시적으로 ResultSet을 닫음
//	    if (ProcBoard.result != null) {
//	        try {
//	            ProcBoard.result.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}

	// 가방확인
	public static void Inventory() {
		// 아이템 확인을 위한 SQL 쿼리
		String SQL_item = "SELECT * FROM Inventory WHERE IM_MY ='" + Data.Main_C_NAME + "';";

		try {
			// I_NO 열이 존재하는지 확인
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "Inventory", "IM_NO");

			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE Inventory DROP COLUMN IM_NO;";
				st.executeUpdate(dropAutoIncrementColumnQuery);
			}

			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE Inventory ADD COLUMN IM_NO INT AUTO_INCREMENT PRIMARY KEY;";
			st.executeUpdate(addAutoIncrementColumnQuery);

			// 아이템 확인을 위한 SQL 쿼리 실행
			result = st.executeQuery(SQL_item);

			// 결과 출력
			while (result.next()) {
				String no = result.getString("IM_NO");
				String title = result.getString("IM_NAME");
				String price = result.getString("IM_MONEY");
				System.out.println("[" + no + "] 아이템명: " + title + "/ 가격 : " + price + " G");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void InventoryForpay() {
		// 아이템 확인을 위한 SQL 쿼리
		String SQL_item = "SELECT * FROM Inventory WHERE IM_MY ='" + Data.Main_C_NAME + "';";

		try {
			// I_NO 열이 존재하는지 확인
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "Inventory", "IM_NO");

			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE Inventory DROP COLUMN IM_NO;";
				st.executeUpdate(dropAutoIncrementColumnQuery);
			}

			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE Inventory ADD COLUMN IM_NO INT AUTO_INCREMENT PRIMARY KEY;";
			st.executeUpdate(addAutoIncrementColumnQuery);

			// 아이템 확인을 위한 SQL 쿼리 실행
			result = st.executeQuery(SQL_item);

			if (Data.x == 0 && Data.y == 20){
				Cw.Wn("[ ...! 이 마을 사람들은 바보라서 값을 더 받을 수 있을 것 같다. ]");}
			else {
				   Cw.Wn("[★80% 감소된 값으로 판매됩니다.]");}
			// 결과 출력
			while (result.next()) {
				String no = result.getString("IM_NO");
				String title = result.getString("IM_NAME");
				int price = result.getInt("IM_MONEY");
				if (Data.x == 0 && Data.y == 20){
					price = (int) (price - (price*-8.8));
				ItemObject.itempay = price;}
				else {
				price = (int) (price - (price*0.8));
				ItemObject.itempay = price;}
				System.out.println("[" + no + "] 아이템명: " + title + "/ 가격 : " + price + " G");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
