package String;

public class Main {

	public static void main(String[] args) {
		p193();
//		p199();
	}
	
	public static void p193() {
		//책.193 참고
		String cat = "고양이";
		String cat2 = "고양이";          //내용이 동일 객체, 동일 내용이라 추가 주소생성 X
		String cat3 = new String("고양이");  //추가 주소
		String cat4 = new String("고양이"); //추가 주소
		// System.identityHashCode(cat) << 주소 값 출력함.
		System.out.println(System.identityHashCode(cat)+" 주소a");
		System.out.println(System.identityHashCode(cat2)+" 주소a");
		//연산자 == 는 사실상 이 주소값을 계산하는 것과 동일한 효과일듯...???
		
		System.out.println(System.identityHashCode(cat3)+" 주소b");
		System.out.println(System.identityHashCode(cat4)+" 주소c");		
	}
	public static void p199() {
		//책.199 예제 참고
//		String s = "abc";
////	Cw.wn(cat.length());
	
//	Cw.wn(s.charAt(1));	// char > int
//	System.out.println(1);
//	System.out.println(s.charAt(1));
	
	char c = 'c';
//	System.out.println(c);
	System.out.println((int)c);
	
	String cat = "고양이";
	System.out.println(String.format("%10s", cat));
	}
}


