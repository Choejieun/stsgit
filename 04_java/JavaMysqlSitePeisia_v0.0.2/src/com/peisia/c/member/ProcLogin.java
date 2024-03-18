package com.peisia.c.member;

import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class ProcLogin {
	static public  String ProcLogin_on;

	static public void run() {
		Cw.wn("======== 로그인 =========");
		while (true) {
		String ID = Ci.r("아이디 :");
		if (ID.length()<0) {
			Cw.wn("공백불가");
			break;
		}
		String PW = Ci.r("비밀번호 :");
		if (PW.length()<0) {
			Cw.wn("공백불가");
			break;
		}
		if(Db.isProcLogin(ID, PW)) {
			ProcLogin_on = ID;
			return;
		}else {
			return;
		}
		
		}
	}
}
