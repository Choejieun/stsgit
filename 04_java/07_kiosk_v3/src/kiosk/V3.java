package kiosk;

import java.util.Scanner;

public class V3 {

		public static void main(String[] args) {
			
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★★★★★★강아지 - 카페★★★★★★★★★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
			
			Product p1 = new Product("시저캔",1000);
			Product p2 = new Product("유산균",1000);
			Product p3= new Product("뼈다귀",1000);
			
			Scanner sc = new Scanner(System.in);
			String cmd;
			
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
										break;
									case "2":
										System.out.println("유산균을 장바구니에 담았습니다.");
										break;
									case "x":
										break		loop_b;

									default:
										System.out.println("존재하지 않는 메뉴입니다.");
										break;
									}
									
								}
						
					break;
				case "2":
					System.err.println("넌 선택했다 2번");
					p3.info();
					break;
				case "x":
					break loop_a;
				}
										
				}
			System.out.println("프로그램 종료");
			
			}}

