package com.peisia.rpcMy; //서브페이지 없이 가위바위보 하는 방식

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		xx:
			while (true) {
		System.out.println("가위바위보 중에 하나 입력해주세요.");
		
		Scanner sc = new Scanner(System.in);
		String userRpc = sc.next();
		System.out.println("님이 낸 것은 : "+userRpc);
		
		int r = (int)(Math.random() * 3 + 1);
//		System.out.println("주사위를 굴려 "+r+"이 나왔습니다.");
		
		String comRpc = " ";
		if( r == 1) {                       //숫자열은 부등호 가능
			comRpc = "가위";
		} else if(r == 2) {
			comRpc = "바위";
		} else if(r ==3) {
		comRpc = "보";		}
		
//	System.out.println("컴퓨터가 " + comRpc + " 냈습니다.");
	
	//todo
	// 문자열 부등호는 .equals 로 대체 [ a == b ] > [ a.equals(b) ] 같으면 true로 리턴
	String result ="";
	switch(userRpc) {
			case "가위":
	if(userRpc.equals("가위")) {
		if(comRpc.equals("가위")) {	
			result = "비김";
		}
		if(comRpc.equals("바위")) {	
			result = "패배";
		}
		if(comRpc.equals("보")) {	
			result = "승리";
		}
		
	}
	break;
			case "바위":
	if(userRpc.equals("바위")) {	
		if(comRpc.equals("가위")) {	
			result = "승리";
		}
		if(comRpc.equals("바위")) {	
			result = "비김";
		}
		if(comRpc.equals("보")) {	
			result = "패배";
		}
		
	}
	break;
			case "보":
	if(userRpc.equals("보")) {	
		if(comRpc.equals("가위")) {	
			result = "패배";
		}
		if(comRpc.equals("바위")) {	
			result = "승리";
		}
		if(comRpc.equals("보")) {	
			result = "비김";
		}
	}
	break;
    case "x":
	break xx;
	}
	System.out.println("결과 : " + result);

	}}
}
