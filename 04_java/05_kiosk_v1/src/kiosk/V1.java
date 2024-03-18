package kiosk;

import java.util.Scanner;

public class V1 {

		public static void main(String[] args) {
			
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
			System.out.println("★★★★★★★강아지 - 카페★★★★★★★★★");
			System.out.println("★★★★★★★★★★★★★★★★★★★★★★");
			
			Scanner sc = new Scanner(System.in);
			String cmd;
			
			loop_a:
				while (true) {
										System.out.println("너는 선택 한다 : ");
										cmd = sc.next();
				switch (cmd) {
				case "1":
					System.err.println("넌 선택했다 1번");
					break;
				case "2":
					System.err.println("넌 선택했다 2번");
					break;
				case "x":
					break loop_a;
				}
										
				}
			System.out.println("프로그램 종료");
			
			}}

