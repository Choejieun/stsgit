package rpgmy;

public class Character {
	//변수모음을 자바에서는 멤버 변수. 필드. 라고 부름
	//이름, 체력, 공격력, 특성
	String name;
	int hp;
	int attack;
	String ability;
	
	//펑션개념, 객체 호출 시 바로 전문 실행됨
	//생성자 함수라고 함. 객체가 태어날 때 이 함수가 실행 됨.
	Character (String name,	int hp,	int attack,String ability){
		
		this.ability = ability;
		this. attack = attack;
		this.hp = hp;
		this.name =name;
		
		System.out.println(this.name+"가 게임에 다시 참가합니다.");
		}
	
	//함수모음을 자바에서는 멤버 함수 라고 부름
	//선언법
	
	//void 뜻은 return 이 없는 함수라는 뜻.
	//리턴 없는 일반 함수 선언하려면 void 키워드를 붙여야 함.
	
	void info() {
		System.out.println(this.name+"님 [ 체력 : "+this.hp+" 공격력 : "+this.attack+" ] "+this.ability);
	}
	}
	
