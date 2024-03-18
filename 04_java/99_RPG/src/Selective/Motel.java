package Selective;

import BackEnd.ItemObject;
import Maps.Data;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Motel {
	static public void run() {
		Material.line2();
		System.out.print("[  여관  ]");
		Material.line();
		Cw.Wn("");

		if (Data.x == 0 && Data.y == 20) {
			a();
		} else {
			Cw.Wn("");
		}
	}
	static public void a() {
		Cw.Wn("태초마을 여관");
		ItemObject.moneyshow();
		Material.line();
		Cw.Wn("1박 - 100 G");
		Cw.Wn("[1]  숙박한다  |   [SP]  나간다");
		String cmd = InputS.r("명령");
		while (true) {
			switch (cmd) {
			case "1":
                // 스레드를 생성하여 1초마다 실행되도록 함
                Thread sleepThread = new Thread(() -> {
                    try {
                        // 스레드가 1초마다 실행되도록 설정
                        while (true) {
                            Thread.sleep(1000);
                            Cw.Wn(".");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                // 스레드 시작
                sleepThread.start();

                // 1박 - 100 G 처리
                ItemObject.C_money = ItemObject.C_money - 100;
                ItemObject.moneyshow();

                // 사용자가 다른 입력을 하면 스레드 종료
                InputS.r("아무 키나 누르세요...");

                // 스레드 중지
                sleepThread.interrupt();
                
                Cw.Wn("정말 잘 쉬었다.");
				break;

			case " ":
				
				break;
			}
			
		}
		
	}
}
