package com.peisia.db;

public class DtoLogin {
	
	public String id;
	public String pw;
	public String pw_ck;
	public String userNAME;
	
	public DtoLogin(String id, String pw, String pw_ck, String userNAME) {
		super();
		this.id = id;
		this.pw = pw;
		this.pw_ck = pw_ck;
		this.userNAME = userNAME;
	}
	
	

}
