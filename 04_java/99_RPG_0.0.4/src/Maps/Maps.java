package Maps;

import uitn.Cw;

public class Maps {
	public static boolean move;
	public static String xy;
	
	static public void Mscanner() {
		System.out.print("[현재 위치] X: " + Data.x);
		System.out.println(" Y :" + Data.y);
	}
	static public void Mgostraight() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
	
	
	//[ ┤]교차로 묶음
	
	static public void MGO_IV1() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│                   ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
	static public void MGO_IV2() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│                   ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
	static public void M_xl() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│               ●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
											//교차로 길 빠짐---------------------------------- 
	static public void M_xl1() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼─┼    ┼─│");
		Cw.Wn("│─┼─┼─┼    ┼─│");
		Cw.Wn("│               ●        ┼─│");
		Cw.Wn("│─┼─┼─┼    ┼─│");
		Cw.Wn("│─┼─┼─┼    ┼─│");
		Cw.Wn("└─────────┘");
	}
	static public void M_xl2() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼─┼─┼    │");
		Cw.Wn("│─┼─┼─┼─┼    │");
		Cw.Wn("│               ●               │");
		Cw.Wn("│─┼─┼─┼─┼    │");
		Cw.Wn("│─┼─┼─┼─┼    │");
		Cw.Wn("└─────────┘");
	}
	static public void M_l_gostraight() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│               ●               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
											//교차로 길 빠짐----------------------------------
	
	static public void MGO_IV4() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│                   ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
	static public void MGO_IV5() {
		Cw.Wn("┌─────────┐");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│                   ┼─┼─│");
		Cw.Wn("└─────────┘");
	}
	
	//[ ┤]교차로 묶음
	
	//무한 마을 가는 길
	static public void M_l_close1() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│🛕           ●               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
	static public void M_l_close2() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│─🛕        ●               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
	static public void M_l_close3() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│─┼🛕    ●               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
	static public void M_l_close4() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│─┼─🛕●               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
	static public void M_GOODVillage() {
		Cw.Wn("┌─────────┐");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│─┼─┼🛕               │");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("└─────────┘");
	}
	//무한 마을 가는 길 [종료]
	
	
	static public void MmoveCK() {
	xy = Integer.toString(Data.x) + Integer.toString(Data.y);
	Village.movePoint = xy;
	Village.run();
if (move == false) { // 이동실패
	Cw.Wn("★ 더 이상 갈 길이 없다.");
	Data.GOGO = false;}
}	
	static public void M0_0() {
		Cw.Mtop();
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Mbot();
	}
	static public void M0_1() {
		Cw.Mtop();
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Mclosure();
		Cw.Mbot();
	}
	static public void M0_6() {
		Cw.Mtop();
		Cw.Wn("│─┼─┼🏕               │");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│                   ┼─┼─│");
		Cw.Mbot();
	}
	static public void M0_7() {

		Cw.Mtop();
		Cw.Mclosure();
		Cw.Wn("│─┼─┼🏕               │");
		Cw.Wn("│─┼─┼●┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Mbot();
	}
	static public void M_TechoVillage() {
		
		Cw.Mtop();
		Cw.Mclosure();
		Cw.Mclosure();
		Cw.Wn("│─┼─┼🏕               │");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Wn("│─┼─┼    ┼─┼─│");
		Cw.Mbot();
	}
	
	static public void M_S_01_LeaveHome() {
	move = false;
			if (Data.y == 0 && Data.x == 0) {
				Maps.M0_0();
				move = true;
				Data.GOGO = true;
			}

			if (Data.y == 1 && Data.x == 0) {
				Maps.M0_1();
				move = true;
				Data.GOGO = true;
			}

//			if (Data.y > 1 && Data.y < 6 && Data.x == 0) {
//				Maps.Mgostraight(); // 직진
//				move = true;
//				Data.GOGO = true;
//			}
			
			if (Data.y == 2 && Data.x == 0) {
				Maps.MGO_IV1();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 3 && Data.x == 0) { 
				Maps.MGO_IV2();
				move = true;
				Data.GOGO = true;
			}
			
			// ---
			if (Data.y == 4 && Data.x == 0) {//교차로지점
				Maps.M_xl();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 1) { 
				Maps.M_xl1();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 2) { 
				Maps.M_xl2();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x > 2 && Data.x < 216 ) { //무한 마을 가는 길
				Maps.M_l_gostraight();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 216 ) { 
				Maps.M_l_close1();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 217 ) { 
				Maps.M_l_close2();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 218 ) { 
				Maps.M_l_close3();
				move = true;
				Data.GOGO = true;
			}
			if (Data.y == 4 && Data.x == 219 ) { 
				Maps.M_l_close4();
				move = true;
				Data.GOGO = true;
			}
//			if (Data.y == 4 && Data.x == 220 ) { //무한 마을 도착
//				Maps.M_GOODVillage();
//				move = true;
//				Data.GOGO = true;
//			}
			
			
			// ---
			
			if (Data.y == 5 && Data.x == 0) {
				Maps.MGO_IV4();
				move = true;
				Data.GOGO = true;
			}
// -----------------------------------------------------------
			if (Data.y >= 6 && Data.y < 7 && Data.x == 0) {
				Maps.M0_6();
				move = true;
				Data.GOGO = true;
			}

			if (Data.y >= 7&& Data.y < 8 && Data.x == 0) {//태초마을 가는 길
				Maps.M0_7();
				move = true;
				Data.GOGO = true;
			}

	}
	
	static public void run() {
		Maps.M_S_01_LeaveHome();
		Maps.MmoveCK();	
//		xy = Integer.toString(Data.x) + Integer.toString(Data.y);
//		System.out.println(xy);
	}
}
