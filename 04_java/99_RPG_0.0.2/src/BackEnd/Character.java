package BackEnd;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.First;
import Main.HaveData;
import Main.ProcBoard;
import Maps.Data;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Character {
	public static Statement newStatement = null;

	// 유저확인
	static public void MAIN_C() {
		Cw.Wn("*꧁༺༺ৡۣ͜͡ৡ용༒사ৡۣ͜༻༻꧂*");
		Data.Main_C_NAME = InputS.r("나의 이름은...");
		String cmdname = String.format("insert into charinfo (C_NAME,C_MONEY) value('%s',100);", Data.Main_C_NAME);
		try {
			ProcBoard.st.executeUpdate(cmdname);
			String sql2 = "select * from charinfo where C_NAME ='" + Data.Main_C_NAME + "'";
			ProcBoard.result = ProcBoard.st.executeQuery(sql2);
			ProcBoard.result.next();
			Data.Main_C_NO = ProcBoard.result.getInt("C_NO");
			Material.line();
			System.out.println("용사 : " + Data.Main_C_NAME);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// 유저 초기 아이템 지급
	static public void MAIN_C_give_item() {
		try {
			String cmdgiveitem1 = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value("
					+ "'기초의 빵1111'," + "'딱딱한 빵이다.'," + "1," + "10,'" + Data.Main_C_NAME + "');");
			String cmdgiveitem2 = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY) value("
					+ "'기초의 네일아트'," + "'큐티클 제거 세트도 포함'," + "1," + "100,'" + Data.Main_C_NAME + "');");
			ProcBoard.st.executeUpdate(cmdgiveitem1);
			ProcBoard.st.executeUpdate(cmdgiveitem2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 유저가 가진 아이템 로드
	static public void MAIN_C_find_item() {
		try {
			String delInventory = String.format("drop table Inventory;");
			ProcBoard.st.executeUpdate(delInventory);
			String CInventory = String
					.format("create table Inventory(" + "IM_NAME char(50)," + "IM_TEXT text," + "IM_INT int,"
							+ "IM_NO int primary key auto_increment," + "IM_MONEY int," + "IM_MY char(50)" + ");");
			ProcBoard.st.executeUpdate(CInventory); // 얘는 인벤토리 생성
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	// Character.MAIN_C_find_item_in() 메서드를 수정하여 새로운 Statement 객체를 사용하도록 합니다.
	// saveMAIN_C 메서드에서는 새로운 Statement 객체를 사용하므로
	// ResultSet이 닫힌 상태에서 다시 사용되는 문제가 발생하지 않을 것입니다.
	static public void MAIN_C_find_item_in() {
		String SQL_item = "select * from item where I_MY ='" + Data.Main_C_NAME + "';";
//		System.out.println(SQL_item);

		// Character.MAIN_C_find_item_in() 메서드에서는 try-with-resources를 사용하여
		// 자동으로 Statement을 닫아주도록 구현하였습니다.
		try (Statement newStatement = ProcBoard.con.createStatement()) {
			ProcBoard.result = newStatement.executeQuery(SQL_item);
			while (ProcBoard.result.next()) {
				String I_NAME = ProcBoard.result.getString("I_NAME");
				String I_TEXT = ProcBoard.result.getString("I_TEXT");
				String I_INT = ProcBoard.result.getString("I_INT");
				String I_MONEY = ProcBoard.result.getString("I_MONEY");
				String cmdgiveitem1 = String
						.format("insert into Inventory (IM_NAME, IM_TEXT, IM_INT,IM_MONEY,IM_MY) value(" + "'" + I_NAME
								+ "'," + "'" + I_TEXT + "'," + I_INT + "," + I_MONEY + ",'" + Data.Main_C_NAME + "');");
//				System.out.println(cmdgiveitem1);
				ProcBoard.st.executeUpdate(cmdgiveitem1);
			}
		} catch (SQLException e) {
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

/////////////////////세이브 데이터 확인
	static public void saveDATA() {
		String SQL_item = "SELECT * FROM charinfo;";
		try {
			// I_NO 열이 존재하는지 확인
			DatabaseMetaData metaData = ProcBoard.con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "charinfo", "C_NO");

			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE charinfo DROP COLUMN C_NO;";
				ProcBoard.st.executeUpdate(dropAutoIncrementColumnQuery);
			}

			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE charinfo ADD COLUMN C_NO INT AUTO_INCREMENT PRIMARY KEY;";
			ProcBoard.st.executeUpdate(addAutoIncrementColumnQuery);

			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);
			while (ProcBoard.result.next()) { // 현재 가진 모든 결과출력
				String no = ProcBoard.result.getString("C_NO");
				String name = ProcBoard.result.getString("C_NAME");
				String price = ProcBoard.result.getString("C_MONEY");
				System.out.print("[" + no + "]");
				System.out.println(" 데이터명: " + name + "/ 보유 자산 : " + price + " G");
				Material.line();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	static public void saveDATAchoice() { // 얘 정상작동함!!!!!!!!!!!!
		int no = 0;
		boolean delon = false;
		String SQL_item = "select * from charinfo;";
		String readNo = InputS.r("기억 번호 : ");
		try { // 중복검사
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);
			while (ProcBoard.result.next()) { // 현재 가진 모든 결과출력
				no = ProcBoard.result.getInt("C_NO");
				if (no <= 0) {
					Cw.Wn("[̲̅존][̲̅재][̲̅하][̲̅지][̲̅않][̲̅는][̲̅기][̲̅억][̲̅입][̲̅니][̲̅다][̲̅.]");
					HaveData.run();
				}
				if (Integer.parseInt(readNo) == no) {
					delon = true;
				}
			}
			if (delon == true) {
				System.out.println(no);
				String sql2 = "select * from charinfo where C_NO =" + readNo;
				try {
					ProcBoard.result = ProcBoard.st.executeQuery(sql2);
					ProcBoard.result.next();
					Data.Main_C_NAME = ProcBoard.result.getString("C_NAME");
					Data.Main_C_NO = ProcBoard.result.getInt("C_NO");
					Material.line();
					System.out.println("[" + Data.Main_C_NO + "] 용사 : " + Data.Main_C_NAME);
					First.run();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				Cw.Wn("[̲̅존][̲̅재][̲̅하][̲̅지][̲̅않][̲̅는][̲̅기][̲̅억][̲̅입][̲̅니][̲̅다][̲̅.]");
				HaveData.run();
			}
			ProcBoard.result.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	// 세이브 데이터 삭제
	static public void saveDATAdel() { // 20240112 정상작동 확인
		int no = 0;
		String delname = null;
		boolean delon = false;
		String SQL_item = "SELECT * FROM charinfo;";
		System.out.println("[ 0 ] 뒤로가기");
		String cmd1 = InputS.r("삭제할 기억 번호");
		try {
			ProcBoard.result = ProcBoard.st.executeQuery(SQL_item);
			while (ProcBoard.result.next()) { // 현재 가진 모든 결과출력
				no = ProcBoard.result.getInt("C_NO");
				if (no <= 0) {
					Cw.Wn("[̲̅존][̲̅재][̲̅하][̲̅지][̲̅않][̲̅는][̲̅기][̲̅억][̲̅입][̲̅니][̲̅다][̲̅.]");
					HaveData.run();
				} else {
					if (Integer.parseInt(cmd1) == no || "0".equals(cmd1)) {
						delon = true;

						//
						ResultSet newResult2 = null;
						String Find_C = "SELECT * FROM charinfo WHERE C_NO =" + cmd1 + ";";
						try (Statement newStatement = ProcBoard.con.createStatement()) {
							newResult2 = newStatement.executeQuery(Find_C);
							while (newResult2.next()) {
								Data.Main_C_NAME = ProcBoard.result.getString("C_NAME");

								delname = Data.Main_C_NAME;
								System.out.println(delname);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							if (newResult2 != null) {
								try {
									newResult2.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
						//
						if ("0".equals(cmd1)) {
							return;
						}
					}
				}
				if (delon == true) {
					Cw.Wn("");
					Cw.Wn("안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞˗ˋˏ정ˎˊ˗˗ˋˏ말ˎˊ˗˗ˋˏ로ˎˊ˗˗ˋˏ삭ˎˊ˗˗ˋˏ제ˎˊ˗˗ˋˏ할ˎˊ˗˗ˋˏ거ˎˊ˗˗ˋˏ야ˎˊ˗˗ˋˏ?ˎˊ˗안̵̺͔͈̣͙̦̭̱̓͛̈̈́͘͢͜녕̶̢͙̻͉̻̣̃̏̋̈͋͘하̵̢̢̣͙̖͔͇̝͇̤͑̉͛͗͋́͘세̸͔̖̯͕̞͍̍̏͆̌̓͐͡͞요͕̭̻͔͙̠̹̫̌̀͌̊͘͝안̵̺͔͈̣͙̦̭̱̓͛̈̈́͘͢͜녕̶̢͙̻͉̻̣̃̏̋̈͋͘하̵̢̢̣͙̖͔͇̝͇̤͑̉͛͗͋́͘세̸͔̖̯͕̞͍̍̏͆̌̓͐͡͞요͕̭̻͔͙̠̹̫̌̀͌̊͘͝안̵̺͔͈̣͙̦̭̱̓͛̈̈́͘͢͜녕̶̢͙̻͉̻̣̃̏̋̈͋͘하̵̢̢̣͙̖͔͇̝͇̤͑̉͛͗͋́͘세̸͔̖̯͕̞͍̍̏͆̌̓͐͡͞요͕̭̻͔͙̠̹̫̌̀͌̊͘͝안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞");
					Cw.Wn("");
					Cw.Wn("안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞안̭̩̜͎̙̭͎͌̔͑͋͆͝͠ͅ녕̷͉͕͎̪̦̓̆̔̏̿͋̂͘͢͝͞하̡̣̰͉͕̘̠͐̎̌̂͐͜͟͡세̵̨̛͎̫͇͓̳̙̈̐͆͛̏̀͢͝͡͡요̶̛̛̳͙̗̞̺̦̆͒͗͛̊͡͞ㅅㅅ삭제흘ㅇㄻㄴㄹ삭ㅈ삭제를삭ㅇㅁㄴㄻㅈ로ㅑㄻ쟈루ㅜㄹ삭제를 희망 할 경우 [ 예 ] 글자를 쳐주세요. ");
					String cmd = InputS.r("정말 삭제 하시겠습니까?");
					Cw.Wn("");
					switch (cmd) {
					case "예":
						String delnox = String.format("delete from charinfo where C_NO = '%s';", cmd1);
						String delnox2 = String.format("delete from Inventory where IM_MY = '%s';", delname);
						String delnox3 = String.format("delete from item where I_MY = '%s';", delname);
						ProcBoard.st.executeUpdate(delnox);
						ProcBoard.st.executeUpdate(delnox2);
						ProcBoard.st.executeUpdate(delnox3);
						System.out.println("삭제 종료");
						return;
					default:
						Cw.Wn("강조되고 반복되는 소리는🎙강아지를🐶 불안하게 해요‼️〰️ 🤷‍♀️네? 다시요. 🙅‍♂️ 강조되고 반복되는 소리는 강아지를 불~안하게 한다구욧🙅‍♂️ 🤷‍♀️그럼 잘했다고 하지 말라구여? 💁‍♂️네에!! 아니요!!! (짝짝짝) 이렇게는 좋은게 아니에요⤴️~!!! 🤷‍♀️ 오...진짜?? 🤷‍♂️네에~!!!! 🐶 왈왈왈 🤷‍♀️ 허허허 이런소리 싫어해요 🤷‍♂️네에~!!!! 맞아요!! 그런소리를 하고있어요! 🐶ㅡㅡ왈왈왈 🤷‍♂️어어~~~그래그래 미키미키 💁‍♂️ 일로와 🙋‍♂️ 어이! 🙋‍♂️어잇 🙋‍♂️ 어잇 (짝짝) 🙋‍♂️ 어잇!!!! (짝짝) 🙋‍♂️ 어잇 🤸‍♀️ 미키 🤸");
						return;
					}
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
