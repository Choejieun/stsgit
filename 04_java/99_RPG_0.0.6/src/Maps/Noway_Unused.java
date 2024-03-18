package Maps;

import uitn.Cw;

public class Noway_Unused {
	static public void run() {
		Data p = new Data();
		Data.GOGO = true;

		if (Data.y == 0 && Data.x != 0) {
			Cw.Wn("★ 더 이상 갈 길이 없다.");
			Data.GOGO = false;
		}
		if (Data.y < 0 && Data.x == 0) {
			Cw.Wn("★ 더 이상 갈 길이 없다.");
			Data.GOGO = false;
		}
		if (Data.y >= 1 && Data.x != 0) {
			Cw.Wn("★ 더 이상 갈 길이 없다.");
			Data.GOGO = false;
		}

	}
} // run
