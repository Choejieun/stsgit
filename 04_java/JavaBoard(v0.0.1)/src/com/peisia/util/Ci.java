package com.peisia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 입력을 담당하는 클래스. (Scanner 등)
 */
public class Ci {
	static Scanner sc = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				//내장클래스  의 변수 = 새 내장 클래스
	//버퍼드리더 : [컴퓨터] <데이터를> 완충 기억 장치로 옮기다 ' 를 읽는다.
	//인풋스트림리더 : <데이터를> 흐름을 읽다.
	// reader(데이터 저장) > 저장된 데이터 읽는데(유저입력하달) 을 저장으로 옮긴다.
				//값을 읽어내는 기능, 공백가능
	
	static public String r() {
		return sc.next();
		//다음 공백까지의 문자열을 읽어온다.
	}
	
	static public String r(String comment) {
		Cw.w(comment+":");
		return sc.next();
		//다음 공백까지의 문자열을 읽어온다.
	}
	
	static public String rl(String comment) {
		Cw.w(comment+":");
		
	// reader.readLine(); 이렇게 가면 오류가 뜨면서 자동으로 아래 명령어를 써줌
		
		
		try {   // catch와 세트로 구성 무저가ㅓㄴ  ★★★★  [  P444    ]
			//시도를 함
			return reader.readLine();
						//1개의 줄 전체를 읽어온다.
									//위험한 함수(스캐너랑 같은 역할...
									//★공백을 입력할 수 있게 됨★
					//실행을 하는 중
				//뭔가 이상해짐 > exc~발생함(코드가 길어도 동일) > 캐치 실행
			
		} catch (IOException e) { // 작업중 "예외상황"  발생 시 출력되는 예의상코드
			//      (잡아낼 종류)  // 잡아낸 이후에 할 행동을 추가 하여도 됨
			e.printStackTrace(); //에러반환 -- 콘솔창에 오류글씨와 동일한 기능을 함
			return null; //객체 지정 x 문자열("1")을 적어도 됨
		}
	}
}
