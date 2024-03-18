package IGOROSY;

import java.io.IOException;

import uitn.Material;

public class Main {

	public static void main(String[] args) {
		Material.title(); // 제목출력
		
		while (true) {
			String cmd = InputS.r("명령");
		
			switch (cmd) {
			case "1":
				System.out.println("영문 대문자를 입력하세요");
				try {
					while (true) {
						// 표준 입력에서 문자를 읽어옵니다.
						
						int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태

						// 입력이 Esc 키인지 확인합니다 (ASCII 코드 27).
						// 27=esc
						
						if (input == 65) {	System.out.println("얘는");}
						else if (input == 66) {System.out.println("보통이 아니네");} // "B"
						else if (input == 67) {System.out.println("시발");} // "C"
						else if (input == 68) {System.out.println("디졌다");} // "D"
						else if (input == 69) {System.out.println("에바");} // "E"
						else if (input == 70) {System.out.println("퍽킹");} // "F"
						else if (input == 71) {System.out.println("지랄");} // "G"
						else if (input == 72) {System.out.println("히발");} // "H"
						else if (input == 73) {System.out.println("임재열");} // "I"
						else if (input == 74) {System.out.println("존나");} // "J"
						else if (input == 75) {System.out.println("ㅋㅋ");} // "K"
						else if (input == 76) {System.out.println("리얼");} // "L"
						else if (input == 77) {System.out.println("마조히스트");} // "M"
						else if (input == 78) {System.out.println("네 얼굴");} // "N"
						else if (input == 79) {System.out.println("오바마");} // "O"
						else if (input == 80) {System.out.println("박재영");} // "P"
						else if (input == 81) {System.out.println("평신");} // "Q"
						else if (input == 82) {System.out.println("알쓰");} // "R"
						else if (input == 83) {System.out.println("시발");} // "S"
						else if (input == 84) {System.out.println("티발");} // "T"
						else if (input == 85) {System.out.println("유재석");} // "U"
						else if (input == 86) {System.out.println("별로");} // "V"
						else if (input == 87) {System.out.println("왜");} // "W"
						else if (input == 88) {System.out.println("X알");} // "X"
						else if (input == 89) {System.out.println("이 새끼");} // "Y"
						else if (input == 90) {System.out.println("즐");} // "Z"
						
						// '스페이스바'를 입력하면 프로그램을 종료합니다.
						if (input == 32) {
							Material.title(); // 제목출력
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "2":
				
				System.out.println("영문 대문자를 입력하세요");
				try {
					while (true) {
						// 표준 입력에서 문자를 읽어옵니다.
						int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태

						// 입력이 Esc 키인지 확인합니다 (ASCII 코드 27).
						// 27=esc
						
						if (input == 65) {	System.out.println("나는");}
						else if (input == 66) {System.out.println("보통이네");} // "B"
						else if (input == 67) {System.out.println("코로나");} // "C"
						else if (input == 68) {System.out.println("대박");} // "D"
						else if (input == 69) {System.out.println("엑스칼리버");} // "E"
						else if (input == 70) {System.out.println("프리티");} // "F"
						else if (input == 71) {System.out.println("잘");} // "G"
						else if (input == 72) {System.out.println("형");} // "H"
						else if (input == 73) {System.out.println("임재열");} // "I"
						else if (input == 74) {System.out.println("제일");} // "J"
						else if (input == 75) {System.out.println("ㅎㅎ");} // "K"
						else if (input == 76) {System.out.println("라면");} // "L"
						else if (input == 77) {System.out.println("마인크래프트");} // "M"
						else if (input == 78) {System.out.println("내 얼굴");} // "N"
						else if (input == 79) {System.out.println("엄준식");} // "O"
						else if (input == 80) {System.out.println("박사");} // "P"
						else if (input == 81) {System.out.println("큐티");} // "Q"
						else if (input == 82) {System.out.println("레알");} // "R"
						else if (input == 83) {System.out.println("슈퍼");} // "S"
						else if (input == 84) {System.out.println("티쳐");} // "T"
						else if (input == 85) {System.out.println("유튜브");} // "U"
						else if (input == 86) {System.out.println("베스트");} // "V"
						else if (input == 87) {System.out.println("?");} // "W"
						else if (input == 88) {System.out.println("X맨");} // "X"
						else if (input == 89) {System.out.println("이쁘다");} // "Y"
						else if (input == 90) {System.out.println("정");} // "Z"
						
						// '스페이스바'를 입력하면 프로그램을 종료합니다.
						if (input == 32) {
							Material.title(); // 제목출력
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			
		}
		
	}}
