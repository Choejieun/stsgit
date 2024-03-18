package Main;

import Maps.MapOPj;
import Maps.Maps;
import uitn.InputS;
import uitn.Material;

public class First {
static public void run() {
	
//todo 시작 종료 제작 [완료 0.0.0]
	loop_start:
	while (true) {
		Material.title(); // 제목출력
		String cmd = InputS.r("명령");
		
		switch (cmd) {
		case "1":
			Maps.run();
			MapOPj.run();
			break;

		case "2":
			Material.endC(); // 제목출력
			break loop_start;
		}
	}
	
}} //run
