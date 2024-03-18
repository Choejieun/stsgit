package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuList {

	static void run() {
		Material.line();
		int m = 0;
		Post w = null;

		if (Data.posts.size() >= 1) {
//			for (Post list : Data.posts) {
//				Data.posts.indexOf(list);
//				if (list.hit > m) {
//					m = list.hit;
//				}
//				list.infoListBest();
//			}

			for (int i = 0; i < Data.posts.size(); i++) {
				if (Data.posts.get(i).hit > m) {
					m = Data.posts.get(i).hit;
					w = Data.posts.get(i);
				}
			}
			w.infoListBest();

			for (Post list : Data.posts) {
				Material.line();
				list.infoList();
			}
		} else {
			Cw.Wn("작성된 글 리스트가 없습니다.");
			Material.line();
		}
	}
}
