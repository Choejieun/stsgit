package test;

public class Test {
	//목표 : 강아지 주인공과 엑스트라 2개 종류를 만들고, 이 2개 종류는 Test 라는 동일 변수명을 사용
	//주인공은 특성을 가지고 있고 엑스트라는 이름, 성격, 종류 까지만 가진다.
	
	String name;
	String per;
	String kind;
	int pow;
	
	//생성자 함수 오버로딩
	public Test(String name, String per, String kind, int pow) {
		this.name = name;
		this.kind = kind;
		this.per =per;
		this.pow = pow;
		
		System.out.println("주인공이 생성되었습니다.");
	}

	public Test(String name, String per, String kind) {
		this.name = name;
		this.kind = kind;
		this.per =per;
		
		System.out.println("엑스트라가 생성되었습니다.");
	}
	
	void info() {
			System.out.println(this.name+"는 "+this.per+" 성격을 가진 "+this.kind+"의 동물이다."+this.pow);

	}

}
