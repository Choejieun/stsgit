package Main;

import uitn.Color;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Main {
		public static void main(String[] args) {
			
			loop_start:
			while (true) {
				Material.line();
				
				Material.line2();
				Cw.W(Color.RED+"R"+Color.EXIT);
				Cw.W("PG");
				Material.line();
				Material.line();
				Cw.Wn("0.0.4");
				Cw.Wn("[1] 새로 시작하기");
				Cw.Wn("[2] 불러오기");
				Cw.Wn("[0] 종료");
				Material.line();
				String cmd = InputS.r("명령");
				switch (cmd) {
				case "1":
					Zero.run();
					break;

				case "2":
					HaveData.run();
					break;

				case "0":
					Cw.Wn("종료");
					break loop_start;
				}
			}
		
	}} // main


/*

[ 업데이트 기록 ]
2024-01-10 [v 0.1] :: 데이터베이스 연결
	- 상점 정상화
	- 세이브 데이터 1차 연결
	- 유저 차별화
	- 마을 기능
2024-01-11 [v 0.1.1] :: 데이터베이스 연결
	- 유저 데이터 삭제 가능 / 공백 시 리턴
2024-01-12 [v 0.1.2] :: 데이터베이스 연결
- 유저 삭제 시 관련 데이터 전부 삭제
- 상점 1차 리모델링 완료
2024-01-16 [v 0.2.0] :: 데이터베이스 연결
- 상점 처리 완료
- 각 유저별 초기 아이템을 더 갖기(상점 연동용)
 - 캐릭터 생성 시 마을 생성 과정을 추가
		1. 마을에 해당하는 아이템 값을 데이터베이스에 추가
		2. 각 캐릭터에 따라 상점에 진입 시 stand 가 새로 로드 되도록 한 것을 이용
		3. 캐릭터 삭제 시 할당된 로드값도 삭제
	
todo-
X,Y 데이터베이스 연결하기
  */
