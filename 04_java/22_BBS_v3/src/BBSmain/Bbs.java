package BBSmain;

import uitn.Color;
import uitn.Cw;
import uitn.Material;

public class Bbs {
	static void run() {

		loop_start:
		while (true) {
			Material.line();
			String dps = String.format("%22s","[1] 딜러");    //글자를 꾸미는 방법, 숫자열은 %d 사용
			String tank = String.format("%22s","[2] 탱커");    //글자를 꾸미는 방법, 숫자열은 %d 사용
			String supp = String.format("%21s","[3] 서포터");    //글자를 꾸미는 방법, 숫자열은 %d 사용
			Cw.Wn(Color.RED+dps+Color.EXIT);
			Cw.Wn(Color.CYAN+tank+Color.EXIT);
			Cw.Wn(Color.YELLOW+supp+Color.EXIT);
			Cw.Wn("[4] 게시판");
			Cw.Wn("[5] 마이페이지");
			Cw.Wn("[x] EXIT");
			Material.line();
			String cmd = InputS.r("명령");
			switch (cmd) {
			case "1":
				Dps.run();
				break;
			case "2":
				Tank.run();
				break;
			case "3":
				Support.run();
				break;
			case "4":
				ProcMenuBbs.run();
				break;
			case "5":
				ProcMenuBbs.run();
				break;
			case "x":
				break loop_start;
			}
		}
	}
	}
	
