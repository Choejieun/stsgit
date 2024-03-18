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

	
todo-
상점 아이템  ... 활성화 탭과 비활성화 탭
X,Y 데이터베이스 연결하기
  */
