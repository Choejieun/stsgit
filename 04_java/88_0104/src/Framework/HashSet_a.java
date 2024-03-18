package Framework;

import java.util.HashSet;

public class HashSet_a {
public static void main(String[] args) {
	
	HashSet<String> hs = new HashSet<String>();
	hs.add("개");
	hs.add("개");
	//중복자료 허용 x
	hs.add("고양이");
	
	if(hs.contains("개")) {
		System.out.println("이 안에 개 있다");
	};
	
//	hs.clear();
	if(hs.isEmpty()) {
		 System.out.println("데이터 없음");
		}
		else {
			System.out.println("데이터 있음");
		}
	
	System.out.println(hs.size());
	//중복 계산 x
	
}
}
