package com.peisia.service;

import com.peisia.userDB.LoginProc;

public class ServiceBoard {

	public String login(String id, String pw) {
		String url = null;
		LoginProc login = new LoginProc();
		 if(login.IDPWcheck(id, pw)==true) {
			 url = "/board/list?topick=all&old=desc";
			 System.out.println(url);
		 }else {
			 url = "/Error.jsp";
			 System.out.println(url);
		}
		return url;
	}
	
}
