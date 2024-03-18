package kiosk;

import Cw.Cw;

public class ProcMenuDrink {
		void run() {
		Cw.In("넌 선택했다 1번");

		loop_b: while (true) {

			Kiosk.p1.info();
			Kiosk.p2.info();
			Cw.In("1 : 시저캔  / 2 : 유산균 / x.이전메뉴 ");
			Kiosk.cmd = Kiosk.sc.next(); // 신규명령어

			switch (Kiosk.cmd) {
			case "1":
				Cw.In("시저캔을 장바구니에 담았습니다.");
				Cw.In("------------------------------------");

				Product n1_1 = new Product("시저캔", 1000);
				Kiosk.basket.add(n1_1);
				// n1_1을 배열 0번에 배정한다. (name,price) 값을 갖고 있다.

				break;
			case "2":
				Cw.In("유산균을 장바구니에 담았습니다.");
				Cw.In("------------------------------------");

				Product n1_2 = new Product("유산균", 1000);
				Kiosk.basket.add(n1_2);

				break;
			case "x":
				break loop_b;

			default:
				Cw.In("존재하지 않는 메뉴입니다.");
				Cw.In("------------------------------------");
				break;
			}

		}}

	}

