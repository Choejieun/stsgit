package Framework;

import java.util.HashMap;
import java.util.Scanner;

public class HasMap_a {
	public static void main(String[] args) {
		
		
		HashMap<String, String>hs = new HashMap<String, String>();
		
		System.out.println("너의 이름은");
		Scanner sc = new Scanner(System.in);
		String cmd = sc.next();    //공백열 이후 문자 자름

		hs.put("k-1",cmd);
		hs.put("k-2","고양이");
		hs.put("k-3","천사");
		hs.put("k-4","오징어");
		
		int n = hs.size();
		System.out.println(n);
		System.out.print("이 세계가 정한 용사! ");
		String x =hs.get("k-1");
		System.out.println(x);
		
		hs.remove("k-2");
		System.out.println(hs.size());
		
		//특정 언어 반사 가능할듯
		
	}

}
