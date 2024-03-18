package Item_Public;

import java.sql.SQLException;

import Main.ProcBoard;
import Maps.Data;

public class V_2_GOODV { //무한의마을 아이템 로드
	// 유저 초기 아이템 지급
	static public void Basic_item_payment() {
	try {
	String OPRPG_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
	/*제목*/		+ "'2억 오픈 월드 RPG', "
	/*설명*/		+ "'RPG? 그게 뭐지',	"
	/*갯수*/		+ "1,			"
	/*비용*/		+ "1000,			"
	/*매장*/		+ "'2',		"			//0태초 1바보 2무한
	/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
	+ ");"); ProcBoard.st.executeUpdate(OPRPG_item_p);
	
	String CantDEL_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
	/*제목*/		+ "'캐삭빵 면제권', "
	/*설명*/		+ "'캐삭이 되지 않는다.',	"
	/*갯수*/		+ "1,			"
	/*비용*/		+ "10000,			"
	/*매장*/		+ "'2',		"			//0태초 1바보 2무한
	/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
	+ ");"); ProcBoard.st.executeUpdate(CantDEL_item_p);

	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}


