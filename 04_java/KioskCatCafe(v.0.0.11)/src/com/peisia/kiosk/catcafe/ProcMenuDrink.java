package com.peisia.kiosk.catcafe;

import com.peisia.kiosk.catcafe.product.Drink;
import com.peisia.kiosk.catcafe.product.Product;
import com.peisia.util.Cw;

public class ProcMenuDrink {
	
	public static void run() {
													//배열에 상품이 있는 상태
		for(Product p:KioskObj.products) {	//메뉴출력 v.0.0.11
			if(p instanceof Drink) {	//메뉴 출력을 이쪽 계열 상품만 출력 처리
				// instanceof(정체가 뭐냐) 뒤에오는 class의 본모습(자신 class) // 트루 리턴
				
//				products.add(new Drink("커피",1000));	////	상품목록 처리	////
				// 								형변환
				
				
				Cw.wn(p.name+" "+p.price +"원");
			}
		}
		yy:while(true) {
			
			Cw.wn("[1.커피/2.오렌지쥬스/x.이전메뉴로]");
			KioskObj.cmd = KioskObj.sc.next();
			switch(KioskObj.cmd) {
			case "1":
				ProcMenuOptionHotCold.run();
				break;
			case "2":
				Cw.wn(KioskObj.products.get(1).name+" 선택됨");
				KioskObj.basket.add(new Order(KioskObj.products.get(1)));	//오더 추가
				break;
			case "x":
				Cw.wn("이전 메뉴 이동");
				break yy;
			}
		}
	}
}