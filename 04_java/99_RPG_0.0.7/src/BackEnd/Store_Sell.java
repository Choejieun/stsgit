package BackEnd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;
import Selective.ItemOP;
import uitn.InputS;
import uitn.Material;

public class Store_Sell {
	static public void handleSellOption() {
		Material.line2();
		System.out.print("[  인벤토리  ]");
		Material.line();
		System.out.println("내 자산 : " + ItemObject.C_money + " G");
		Material.line();
		Inventory.Inventory_load();
		Character.MAIN_C_find_item_in();
		Inventory.InventoryForpay();
		Material.line();
		System.out.println("판매하기");
		System.out.println("*원하지 않을 시 0번을 입력하세요");
		String delno = InputS.r("판매할 아이템 번호");
		String SQL_item = "select * from Inventory where IM_NO =" + delno;

		String name = null;
		String I_MY = null;
		int IM_INT = 0;
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);
			while (ProcBoard.result.next()) {
				// 캐삭빵권 전용 옵션
				String cantdel = ProcBoard.result.getString("IM_NAME");
				if (cantdel.equals("캐삭빵 면제권")) {
					String updateCharinfo2 = String
							.format("update charinfo set CANTDEL = 0 where C_NAME = '" + Data.Main_C_NAME + "';");
					ProcBoard.st.executeUpdate(updateCharinfo2); // 수정된 부분
				}
				////////////////////////////////////////////////////////////////

				name = ProcBoard.result.getString("IM_NAME");
				I_MY = ProcBoard.result.getString("IM_MY");
				IM_INT = ProcBoard.result.getInt("IM_INT");
				int price = ProcBoard.result.getInt("IM_MONEY");

				if (Data.x == 0 && Data.y == 20) {
					price = (int) (price - (price * -8.8));
					ItemObject.itempay = price;
				} else {
					price = (int) (price - (price * 0.8));
					ItemObject.itempay = price;
				}

				System.out.println(ItemObject.itempay);
				ItemObject.sumCI = ItemObject.C_money + ItemObject.itempay;
				Material.line();
				System.out.println("기존 자산 : " + ItemObject.C_money + " G");
				System.out.println("획득한 자산 : " + ItemObject.itempay + " G");
				Material.line();
				System.out.println("현재 내 자산 : " + ItemObject.sumCI + " G");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String SQL_item6 = "select * from item where I_NAME ='" + name + "';";
		try (Statement newS = ProcBoard.con.createStatement()) {
			int I_INT = 0;
			ResultSet newR = newS.executeQuery(SQL_item6);
			if (newR.next()) {
				I_INT = newR.getInt("I_INT");
				System.out.println(I_INT);
			}
			if (I_INT == 1) {
				// 아이템 삭제 처리
				String delnox2 = String.format("delete from item where" + "  I_NAME = '%s' and I_MY = '%s';", name,
						Data.Main_C_NAME);
//			String delnox2 = String.format("delete from item where I_FIELD = '"+ Data.Main_C_NAME+"'"
//					+ " and  I_NAME = '%s' and I_MY = '%s';", name, Data.Main_C_NAME);
				System.out.println(delnox2);
				try {
					ProcBoard.st.executeUpdate(delnox2);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				String updateCharinfo = String
						.format("update charinfo set C_MONEY = '%d' where C_NAME ='" + Data.Main_C_NAME + "';", ItemObject.sumCI);
				System.out.println(updateCharinfo);
				try {
					ProcBoard.st.executeUpdate(updateCharinfo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				// 아이템 갯수 삭제
				String delnox3 = String.format("update item set I_INT = I_INT-1 WHERE " + "I_NAME = '" + name
						+ "' and I_MY = '" + Data.Main_C_NAME + "';");
				System.out.println(delnox3);
				ProcBoard.dbExecuteUpdate2(delnox3, ItemObject.sumCI);

			}
		} catch (Exception e) {
		}

		System.out.println("판매 종료");
		ItemOP.shop();
	}

	

}
