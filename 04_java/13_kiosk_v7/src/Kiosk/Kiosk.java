package Kiosk;

import java.util.ArrayList;
import java.util.Scanner;

import utll.Cw;

public class Kiosk {
	ProcMenuDrink procMenuDrink = new ProcMenuDrink();
	
	
	static	ArrayList<Product> basket = new ArrayList<Product>();
		// 배열 정의를 시작한다.

		static	Product p1 = new Product("시저캔", 1000);
		static	Product p2 = new Product("유산균", 1000);
		static	Product p3 = new Product("뼈다귀", 1000);

static	Scanner sc = new Scanner(System.in);
	static	String cmd;

		void run() {

			Cw.title();

			loop_a: while (true) {
				Cw.In("1. 음료 / 2.디저트 / x.종료");
				cmd = sc.next();
				switch (cmd) {
				case "1":
					procMenuDrink.run();
					
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

