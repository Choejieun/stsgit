package kisok;

import java.util.ArrayList;
import java.util.Scanner;

import util.Cw;

public class Kiosk {

	ArrayList<Product> basket = new ArrayList<Product>();
	// 배열 정의를 시작한다.

	Product p1 = new Product("시저캔", 1000);
	Product p2 = new Product("유산균", 1000);
	Product p3 = new Product("뼈다귀", 1000);

	Scanner sc = new Scanner(System.in);
	String cmd;

	void run() {

		Cw.title();

		loop_a: while (true) {
			Cw.In("1. 음료 / 2.디저트 / x.종료");
			cmd = sc.next();
			switch (cmd) {
			case "1":
				Cw.In("넌 선택했다 1번");

				loop_b: while (true) {

					p1.info();
					p2.info();
					Cw.In("1 : 시저캔  / 2 : 유산균 / x.이전메뉴 ");
					cmd = sc.next(); // 신규명령어

					switch (cmd) {
					case "1":
						Cw.In("시저캔을 장바구니에 담았습니다.");
						Cw.In("------------------------------------");

						Product n1_1 = new Product("시저캔", 1000);
						basket.add(n1_1);
						// n1_1을 배열 0번에 배정한다. (name,price) 값을 갖고 있다.

						break;
					case "2":
						Cw.In("유산균을 장바구니에 담았습니다.");
						Cw.In("------------------------------------");

						Product n1_2 = new Product("유산균", 1000);
						basket.add(n1_2);

						break;
					case "x":
						break loop_b;

					default:
						Cw.In("존재하지 않는 메뉴입니다.");
						Cw.In("------------------------------------");
						break;
					}

				}

				break;
			case "2":
				Cw.In("넌 선택했다 2번");
				p3.info();
				Cw.In("------------------------------------");
				Product n2_1 = new Product("뼈다귀", 1000);
				basket.add(n2_1);

				break;
			case "x":
				break loop_a;
			}

		}
		Cw.In("구매 종료");

		int endbasket = basket.size();
		Cw.In("구매한 상품의 갯수 : " + endbasket);

		int sum = 0;
		for (int i = 0; i < endbasket; i = i + 1) {
			sum = sum + basket.get(i).price;
		}
		Cw.In("구매한 상품의 금액 : " + sum);

	}

}
