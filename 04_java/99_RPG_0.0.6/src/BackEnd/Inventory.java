package BackEnd;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;
import uitn.Cw;

public class Inventory {

	static public void Inventory_load() {
		try {
			String delInventory = String.format("drop table Inventory;");
			ProcBoard.st.executeUpdate(delInventory);
			String CInventory = String.format("create table Inventory (" + "    IM_NAME char(50)," + "    IM_TEXT text,"
					+ "    IM_INT int," + "    IM_NO int primary key auto_increment," + "    IM_MONEY int,"
					+ "    IM_MY char(50)" + ");");
//					System.out.println(CInventory);
			ProcBoard.st.executeUpdate(CInventory); // 얘는 사  용자 전용 가방 생성
//			Cw.Wn("정상");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 가방확인
	public static void Inventory() {
		// 아이템 확인을 위한 SQL 쿼리
		String SQL_item = "SELECT * FROM Inventory WHERE IM_MY ='" + Data.Main_C_NAME + "';";

		try {
			// I_NO 열이 존재하는지 확인
			DatabaseMetaData metaData = ProcBoard.con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "Inventory", "IM_NO");

			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE Inventory DROP COLUMN IM_NO;";
				ProcBoard.st.executeUpdate(dropAutoIncrementColumnQuery);
			}

			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE Inventory ADD COLUMN IM_NO INT AUTO_INCREMENT PRIMARY KEY;";
			ProcBoard.st.executeUpdate(addAutoIncrementColumnQuery);

			// 아이템 확인을 위한 SQL 쿼리 실행
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);

			// 결과 출력
			while (ProcBoard.result.next()) {
				String no = ProcBoard.result.getString("IM_NO");
				String title = ProcBoard.result.getString("IM_NAME");
				int eaint = ProcBoard.result.getInt("IM_INT");
				String price = ProcBoard.result.getString("IM_MONEY");
				System.out.println("[ " + no + " ] 아이템명: " + title + " x " + eaint + " / 가격 : " + price + " G");
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
			DatabaseMetaData metaData = ProcBoard.con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "Inventory", "IM_NO");

			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE Inventory DROP COLUMN IM_NO;";
				ProcBoard.st.executeUpdate(dropAutoIncrementColumnQuery);
			}

			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE Inventory ADD COLUMN IM_NO INT AUTO_INCREMENT PRIMARY KEY;";
			ProcBoard.st.executeUpdate(addAutoIncrementColumnQuery);

			// 아이템 확인을 위한 SQL 쿼리 실행
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);

			if (Data.x == 0 && Data.y == 20) {
				Cw.Wn("[ ...! 이 마을 사람들은 바보라서 값을 더 받을 수 있을 것 같다. ]");
			} else {
				Cw.Wn("[★80% 감소된 값으로 판매됩니다.]");
			}
			// 결과 출력
			while (ProcBoard.result.next()) {
				String no = ProcBoard.result.getString("IM_NO");
				String title = ProcBoard.result.getString("IM_NAME");
				int eaint = ProcBoard.result.getInt("IM_INT");
				int price = ProcBoard.result.getInt("IM_MONEY");
				if (Data.x == 0 && Data.y == 20) {
					price = (int) (price - (price * -8.8));
					ItemObject.itempay = price;
				} else {
					price = (int) (price - (price * 0.8));
					ItemObject.itempay = price;
				}
				System.out.println("[ " + no + " ] 아이템명: " + title + " x " + eaint + " / 가격 : " + price + " G");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

//	240112 정상작동확인
//	 가방에 아이템을 넣고 구매한 아이템에 따른 자산 반영
	static void moveItemToInventory(String cmd, int sumCI) {
		ResultSet newResult = null;
		String imname = null;
		String imtext = null;
		int imint = 0;
		int immoney = 0;
		String SQL_item3 = "SELECT * FROM stand WHERE I_NO =" + cmd;

		try (Statement newStatement = ProcBoard.con.createStatement()) {
			newResult = newStatement.executeQuery(SQL_item3);
			String INV_NAME = "미상";

			while (newResult.next()) {
				imname = newResult.getString("I_NAME");
				imtext = newResult.getString("I_TEXT");
				imint = newResult.getInt("I_INT");
				immoney = newResult.getInt("I_MONEY");
			}

			String SQL_item4 = "SELECT * FROM Inventory  WHERE IM_NAME = '"+imname+"' ;";
			try (Statement newStatement2 = ProcBoard.con.createStatement()) {
				ResultSet newResult2 = newStatement2.executeQuery(SQL_item4);
				while (newResult2.next()) {
					INV_NAME = newResult2.getString("IM_NAME");
				}
			// 아이템 퍼블릭 갱신
			// 아이템 인벤에 넣기  + 중복 이름이 있을 경우 갯수만 상
			if(imname.equals(INV_NAME)) {
				String delnox3 = String.format(
						"update item set I_INT = I_INT+1 where I_NAME = '"+INV_NAME+"'; ");
				System.out.println(INV_NAME);
				newStatement.executeUpdate(delnox3);	
			}
			// 아이템 인벤에 생성하기
			else {
				Cw.Wn("아이템생성");
				String CantDEL_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
						/* 제목 */ + "'" + imname + "', "
						/* 설명 */ + "'" + imtext + "',	"
						/* 갯수 */ + "1,			"
						/* 비용 */ + "" + immoney + ",			"
						/* 매장 */ + "'" + Data.Main_C_NAME + "',		" // 인벤에 들어감 처리
						/* 주인 */ + "'" + Data.Main_C_NAME + "'		" + ");");
				ProcBoard.st.executeUpdate(CantDEL_item_p);
			}
			
			if (imint < 1) {
				// 아이템 비공개 처리
				String delnox2 = String.format("update item set I_INT = null WHERE I_FIELD = '" + Data.Main_C_NAME
						+ "' and I_NAME = '" + imname + "' and I_INT <= " + 1 + ";");
				newStatement.executeUpdate(delnox2);
			}
           else {
               // 아이템  갯수 삭제
           	  String delnox2 = String.format("update item set I_INT = I_INT-1 WHERE  I_MY != '"+Data.Main_C_NAME+"' and I_FIELD = '"+Data.Main_C_NAME+"' and I_NAME = '"+imname+"';");
             System.out.println(delnox2);
           	  newStatement.executeUpdate(delnox2);
			}
				
			} catch (Exception e) {
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (newResult != null) {
				try {
					newResult.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
