package com.peisia.util;

public class Material {

	final static String DOT = "-";	
	public static void line() {
//		Cw.w(x);	// 일반 멤버 변수는 못씀.
		for(int i=0;i<32;i=i+1) {
			Cw.W(DOT);	// static 멤버 변수는 사용 가능.
		}
		Cw.Wn("");
	}
	
	public static void line2() {
//		Cw.w(x);	// 일반 멤버 변수는 못씀.
		for(int i=0;i<8;i=i+1) {
			Cw.W(DOT);	// static 멤버 변수는 사용 가능.
		}
	}
	
	public static void title() {
	Material.line();
	Material.line2();
	Cw.W(Color.RED+"R"+Color.EXIT);
	Cw.W("PG");
	Material.line2();
	Cw.Wn(DOT);
	Material.line();
	Cw.Wn("[1] 시작");
	Cw.Wn("[2] 종료");
	Material.line();
	}
	
	public static void endC() {
	Material.line();
	Material.line2();
	Cw.W(Color.RED+"R"+Color.EXIT);
	Cw.W("PG");
	Material.line2();
	Cw.Wn(DOT);
	Material.line();
	Cw.Wn("See you next time.");
	Material.line();
	}

}
