package BBSmain;

import java.util.Scanner;

import uitn.Color;
import uitn.Cw;
import uitn.Material;

public class ProcMenudel {

	static void run() {
		Scanner sc = new Scanner(System.in);
		Color.cyan("삭제할 번호를 입력해주세요");

		try {	// 트라이캐치로 오류를 잡아간다.
			int cmd = sc.nextInt(); // 숫자를 입력 받는 메서드
			int searchIndex = 0; // 인덱스를 세는 필드

			if (Post.no >= cmd) { // 아래 전문은 Post.no가 cmd와 같거나 크면 실행된다.
				Post.no--; // 총 작성된 게시글 수를 1 줄인다.

				if (cmd < Data.posts.size()) { // 만약 cmd가 posts.size(배열의 수) 미만이라면
					for (int i = Data.posts.get(cmd).noSetup - 1; i < Data.posts.size(); i++) {
						// i = (index +1 = cmd).noSetup -1; == index (표시상 고른 cmd와 index 수를 맞추는 식)
						/*
						 * noSetup만 보고 cmd를 지정하면 index보다 1이 많은 상태로 지정이 되기에, 처음에 목표로한 noSetup에서 -1 하면 된다.
						 */// i < index _ i가 index를 초과하면 작동을 멈춘다.
						System.out.println(i);
						Data.posts.get(i).noSetup--;
						// noSetup의 수를 1 감소 시키는 반복문은 i 보다 큰 모든 index에 적용한다.

					}
				} // cmd 미만식 종료

				for (int i = 0; i < Data.posts.size(); i++) {
					if (cmd == Data.posts.get(i).noSetup) { // cmd == index=oSetup인 상태에서 탐색한다.
						searchIndex = i;
						break;
					}
				}
				Color.red("제거하였습니다 : " + Data.posts.get(searchIndex).title);
				Data.posts.remove(searchIndex); // cmd와 동일한 noSetup를 제거한다.
				Color.cyan("글 수 : " + Data.posts.size());

			} // no > 0 종료
			else {
				Material.line();
				Cw.Wn("삭제할 글이 없습니다.");
				Material.line();
			}
		} catch (Exception e) {
			Material.line();
			Cw.Wn("숫자를 입력해주세용~");
			Material.line();
		}
	}
}