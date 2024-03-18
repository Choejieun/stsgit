package BBSmain;

import uitn.Color;
import uitn.Cw;
import uitn.Material;

public class ProcMenuBbs {

	static void run() {
		Material.line();
		Color.purple("게시판");
		Material.line();
			loop_a: while (true) {
				Cw.Wn("[1] 글 쓰기");
				Cw.Wn("[2] 글 읽기");
				Cw.Wn("[3] 글 리스트");
				Cw.Wn("[x] EXIT");
				String cmd = InputS.r("명령");
			switch (cmd) {
				case "1":
					ProcMenuWrite.run();
					break ;
				case "2":
					ProcMenuLoad.run();
					break ;
				case "3":
					ProcMenuList.run();
					break ;
				case "x":
					break loop_a;
				}
			}
		}
	}
