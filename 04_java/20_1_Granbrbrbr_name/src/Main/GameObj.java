package Main;

public class GameObj {
		
	int grade;
	String name;
	
	void info() {
		System.out.println("이름 : "+name+" 등급 : "+grade);
	}
	
	public GameObj( String name, int grade) {
		this.grade = grade;
		this.name = name;
	}
	
}
