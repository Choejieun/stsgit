package com.peisia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputS {
	//문자열을 받기 위한 준비
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	static public String r(String comment ) { //InputS.r(comment)
		Cw.W(comment+" : "); //현재 함수의 객체 comment를 추적
		return sc.next();
	}
	static public String rr(String comment ) { //InputS.r(comment)
		Cw.W(comment+" : "); //현재 함수의 객체 comment를 추적
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static public String rl(String comment ) { //InputS.rl(comment)
		Cw.Wn(comment+" : "); //현재 함수의 객체 comment를 추적
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//
	    }
