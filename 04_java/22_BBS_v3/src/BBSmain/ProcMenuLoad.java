package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuLoad {

	static void run() {
		Material.line();
		String cmd = InputS.rl("보고싶은 게시글 번호");

		boolean postFound = false;

		for (Post p : Data.posts) {
			if (cmd.equals(p.noSetup + "")) {
				postFound = true;
//				p.hit = p.hit++;
				p.info();
				
//				for (Post p : Data.posts) {
//					if (cmd.equals(p.noSetup + ""/* 문자열로 변화 */)) {
//						a = true;
//						
//						String textRE = InputS.r("수정할 글 번호");
//						p.texts = textRE;
//						Material.line();
//						Cw.Wn("글 수정됨");
//						Material.line();
//					}
				
				
			}
		} //for문 종료
		if (!postFound) {
			Material.line();
			Cw.Wn("글을 찾지 못하였습니다.");
			Material.line();
		}

	}
}
