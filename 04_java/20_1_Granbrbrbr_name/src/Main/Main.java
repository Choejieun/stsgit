package Main;

import java.util.ArrayList;

public class Main {
	
public static void main(String[] args) {
	
	Character a = new Character("왕코",100,100);
	Sword b = new Sword("장검",100,100,50,10);
	Sword c = new Sword("단검",100,100,50,10);
	
	ArrayList<GameObj> gg = new ArrayList<GameObj>();
			gg.add(a);
			gg.add(b);
			gg.add(c);
			
			for(GameObj x : gg) {
				System.out.println(x.name);
				x.info();
			}
		
			System.out.println(a.name+"가 "+a.grade+"등급인데  "+a.hp+"의 체력을 가지고 있다.");
	
}
}
