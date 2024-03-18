package Main;

import uitn.Color;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class HaveData {
	static public void run() {
		loop_start:
			while (true) {
				ProcBoard procBoard = new ProcBoard();
				Material.line();
				Material.line2();
				Cw.W(Color.RED+"기꙼̈억"+Color.EXIT);
				Cw.W("꙼̈하꙼̈니꙼̈.......?꙼̈");
				Material.line2();
				Cw.Wn("");
				Material.line();
				Cw.Wn("[1] 기억 선택하기");
				Cw.Wn("[2] 기억 삭제하기");
				Cw.Wn("[0] 종료");
				Material.line();
				String cmd = InputS.r("명령");
				switch (cmd) {
				case "1":
					Cw.Wn("당신의 기억을 선택해주세요.");
					Material.line();
					procBoard.loadMAIN_C();
					break;

				case "2":
					Cw.Wn("잊어버릴 기억을 선택하세요.");
					Material.line();
					procBoard.loadMAIN_C_DEL();
					break;

				case "0":
					Cw.Wn("종료");
					break loop_start;
				}
			}

	}
	
	static public void run2() {

	}

}
