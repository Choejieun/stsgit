package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuList {
	static void run() {
		Material.line();
		
		if (Data.posts.size() >= 1) {
		for (Post list : Data.posts) {
							list.infoList();	}}
		else {
				Cw.Wn("작성된 글 리스트가 없습니다..");
			}
		Material.line();
	}}
							
