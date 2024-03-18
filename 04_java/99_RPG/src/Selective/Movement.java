package Selective;

import java.io.IOException;
import java.util.Set;

import Maps.MapOPj;
import Maps.Maps;
import Maps.Village;
import uitn.Cw;
import uitn.InputS;
import uitn.Material;

public class Movement {
static public void run() {
	boolean T = false;
	Set<String> keys = Village.hs.keySet();
	int index = 1;
	for (String key : keys) {
        System.out.println(" ["+ index +"] " + key);
        index++;
    }
	Material.line();
	Village.hs.put("이동실패","0");	
    String cmd = InputS.r("이동할 마을을 말하시오");
	for (String ccc : keys) {
		if(ccc.equals(cmd)) {
			T = true;
		}
	}
		if (T==true) {
			String A = Village.getVillageName(cmd);
		    Village.movePoint = A;
		    Village.run(); // 여기서 movePoint 값을 설정한 후 run 메서드 호출
		}
		if(T==false) {
			Maps.run();
			Cw.Wn("이동에 실패 했다.");
			Maps.Mscanner();
			Village.hs.remove("이동실패");
			MapOPj.run();
		}
	
	
}


}
