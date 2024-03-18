package com.peisia.c.site;

import com.peisia.c.member.ProcLogin;
import com.peisia.c.member.ProcMemberRegister;
import com.peisia.c.mysqlboard.ProcBoard;
import com.peisia.c.site.display.DispSite;
import com.peisia.c.util.Ci;
import com.peisia.c.util.Cw;
import com.peisia.c.util.Db;

public class SiteMain {
	static private String cmd = "";

	static public void run() {
		Db.dbInit();	//주의
		
		loop: while (true) {
			DispSite.entranceTitle();
			if(ProcLogin.ProcLogin_on == null) {
			cmd = Ci.r("[r]회원가입 [l]로그인  [e]프로그램종료");
			}
			else {
				Cw.wn("환영합니다. "+ProcLogin.ProcLogin_on+" 님");
				cmd = Ci.r("[r]회원가입 [l]★로그아웃 [a]관리자 [e]프로그램종료 [b]게시판(임시입구)");
			}
			switch (cmd) {
			case "r":
				ProcMemberRegister.run();
				break;
			case "l":
				if(ProcLogin.ProcLogin_on == null) {
				ProcLogin.run();}
				else {
					ProcLogin.ProcLogin_on = null;
					Cw.wn("");
				}
				break;
			case "a":
				if(ProcLogin.ProcLogin_on != null) {
					Cw.wn("관리자 화면");
				break;}
				break;
			case "e":
				Cw.wn("프로그램 종료");
				break loop;
			case "b":
				if(ProcLogin.ProcLogin_on != null) {
				ProcBoard.run();
				break;}
				break;
			default:
				Cw.wn("장난x");
			}
		}
	}
}