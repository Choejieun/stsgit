package BackEnd;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.ProcBoard;
import Maps.Data;
import Maps.MapOPj;
import Maps.Maps;
import Maps.Village;
import Selective.ItemOP;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class ItemObject {
	public static int C_money = 0;
	static int sumCI = 0;
	static int sumCI2 = 0;

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
		}
		///////////////////// 자산확인
		ProcBoard.Inventory(); // 아이템확인
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
					String delnox = String.format("delete from Inventory where IM_NO = '%s';", delno);
					ProcBoard.dbExecuteUpdate(delnox);
					System.out.println("삭제 종료");
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
		}
	}

	static public void shop() {
		moneyshow();
		Cw.Wn("[1] 구매  |  [2] 판매  | [SP] 뒤로가기");
		loop: while (true) {
			int input;
			try {
				input = System.in.read();
				// 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 65 && input <= 90;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					Cw.Wn("TIP 이동을 원할 시 뒤로가기를 누르세요");
				}
				if (input == 32) {
					Maps.move = true;
					Village.run();
					break loop;
				}
				if (input == 49) { // 구매하기
					purchaseItem();
				} // "1"
				else if (input == 50) { // 판매하기
					handleSellOption();
				} // "2"
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	static public void handleSellOption() {
		Material.line2();
		System.out.print("[  인벤토리  ]");
		Material.line();
		System.out.println("내 자산 : " + C_money + " G");
		Material.line();
		ProcBoard.Inventory();
		Material.line();
		System.out.println("판매하기");
		System.out.println("*원하지 않을 시 0번을 입력하세요");
		String delno = InputS.r("판매할 아이템 번호");
		String SQL_item = "select * from Inventory where IM_NO =" + delno;
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);
			while (ProcBoard.result.next()) {
				int IM_M = ProcBoard.result.getInt("IM_MONEY");
				sumCI = C_money + IM_M;
				Material.line();
				System.out.println("기존 자산 : " + C_money + " G");
				System.out.println("획득한 자산 : " + IM_M + " G");
				Material.line();
				System.out.println("현재 내 자산 : " + sumCI + " G");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String delnox2 = String.format("delete from Inventory where IM_NO = '%s';", delno);
		ProcBoard.dbExecuteUpdate2(delnox2, sumCI);
		System.out.println("판매 종료");
		ItemOP.shop();
	}

	static public void purchaseItem() {
		ProcBoard.public_item_load();
		ProcBoard.public_item();
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
	
	//240112 정상작동확인
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

	//240112 정상작동확인
	static public void PurchaseConfirmation() { // 구매확정
        ResultSet newResult2 = null;
        Material.line();
        System.out.println("내 자산 : " + C_money + " G");
        System.out.println("*원하지 않을 시 0번을 입력하세요");
        String cmd = InputS.r("구매할 아이템 번호");

        String SQL_item2 = "SELECT * FROM stand WHERE I_NO =" + cmd;
        try (Statement NS = ProcBoard.con.createStatement()) {
        	newResult2 = NS.executeQuery(SQL_item2);

            while (newResult2.next()) {
                int I_M = newResult2.getInt("I_MONEY");
                sumCI = C_money - I_M;
                Material.line();
                System.out.println("기존 자산 : " + C_money + " G");
                System.out.println("소비한 자산 : " + I_M + " G");
                Material.line();
                System.out.println("현재 내 자산 : " + sumCI + " G");

                String updateCharinfo = String.format(
                		"UPDATE charinfo SET C_MONEY = '%d' WHERE C_NAME ='%s';", sumCI, Data.Main_C_NAME);
                System.out.println(updateCharinfo);
                ProcBoard.st.executeUpdate(updateCharinfo); // 수정된 부분
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        // 아이템 인벤토리로 이동
        moveItemToInventory(cmd, sumCI);
        System.out.println("실행문 오류찾기용");
        
        System.out.println("구매 종료2");
        ItemOP.shop();
	}
        
//        finally {
//        	if (newResult2 != null) {
//        	    try {
//        	        newResult2.close();
//        	    } catch (SQLException e) {
//        	        e.printStackTrace();
//        	    }
//        	}
//                }

	
//	//인벤에 넣기
//	static public void moveItemToInventory(String cmd, int sumCI) {
//		String SQL_item = "select * from stand where I_NO ='" +cmd + "';";
//		
//		
//		try (Statement newStatement = ProcBoard.con.createStatement()) {
//			ProcBoard.result = newStatement.executeQuery(SQL_item);
//			
//			while (ProcBoard.result.next()) {
//				String imname = ProcBoard.result.getString("I_NAME");
//				String imtext = ProcBoard.result.getString("I_TEXT");
//				String imint = ProcBoard.result.getString("I_INT");
//				String immoney = ProcBoard.result.getString("I_MONEY");
//				
//				String cmdgiveitem1 = String	.format(
//						"INSERT INTO Inventory (IM_NAME, IM_TEXT, IM_INT, IM_MONEY, IM_MY) VALUES "
//						+ "('%s', '%s', %d, %d, '%s')"
//						+imname, imtext, imint, immoney, Data.Main_C_NAME+";");
////				System.out.println(cmdgiveitem1);
//				ProcBoard.st.executeUpdate(cmdgiveitem1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 명시적으로 ResultSet을 닫음
//			if (ProcBoard.result != null) {
//				try {
//					ProcBoard.result.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}}
//	
//	240112 정상작동확인
//	 가방에 아이템을 넣고 구매한 아이템에 따른 자산 반영
    private static void moveItemToInventory(String cmd, int sumCI) {
        ResultSet newResult = null;
    	  String imname = null;
    	  String imtext= null;
    	  int imint = 0;
    	  int immoney= 0;
        String SQL_item3 = "SELECT * FROM stand WHERE I_NO =" + cmd;

        try (Statement newStatement = ProcBoard.con.createStatement()) {
            newResult = newStatement.executeQuery(SQL_item3);

            while (newResult.next()) {
                imname = newResult.getString("I_NAME");
               imtext = newResult.getString("I_TEXT");
                imint = newResult.getInt("I_INT");
                immoney = newResult.getInt("I_MONEY");
            }
            String delnox3 = String.format(
            		"INSERT INTO Inventory (IM_NAME, IM_TEXT, IM_INT, IM_MONEY, IM_MY) VALUES ('%s', '%s', %d, %d, '%s');",
            		imname, imtext, imint, immoney, Data.Main_C_NAME);
            newStatement.executeUpdate(delnox3);
            System.out.println(delnox3);
            
            // 아이템 삭제
            String delnox2 = String.format("DELETE FROM item WHERE I_NAME = '"+ imname+"' and I_INT < "+1+";");
            newStatement.executeUpdate(delnox2);
            System.out.println(delnox2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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



//String SQL_item3 = "select * from item where I_NO =" + cmd;
//try(Statement newStatement = ProcBoard.con.createStatement()) { //Statement닫기
//	ProcBoard.result = ProcBoard.st.executeQuery(SQL_item3);
//	while ( ProcBoard.result.next()){
//	String imname = ProcBoard.result.getString("I_NAME");
//	String imtext = ProcBoard.result.getString("I_TEXT");
//	int imint = ProcBoard.result.getInt("I_INT");
//	int immoney = ProcBoard.result.getInt("I_MONEY");
//
//	String delnox3 = String.format(
//			"insert into Inventory (IM_NAME, IM_TEXT, IM_INT,IM_MONEY,IM_MY) value('"
//					+ imname + "','" + imtext + "'," + imint + "," + immoney + ",'" +Data.Main_C_NAME
//					+ "');");
//	ProcBoard.st.executeUpdate(delnox3);
//	}
//	sumCI2=sumCI;
//	String delnox2 = String.format("delete from item where I_NO = '%s';", cmd);
//	ProcBoard.dbExecuteUpdate3(delnox2, sumCI2);
//	System.out.println("구매 종료");
//	ItemOP.shop();
//} catch (SQLException e) {
//	e.printStackTrace();
//} finally {
//    // ResultSet 닫기
//    ProcBoard.closeResultSet();
//}


