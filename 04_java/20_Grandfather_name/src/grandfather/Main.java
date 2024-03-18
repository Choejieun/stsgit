package grandfather;

import java.util.ArrayList;

import Cw.Cw;

public class Main {

	public static void main(String[] args) {
		// 게임 오브젝트들 로딩
		GameObj n = new GameObj();
		
		Character c = new Character("고양이",3,100);
		Sword s = new Sword("단검",2,100,50,70);
		Sword l = new Sword("장검",3,150,100,70);

		//할아버지형 리스트에 손자,아들,본인 다 넣을수 있음. (상속의 중요 특성)
		ArrayList<GameObj> gs = new ArrayList<>();
		gs.add(c);
		gs.add(s);
		gs.add(l);
		for(GameObj o : gs) {
			Cw.Wn(o.name);
			o.info();
		}
		}
	
}

