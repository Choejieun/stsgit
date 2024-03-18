package BackEnd;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.ProcBoard;
import Maps.Data;
import uitn.Cw;

public class Inventory {

	static public void Inventory_load() {
		try {
			String delInventory = String.format("drop table Inventory;");
			ProcBoard.st.executeUpdate(delInventory);
			String CInventory = String
					.format("create table Inventory ("
							+ "    IM_NAME char(50),"
							+ "    IM_TEXT text,"
							+ "    IM_INT int,"
							+ "    IM_NO int primary key auto_increment,"
							+ "    IM_MONEY int,"
							+ "    IM_MY char(50)"
							+ ");");
//					System.out.println(CInventory);
			ProcBoard.st.executeUpdate(CInventory); // 얘는 사용자 전용 가방 생성
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
						String price = ProcBoard.result.getString("IM_MONEY");
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
				int price = ProcBoard.result.getInt("IM_MONEY");
				if (Data.x == 0 && Data.y == 20) {
					price = (int) (price - (price * -8.8));
					ItemObject.itempay = price;
				} else {
					price = (int) (price - (price * 0.8));
					ItemObject.itempay = price;
				}
				System.out.println("[" + no + "] 아이템명: " + title + "/ 가격 : " + price + " G");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
