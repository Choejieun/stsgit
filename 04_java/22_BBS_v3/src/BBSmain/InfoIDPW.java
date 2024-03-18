package BBSmain;

import uitn.Color;
import uitn.Cw;
import uitn.Material;

public class InfoIDPW {



	public static String NameUse = null;

	@SuppressWarnings("null")
	static void run() {
		String IDjoin;
		String PWjoin;
		String Namejoin = null;
		loop_start: while (true) {
			boolean x = false;
			Material.line();
			String login = String.format("%22s", "[1] 로그인"); // 글자를 꾸미는 방법, 숫자열은 %d 사용
			String join = String.format("%22s", "[2] 회원가입"); // 글자를 꾸미는 방법, 숫자열은 %d 사용
			String out = String.format("%22s", "[3] 실행종료"); // 글자를 꾸미는 방법, 숫자열은 %d 사용
			Cw.Wn(Color.RED + login + Color.EXIT);
			Cw.Wn(Color.CYAN + join + Color.EXIT);
			Cw.Wn(Color.YELLOW + out + Color.EXIT);
			Material.line();
			String cmd = InputS.r("명령");
			switch (cmd) {
			case "1": // 1번 선택지 시작

				String ID;
				
				if (Data.idpw.size() > 0) {
				while (true) {
					ID = InputS.rr("ID");
					if (ID.length() > 0) { // 글자열 수 비교
						break;
					} else {
						Cw.Wn("아이디를 입력해주세요.");
					}
				}

				String PW;
				while (true) {
					PW = InputS.rr("PW");
					if (PW.length() > 0) { // 글자열 수 비교
						break;
					} else {
						Cw.Wn("비밀번호를 입력해주세요.");
					}
				}
 
				
					for (InfoIDPWjoin a : Data.idpw) { // ..class a를 기준으로 하는 데이터가 저장된 idpw 배열의 size만큼 get한다.
						if (ID.equals(a.IDjoinSave) && PW.equals(a.PWjoinSave)) { // 유저에게 받은 ID에 저장된 데이터 비교문
							x = true;
							continue;
						}
					}
					if (x == true) {
						 NameUse = Namejoin;
						Bbs.run();
					} else {
						Cw.Wn("아이디 혹은 패스워드가 틀렸습니다.");
						break;
					}
				} else {
					Cw.Wn("생성된 아이디가 없습니다.");
					break;
				}

				break; // 1번 선택지 끝
			case "2": // 2번 선택지 시작

				loop_a: while (true) { // 선택화면 복귀 용
					Material.line();

					while (true) {
						IDjoin = InputS.rr("ID");

						if (IDjoin.matches("[a-z0-9 ]+")) {
							if (IDjoin.contains(" ")) {
								Cw.Wn("공백이 포함된 Id는 저장할 수 없습니다.");
							} else {
								if (IDjoin.length() > 0) { // 글자열 수 비교
									break;
								} else {
									Cw.Wn("아이디를 입력해주세요.");
								}
							}
						} else {
							Cw.Wn("영문 소문자와 숫자만 입력하세요.");
						}

					}

					while (true) {
						PWjoin = InputS.rr("PW");

						if (PWjoin.matches("[a-zA-Z]+[!@#$%^&*()_+=<>?]+")) {
							if (PWjoin.contains(" ")) {
								Cw.Wn("공백이 포함된 pw는 저장할 수 없습니다.");
							} else {
								if (PWjoin.length() > 0) { // 글자열 수 비교
									break;
								} else {
									Cw.Wn("패스워드를 입력해주세요.");
								}
							}
						} else {
							Cw.Wn("영문과 특수문자 1개 이상을 표함하여 입력하세요.");
						}
					}
					
					while (true) {
						Namejoin = InputS.rr("닉네임");
						if (Namejoin.contains(" ")) {
							Cw.Wn("공백이 포함된 닉네임은 저장할 수 없습니다.");
						} else {
							if (Namejoin.length() > 0) { // 글자열 수 비교
								break;
							} else {
								Cw.Wn("닉네임을 입력해주세요.");
							}
						}
					}
					
					for (int i = 0; i < Data.idpw.size(); i++) {
						if (IDjoin.equals(Data.idpw.get(i).IDjoinSave + "")) { // 앞서 받은 IDjoin이 idpw에 등록된 IDjoinSave
																				// 동일한지 검사
							Cw.Wn("중복된 아이디입니다. 다시 시도해주세요");
							break loop_a;
						} else if (PWjoin.equals(Data.idpw.get(i).PWjoinSave + "")) {
							Cw.Wn("중복된 패스워드입니다. 다시 시도해주세요");
							break loop_a;
						} else if (Namejoin.equals(Data.idpw.get(i).NamejoinSave + "")) {
							Cw.Wn("중복된 닉네임입니다. 다시 시도해주세요");
							break loop_a;
						}
						
					}
					InfoIDPWjoin p = new InfoIDPWjoin(IDjoin, PWjoin,Namejoin);
					Data.idpw.add(p);
					Cw.Wn("회원가입 완료");
					break loop_a;

				}
				break; // 2번 선택지 끝
			case "3":
				Material.endC();
				break loop_start;

			}
		}

	}
}