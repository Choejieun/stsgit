package BBSmain;

import uitn.Cw;
import uitn.Material;

public class ProcMenuWrite {

	static void run() {
	Cw.Wn("글입력 창");
	
	
	 String title;
	while (true) {
		title = InputS.rl("제목");
		if(title.length() > 0) { //글자열 수 비교
		break;	
		}
		else {
			Cw.Wn("오류발생 다시 시도하세요.");
		}}
		
		String texts;
		while (true) {
			texts = InputS.rl("내용");
			if(texts.length() > 0) { //글자열 수 비교
				break;	
			}
			else {
				Cw.Wn("오류발생 다시 시도하세요.");
			}}
			
			String write;
			while (true) {
				write = InputS.r("작성자");
				if(write.length() > 0) { //글자열 수 비교
					break;	
				}
				else {
					Cw.Wn("오류발생 다시 시도하세요.");
				}}
//			public Post(String title,String texts, String write, int hit) {
			Post p = new Post(title, texts, write, 0);
			Data.posts.add(p);	
			Material.line();
			Cw.Wn("글 작성됨");
			Material.line();
	}}
