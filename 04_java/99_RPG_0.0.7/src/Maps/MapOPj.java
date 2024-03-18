package Maps;

import java.io.IOException;

import Main.First;
import Selective.ItemOP;
import Selective.Movement;
import uitn.Cw;

public class MapOPj {

	static public void run() {
		Data p = new Data();
		Data.Datalode();
		System.out.println("  [   W,A,S,D 로 이동하세요   ]   ");
		Cw.Wn("[1] 텔레포트  |  [2] 인벤토리  | [SP] 뒤로가기");
		try {
			loop:
			while (true) { 
				if(Data.VillageCome == true) { //마을 도착 이후 좌표값 상승 X
				int input = System.in.read(); // 현재 키보드 입력 값이 숫자로 변환된 상태
				boolean Sysread = input >= 97 && input <= 122;
				boolean Sysread2 = input >= 50 && input <= 57 && input == 48;
				if (Sysread == true || Sysread2 == true) {
					Cw.Wn("대문자 영문만 사용 가능합니다.");
				}
				
				if (input == 49) {
					Movement.run();
				}
				if (input == 50) {
					ItemOP.bag();
				}

				if (input == 65) {
					p.x_UP();
					Maps.run();
					if (Data.GOGO == true) {
						Maps.Mscanner();
						MapOPj.run();
					} else {
						p.x_DW();
					}
				} // A

				else if (input == 87) {
					p.y_UP();
					Maps.run();
					if (Data.GOGO == true) {
						Maps.Mscanner();
						MapOPj.run();
					} else {
						p.y_DW();
					}
				} // "W"

				else if (input == 83) {
					p.y_DW();
					Maps.run();
					if (Data.GOGO == true) {
						Maps.Mscanner();
						MapOPj.run();
					} else {
						p.y_UP();
					}
				} // "S"

				else if (input == 68) {
					p.x_DW();
					Maps.run();
					if (Data.GOGO == true) {
						Maps.Mscanner();
						MapOPj.run();
					} else {
						p.x_UP();
					}
				} // "D"
					// '스페이스바'를 입력하면 프로그램을 종료합니다.
				if (input == 32) {
					First.run();
					break loop;
				}
			}}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}// run
