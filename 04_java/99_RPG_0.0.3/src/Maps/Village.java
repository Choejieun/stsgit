package Maps;

import java.io.IOException;
import java.util.HashMap;

import Selective.ItemOP;
import Selective.Motel;
import uitn.Cw;

public class Village {
	public static HashMap<String, String> hs = new HashMap<String, String>();
	static {
		hs.put("태초마을", "08"); //0
		hs.put("바보바보마을", "020"); //1
		hs.put("무한의마을", "2204"); //2
//			hs.put("이동실패","0");	
	}

	static public String getVillageName(String villageName) {
		return hs.get(villageName);
	}

	public static String movePoint = "0";

	static public void run() {
		switch (movePoint) {
		// X = 가로
		// Y = 세로
		case "08":
			Data.x = 0;
			Data.y = 8;
			Maps.move = true;
			Village.TechoVillage();
			break;
		case "020":
			Data.x = 0;
			Data.y = 20;
			Maps.move = true;
			Village.BaboVillage();
			break;
		case "2204":
			Data.x = 220;
			Data.y = 4;
			Maps.move = true;
			Village.GOODVillage();
			break;
		default:
			break;
		}
	}

	static public void TechoVillage() {
		Maps.M_TechoVillage();
		Maps.Mscanner();
		Cw.Wn(" ~~ 태초 마을 ~~");
		Data.GOGO = false;
		Data.VillageCome = false;
		/////////////////////////////////////////////////////////////////
		Cw.Wn("[1] 상점  |  [2] 여관  |  [3] 인벤토리   [SP] 마을 나가기");

		try {
			loop: while (true) {
				int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 65 && input <= 90;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					Cw.Wn("TIP 이동을 원할 시 마을을 나가야합니다.");
				}

				if (input == 49) {
					ItemOP.shop();
				} // "1"
				else if (input == 50) {
					Motel.run();
				} // "2"
				else if (input == 51) {
					ItemOP.bag();
				} // "3"
					// '스페이스바'를 입력하면 이동가능해집니다.
				if (input == 32) {
					Maps.M_TechoVillage();
					Maps.Mscanner();
					MapOPj.run();
					break loop;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public void BaboVillage() {
		Maps.M_TechoVillage();
		Maps.Mscanner();
		Cw.Wn("왕바보마을");
		Cw.Wn("남희언니바보 내마음도 몰라주고");
		Cw.Wn("지윤언니 짱!");
		Data.GOGO = false;
		Data.VillageCome = false;
/////////////////////////////////////////////////////////////////
		Cw.Wn("[1] 상점  |  [2] 여관  |  [3] 인벤토리   [SP] 마을 나가기");

		try {
			loop: while (true) {
				int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 65 && input <= 90;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					Cw.Wn("TIP 이동을 원할 시 마을을 나가야합니다.");
				}

				if (input == 49) {
					ItemOP.shop();
				} // "1"
				else if (input == 50) {
					Motel.run();
				} // "2"
				else if (input == 51) {
					ItemOP.bag();
				} // "3"
// '스페이스바'를 입력하면 이동가능해집니다.
				if (input == 32) {
					Maps.M_GOODVillage();
					Maps.Mscanner();
					MapOPj.run();
					break loop;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static public void GOODVillage() {
		Maps.M_GOODVillage();
		Maps.Mscanner();
		Cw.Wn("~~ 무한의 땅 ~~");
		Data.GOGO = false;
		Data.VillageCome = false;
/////////////////////////////////////////////////////////////////
		Cw.Wn("[1] 상점  |  [2] 여관  |  [3] 인벤토리   [SP] 마을 나가기");

		try {
			loop: while (true) {
				int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 65 && input <= 90;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("숫자만와 SP만 사용 가능합니다.");
					  Cw.Wn("TIP 이동을 원할 시 마을을 나가야합니다.");
				}

				if (input == 49) {
					ItemOP.shop();
				} // "1"
				else if (input == 50) {
					Motel.run();
				} // "2"
				else if (input == 51) {
					ItemOP.bag();
				} // "3"
// '스페이스바'를 입력하면 이동가능해집니다.
				if (input == 32) {
					Maps.M_GOODVillage();
					Maps.Mscanner();
					MapOPj.run();
					break loop;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}