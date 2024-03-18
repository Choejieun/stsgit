package BackEnd;

import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;

public class Store_item {
	static public void public_item_load() {
		try {
			String delInventory = String.format("drop table stand;");
			ProcBoard.st.executeUpdate(delInventory);
			String CInventory = String.format("create table stand(" + "I_NAME char(50)," + "I_TEXT text," + "I_INT int,"
					+ "I_NO int primary key auto_increment," + "I_MONEY int," + "I_MY char(50)" + ");");
			ProcBoard.st.executeUpdate(CInventory); // 얘는 매대 생성
//			Cw.Wn("정상");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 상점템 가져오기
	// 2024.01.15 정상작동 확인
	static public void public_item() {
		int a = 1;
		String imyn = null;
		
		if (Data.x == 0 && Data.y == 8) {
			imyn = "SELECT * FROM item WHERE I_MY = '0';";
		}	else 	if (Data.x == 0 && Data.y == 20) {
			imyn = "SELECT * FROM item WHERE I_MY = '1';";
		}	else 	if (Data.x == 220 && Data.y == 4) {
			imyn = "SELECT * FROM item WHERE I_MY = '2';";
		}
		
		try (Statement newStatement = ProcBoard.con.createStatement()) {
			ProcBoard.result = newStatement.executeQuery(imyn);
			// 결과 출력
			while (ProcBoard.result.next()) {
				ProcBoard.no = ProcBoard.result.getInt("I_NO");
				String title = ProcBoard.result.getString("I_NAME");
				String text = ProcBoard.result.getString("I_TEXT");
				int price = ProcBoard.result.getInt("I_MONEY");
				int eaint = ProcBoard.result.getInt("I_INT");

				String saveItemQuery = String.format("INSERT INTO stand (I_NAME, I_TEXT, I_INT, I_MONEY, I_MY) VALUES ("
						+ "'" + title + "', '" + text + "', " + eaint + ", " + price + ", '" + '0' + "');");
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

}
