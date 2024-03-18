package BBSmain;

import uitn.Color;
import uitn.Cw;
import uitn.Material;

public class Dps {

	static void run() {

		loop_a: while (true) {

			Material.line();
			Color.red("DPS");
			Cw.Wn("[1] 원거리");
			Cw.Wn("[2] 근거리");
			Cw.Wn("[x] EXIT");
			Material.line();
			
			String cmd = InputS.r("명령");
			switch (cmd) {
			case "1":
				Material.line();
				Color.purple("원거리 게시판");
				Material.line();
				Cw.Wn("[1] 글쓰기");
				Cw.Wn("[2] 글 목록보기");
				Cw.Wn("[x] EXIT");

				loop_Dps_bbs: while (true) {
					cmd = InputS.r("명령");
					switch (cmd) {
					case "1":
						Cw.Wn("[1] 글쓰기");
					case "2":
						Cw.Wn("[2] 글 목록보기");
						break;
					case "x":
						break loop_Dps_bbs;
					}
				}

				break;
			case "2":

				break;
			case "x":
				break loop_a;
			}
		}
	}
}
