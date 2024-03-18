package grandfather;

import java.util.ArrayList;

import Cw.Cw;

public class Main {

	public static void main(String[] args) {
		// 게임 오브젝트들 로딩
		GameObj n = new GameObj();
		
		//형변환 (type 변환)
		//부모-자식 간 관계인, Character Class가 GameObj로 바뀌었다.
		//Character Class가 고유로 부여받은 필드가 작동하지 않는다.
		//부모 class로 변해있기에 자식(유치)스러운 행동은 못함
		GameObj p = new Character("고양이",3,100);

		//형변환 해제 명령어
		Character cc = (Character)p;
		// ★ why? 부모 계층의 조건문에서 데이터를 받아오거나 참여가 가능
		
		
		Character c = new Character("고양이",3,100);
		
		Sword s = new Sword("단검",2,100,50,70);
//		GameObj s = new Sword("단검",2,100,50,70);

		Sword l = new Sword("장검",3,150,100,70);

		//할아버지형 리스트에 손자,아들,본인 다 넣을수 있음. (상속의 중요 특성)
		ArrayList<GameObj> gs = new ArrayList<>();
		gs.add(c);
		gs.add(s);
		gs.add(l);
		for(GameObj o : gs) {
			if( o instanceof Sword) {   // 할아버지(최대부모)를 기준으로 하되 그 이하에 해당 class가 있다면 그것만 참
			Cw.Wn(o.name);
			o.info();}
		}

		s.slash();
		
		}
	
}

