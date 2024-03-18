package Item_Public;

import java.sql.SQLException;

public class MakingTHEWorld {
	// 유저 초기 아이템 지급
	static public void Basic_item_payment() throws SQLException {
		V_0_Techo.Basic_item_payment();  //태초마을 아이템 로드
		V_1_Babo.Basic_item_payment(); //바보마을 아이템 로드
		V_2_GOODV.Basic_item_payment(); //무한마을 아이템 로드
	}
}
