package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuLoad {

	static void run() {
		Material.line();
		
		String cmd = InputS.r("명령");
		
		if (Data.posts.size() >= 1) {
		for (Post list : Data.posts) {
							list.info();	}
		}
		else {
				Cw.Wn("작성된 글이 없습니다.");
			}
		Material.line();
	}}
							
