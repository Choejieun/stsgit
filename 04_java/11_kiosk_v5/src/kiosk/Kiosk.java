package kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {

	ArrayList<Product> basket = new ArrayList<Product>();
	//배열 정의를 시작한다.
	
	Product p1 = new Product("시저캔",1000);
	Product p2 = new Product("유산균",1000);
	Product p3= new Product("뼈다귀",1000);
	
	Scanner sc = new Scanner(System.in);
	String cmd;
	
	void run() {
		
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
		System.out.println("★★★★★★★강아지 - 카페★★★★★★★★★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
	
	loop_a:
		while (true) {
								System.out.println("1. 음료 / 2.디저트 / x.종료");
								cmd = sc.next();
		switch (cmd) {
		case "1":
			System.err.println("넌 선택했다 1번");
				
					loop_b:
						while (true) {
							
							p1.info();
							p2.info();
							System.out.println("1 : 시저캔  / 2 : 유산균 / x.이전메뉴 ");
							cmd = sc.next(); //신규명령어
							
							switch (cmd) {
							case "1":
								System.out.println("시저캔을 장바구니에 담았습니다.");
								System.out.println("------------------------------------");
								
								Product n1_1 = new Product("시저캔",1000);
								basket.add(n1_1);
								// n1_1을 배열 0번에 배정한다. (name,price) 값을 갖고 있다.
								
								break;
							case "2":
								System.out.println("유산균을 장바구니에 담았습니다.");
								System.out.println("------------------------------------");

								
								Product n1_2 = new Product("유산균",1000);
								basket.add(n1_2);
								
								break;
							case "x":
								break		loop_b;

							default:
								System.out.println("존재하지 않는 메뉴입니다.");
								System.out.println("------------------------------------");
								break;
							}
							
						}
				
			break;
		case "2":
			System.err.println("넌 선택했다 2번");
			p3.info();
			System.out.println("------------------------------------");
			Product n2_1 = new Product("뼈다귀",1000);
			basket.add(n2_1);
			
			break;
		case "x":
			break loop_a;
		}
								
		}
	System.out.println("구매 종료");
	
	int endbasket = basket.size();
	System.out.println("구매한 상품의 갯수 : "+endbasket);
	
	int sum = 0;
	for(int i = 0 ; i <endbasket ; i=i+1) {
		sum = sum+basket.get(i).price; 
	}
	System.out.println("구매한 상품의 금액 : "+sum);

	
	}
	
}
