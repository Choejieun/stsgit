package util;

public class Cw {

			static public void w(String s) {
				System.out.print(s); // 줄바꿈 x
			}

			static public void wn(String s) {
				System.out.println(s); // 줄바꿈 o
			}

			//// static 변수 ////
			// final 키워드를 붙이면 변수가 상수가 됨. 처음에 값이 들어가면 이후 값을 못 바꿈.
			// 상수 명명 국룰 = 이름을 다 대문자로 씀.

			final static String DOT = "🎁"; 

			public static void rein() {
//				So.w(x);	// 일반 멤버 변수는 못씀.
				for (int i = 0; i < 32; i = i + 1) {
					Cw.w(DOT); // static 멤버 변수는 사용 가능.
				}
				Cw.wn("");
			}

			public static void title() {
				rein();
				Cw.wn("강아지 카페");
				rein();
			}

		}

