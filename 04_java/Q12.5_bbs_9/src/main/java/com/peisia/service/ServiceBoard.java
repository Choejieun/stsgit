package com.peisia.service;

import com.peisia.db.DaoLogin;
import com.peisia.db.DtoLogin;
import com.peisia.userDB.LoginProc;

public class ServiceBoard {

	public String login(String id, String pw) {
		String url = null;
		LoginProc login = new LoginProc();
		 if(login.IDPWcheck(id, pw)==true) {
			 url = "/board/list?topick=all&old=desc";
		 }else {
			 url = "/Error.jsp";
		}
		return url;
	}

	public String join(DtoLogin dtoLogin) {
		String url = null;
		DaoLogin daoLogin = new DaoLogin();
		int ck = daoLogin.Duplicated(dtoLogin);
		System.out.println("ck : "+ck);
		if(ck == 1 ) {
		daoLogin.insert(dtoLogin);
			url = "/index.jsp";
		}else {
			url = "/Error.jsp";
		}
		return url;
	}
	
}
