package Selective;

import java.sql.SQLException;

import BackEnd.ItemObject;
import Main.ProcBoard;
import Maps.Data;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Motel {
	static public void run() {
		ProcBoard.dbInit();
		Material.line2();
		System.out.print("[  여관  ]");
		Material.line();
		Cw.Wn("");

		if (Data.x == 0 && Data.y == 8) {
			a();
		} else {
			Cw.Wn("");
		}
	}

	static public void a() {

		Cw.Wn("태초마을 여인숙");
		ItemObject.moneyshow();
		Cw.Wn("1박 :  100 G");
		Cw.Wn("[1]  숙박한다  |   [SP]  나간다");
		String cmd = InputS.r("명령");

		// effectively final로 선언
		final int[] repeatCount = { 0 };

		switch (cmd) {
		case "1":
			// 스레드를 생성하여 1초마다 실행되도록 함
			Thread sleepThread = new Thread(() -> {
				try {
					// 스레드가 1초마다 실행되도록 설정
					while (repeatCount[0] < 3) {
						Thread.sleep(500);
						Cw.Wn(".");
						repeatCount[0]++;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});

			// 스레드 시작
			sleepThread.start();

			// 1박 - 100 G 처리

			// 스레드 중지
			try {
				sleepThread.join(); // 스레드가 완전히 종료될 때까지 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String aa = String.format("update charinfo set C_MONEY = C_MONEY-100 WHERE C_NAME = '"+Data.Main_C_NAME+"';");
			try {
				ProcBoard.st.executeUpdate(aa);
				ItemObject.moneyshow();
				Cw.Wn("정말 잘 쉬었다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case " ":
			break;
		}

	}
}
