package BackEnd;

import java.io.IOException;

import Maps.Maps;
import Maps.Village;
import uitn.Cw;

public class Store_main {
	
	static public void shop() {
		ItemObject.moneyshow();
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
					Store_pay.purchaseItem();
				} // "1"
				else if (input == 50) { // 판매하기
					Store_Sell.handleSellOption();
				} // "2"
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	
	
	
}
