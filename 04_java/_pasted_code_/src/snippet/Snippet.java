package snippet;

public class Snippet {
	System.out.println("Esc 키를 누르면 이벤트가 발생합니다. 종료하려면 'q'를 입력하세요.");
	
		        try {
		            while (true) {
		                // 표준 입력에서 문자를 읽어옵니다.
		                int input = System.in.read();  //현재 키보드 입력 값이 숫자로 변환된 상태
	
		                // 입력이 Esc 키인지 확인합니다 (ASCII 코드 27).
		                													//27=esc
		                if (input == 27) {
		                    System.out.println("Esc 키를 눌렀습니다.");
		                    break;
		                }
		                else if(input == 50) {
							System.out.println("성공했다!"+input);
							break;
						}
		                else {
							System.out.println("넌실패했다"+input);
							 
						}
	
		                // 'q'를 입력하면 프로그램을 종료합니다.
		                if (input == 'q') {
		                    System.out.println("프로그램을 종료합니다.");
		                    break;
		                }
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
}

