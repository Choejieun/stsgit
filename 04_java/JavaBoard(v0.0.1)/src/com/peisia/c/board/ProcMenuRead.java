package com.peisia.c.board;

import com.peisia.c.board.data.Data;
import com.peisia.c.board.data.Post;
import com.peisia.util.Cw;

public class ProcMenuRead {
	static void run() {
		//todo
		//임시
		Cw.wn("읽기임");
		for(Post p:Data.posts) {  p.info(); }

	}

}
