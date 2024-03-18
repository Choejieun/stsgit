package BackEnd;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;
import Maps.MapOPj;
import Maps.Maps;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class ItemObject {
	public static int C_money = 0;
	static int sumCI = 0;
	static int sumCI2 = 0;
	public static int itempay;

	// 자산확인
	static public void moneyshow() {
		///////////////////// 자산확인
		Material.line();
		String SQL_C = "select * from charinfo where C_NAME = '" + Data.Main_C_NAME + "';";
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_C);
			if (ProcBoard.result.next()) { // 데이터가 있는지 확인
				C_money = ProcBoard.result.getInt("C_MONEY");
				System.out.println("내 자산 : " + C_money + " G");
				Material.line();
			} else {
				System.out.println("데이터가 없습니다.");
			}
			ProcBoard.result.close(); // 이전 ResultSet 닫기

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		///////////////////// 자산확인
	}

	// 가방 열기
	// 얘 정상 작동함
	static public void bag() {
		Material.line2();
		System.out.print("[  인벤토리  ]");
		Material.line();
		int C_money = 0;
		System.out.println("용사, " + Data.Main_C_NAME);
		Material.line();
		String SQL_C = "select * from charinfo where C_NAME = '" + Data.Main_C_NAME + "';";
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_C);
			if (ProcBoard.result.next()) { // 데이터가 있는지 확인
				C_money = ProcBoard.result.getInt("C_MONEY");
				System.out.println("내 자산 " + C_money + " G");
			} else {
				System.out.println("데이터가 없습니다.");
			}
			ProcBoard.result.close(); // 이전 ResultSet 닫기

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
		///////////////////// 자산확인
		// 아이템 확인 세트
		Inventory.Inventory_load();
		Character.MAIN_C_find_item_in();
		Inventory.Inventory(); // 아이템확인
		Material.line();
		Cw.Wn("[1] 자세히 보기 |  [2] 버리기  | [SP] 뒤로가기");
		try {
			loop: while (true) {
				int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 65 && input <= 90;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					Cw.Wn("TIP 이동을 원할 시 뒤로가기를 누르세요");
				}
				if (input == 49) {
					String cmd = InputS.r("상세하게 볼 아이템 번호");
					String SQL_item2 = "select * from Inventory where IM_NO =" + cmd;
					try {
						ProcBoard.result = ProcBoard.st.executeQuery(SQL_item2);
						Material.line();
						if (!ProcBoard.result.next()) {
							System.out.println("해당 아이템이 없습니다.");
							Cw.Wn("[1] 자세히 보기 |  [2] 버리기  | [SP] 뒤로가기");
						} else {
							String title = ProcBoard.result.getString("IM_NAME"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
							String intno = ProcBoard.result.getString("IM_INT"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
							String content = ProcBoard.result.getString("IM_TEXT"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
							String price = ProcBoard.result.getString("IM_MONEY"); // p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
							System.out.print("아이템명: " + title);
							System.out.println(" X " + intno);
							System.out.println("설명: " + content);
							System.out.println(price + " G");
							Material.line();
							Cw.Wn("[1] 자세히 보기 |  [2] 버리기  | [SP] 뒤로가기");
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

				} // "1"
				else if (input == 50) {
					System.out.println("아이템 버리기");
					System.out.println("삭제할 번호를 입력하세요");
					String delno = InputS.r("삭제할 아이템 번호");
					String load = String.format("select * from inventory where IM_NO =" + delno + ";");
					String delname = null;
					String delmy = null;
					try (Statement newStatement = ProcBoard.con.createStatement()) {
						ProcBoard.result = newStatement.executeQuery(load);
						while (ProcBoard.result.next()) {
							// 캐삭빵권 전용 옵션
							String cantdel = ProcBoard.result.getString("IM_NAME");
							if (cantdel.equals("캐삭빵 면제권")) {
								String updateCharinfo2 = String.format(
										"update charinfo set CANTDEL = 0 where C_NAME = '" + Data.Main_C_NAME + "';");
								ProcBoard.st.executeUpdate(updateCharinfo2); // 수정된 부분
							}
							////////////////////////////////////////////////////////////////
							delname = ProcBoard.result.getString("IM_NAME");
							delmy = ProcBoard.result.getString("IM_MY");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					String delname_1 = String.format("delete from item where I_NAME = '%s' and I_MY = '%s';", delname,
							delmy);
					String delnox = String.format("delete from Inventory where IM_NO = '%s';", delno);
					ProcBoard.dbExecuteUpdate(delname_1);
					ProcBoard.dbExecuteUpdate(delnox);
					System.out.println("삭제 종료");
					return;
				} // "2"
				if (input == 32) {
					Maps.run();
					Maps.Mscanner();
					MapOPj.run();
					break loop;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
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
	
}
