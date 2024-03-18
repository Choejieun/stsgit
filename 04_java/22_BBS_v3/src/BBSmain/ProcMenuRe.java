package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuRe {

	static void run() {

		String cmd = InputS.r("수정할 글 번호");
		// 수정할 번호를 주면, noSetup와 비교하여 글 내용수정
		boolean a = false;
		
		for (Post p : Data.posts) {
			if (cmd.equals(p.noSetup + ""/* 문자열로 변화 */)) {
				a = true;
				
				String textRE = InputS.r("수정할 글 번호");
				p.texts = textRE;
				Material.line();
				Cw.Wn("글 수정됨");
				Material.line();
			}
			}
		if (a == false) {
			Material.line();
			Cw.Wn("수정할 글 없음");
			Material.line();
		}

		}

	}
