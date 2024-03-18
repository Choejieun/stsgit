package BBSmain;

import uitn.Color;
import uitn.Cw;

public class Tank {

	static void run() {
		
	loop_a: while (true) {
		
		Cw.Wn("---------------");
		Color.cyan("TANK");
		Cw.Wn("[1] 원거리");
		Cw.Wn("[2] 근거리");
		Cw.Wn("[x] EXIT");
		Cw.Wn("---------------");
		
		String cmd = InputS.r("명령");
		switch (cmd) {
		case "1": 
		break;
		case "2": 
		break;
		case "x":
		break loop_a;
		}}}
}