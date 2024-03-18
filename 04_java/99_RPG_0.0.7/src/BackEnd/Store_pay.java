package BackEnd;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;
import Selective.ItemOP;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Store_pay {

	
	static public void purchaseItem() {
		Store_item.public_item_load();
		Store_item.public_item();
		Material.line();
		Cw.Wn("[1] 자세히 보기 |  [2] 구매하기  | [SP] 뒤로가기");
		try {
			loop2: while (true) {
				int input1 = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread1 = input1 >= 97 && input1 <= 122;
				boolean Sysread21 = input1 >= 65 && input1 <= 90;
				if (Sysread1 == true || Sysread21 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					Cw.Wn("TIP 이동을 원할 시 뒤로가기를 누르세요");
				}
				if (input1 == 49) { // 1 자세히보기
					showItemDetails();
				} // "1"
				else if (input1 == 50) {// 2 구매하기
					PurchaseConfirmation();
				} // "2"
				if (input1 == 32) {
					System.out.println("구매 종료1");
					ItemOP.shop();
					break loop2;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 240112 정상작동확인
		static public void showItemDetails() {
			String cmd = InputS.r("상세하게 볼 아이템 번호");
			String SQL_item2 = "select * from stand where I_NO =" + cmd;
			try {
				ProcBoard.result = ProcBoard.st.executeQuery(SQL_item2);
				Material.line();

				if (!ProcBoard.result.next()) {
					System.out.println("해당 아이템이 없습니다.");
				} else {
					String title = ProcBoard.result.getString("I_NAME");
					String intno = ProcBoard.result.getString("I_INT");
					String content = ProcBoard.result.getString("I_TEXT");
					String price = ProcBoard.result.getString("I_MONEY");
					System.out.print("아이템명: " + title);
					System.out.println(" X " + intno);
					System.out.println("설명: " + content);
					System.out.println(price + " G");
					Material.line();
					Cw.Wn("[1] 자세히 보기 |  [2] 구매하기  | [SP] 뒤로가기");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				// 결과 집합을 닫아준다.
				if (ProcBoard.result != null) {
					try {
						ProcBoard.result.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	
		
		// 240112 정상작동확인
		static public void PurchaseConfirmation() { // 구매확정
			ResultSet newResult2 = null;
			Material.line();
			System.out.println("내 자산 : " + ItemObject.C_money + " G");
			System.out.println("*원하지 않을 시 0번을 입력하세요");
			String cmd = InputS.r("구매할 아이템 번호");

			String SQL_item2 = "SELECT * FROM stand WHERE I_NO =" + cmd;
			try (Statement NS = ProcBoard.con.createStatement()) {
				newResult2 = NS.executeQuery(SQL_item2);

				while (newResult2.next()) {
					// 캐삭빵권 전용 옵션
					String cantdel = newResult2.getString("I_NAME");
					if (cantdel.equals("캐삭빵 면제권")) {
						String updateCharinfo2 = String
								.format("update charinfo set CANTDEL = 1 where C_NAME = '" + Data.Main_C_NAME + "';");
						ProcBoard.st.executeUpdate(updateCharinfo2); // 수정된 부분
					}
					////////////////////////////////////////////////////////////////

					int I_M = newResult2.getInt("I_MONEY");
					ItemObject.sumCI = ItemObject.C_money - I_M;
					Material.line();
					System.out.println("기존 자산 : " + ItemObject.C_money + " G");
					System.out.println("소비한 자산 : " + I_M + " G");
					Material.line();
					System.out.println("현재 내 자산 : " + ItemObject.sumCI + " G");

					String updateCharinfo = String.format("UPDATE charinfo SET C_MONEY = '%d' WHERE C_NAME ='%s';", ItemObject.sumCI,
							Data.Main_C_NAME);
//	                System.out.println(updateCharinfo);
					ProcBoard.st.executeUpdate(updateCharinfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 명시적으로 ResultSet을 닫음
				if (newResult2 != null) {
					try {
						newResult2.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 아이템 인벤토리로 이동
			Inventory.moveItemToInventory(cmd, ItemObject.sumCI);

			System.out.println("구매 종료");
			ItemOP.shop();
		}

	
}
