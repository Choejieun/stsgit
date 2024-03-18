package ArrayList;

import java.util.ArrayList;

public class ArrayList_main {
	
		public static void main(String[] args) {
			//자동임포트 ctrl+shift+o(영문자O)
			
			ArrayList<String> xx = new ArrayList<String>();
			
			xx.add("고양이");	
			//고양이가 들어감. index 0. 이제 1개.
			
			xx.add("개");	
			//개가 들어감. index 1. 2개됨. 넣을때 마다 크기가 늘어남.
			
			xx.set(1, "강아지");	
			//개 자리에 강아지가 들어감.
			
			xx.add("너굴맨");	
			//너굴맨이 들어감. index 2. 3개됨.
			
			xx.remove(2);	//index 2에 있는거 제거함. 자리도 없애는거라 이제 갯수 2개됨. 뺄때마다 크기가 줄어듬.
//			xx.clear();		//싹다 지움. 수량도 0됨.
			
			System.out.println("몇개?:"+xx.size());
			//갯수를 세는 함수
			
			for(int i=0;i<xx.size();i=i+1) {
				System.out.println(xx.get(i));
				// 각 번호에 해당하는 인덱스를 전부 가져오는 식
			}
			
			boolean hasCat = xx.contains("강아지"); 
			//boolean : 트루 or 페일즈용 함수식, 이후에오는 변수는 트루or페일즈로 변환된다.
			//hasCast = xx.contais("...");   == 변수는 contains로 xx 안에 ("...")가 있을 경우 true로 나타난다.
			
// contains 함수는 ArrayList 클래스에서 제공되는 메서드 중 하나로, 
// 주어진 객체가 리스트에 포함되어 있는지를 확인하는 데 사용됩니다.
			
			if(hasCat == true) {
				System.out.println("고양이 있음");
			}else {
				System.out.println("고양이 없음");
			}

		}

	}
