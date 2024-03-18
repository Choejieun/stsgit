package BackEnd;

import java.sql.SQLException;

import Main.ProcBoard;
import Maps.Data;

public class MakingTHEWorld {
	// 유저 초기 아이템 지급
	static public void Basic_item_payment() {
		try {
			String RedPotion_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
			/*제목*/		+ "'빨간 포션', "
			/*설명*/		+ "' ',	"
			/*갯수*/		+ "100,			"
			/*비용*/		+ "0,			"
			/*매장*/		+ "'0',		"			//0태초 1바보 2무한
			/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
			+ ");"); ProcBoard.st.executeUpdate(RedPotion_item_p);
			
			String bulePotion_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
			/*제목*/		+ "'파란 포션', "
			/*설명*/		+ "' ',	"
			/*갯수*/		+ "100,			"
			/*비용*/		+ "0,			"
			/*매장*/		+ "'0',		"			//0태초 1바보 2무한
			/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
			+ ");"); ProcBoard.st.executeUpdate(bulePotion_item_p);
			
			String FreeNoodle_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
			/*제목*/		+ "'입짧은 달님 계란기름 라면', "
			/*설명*/		+ "'달짝찌근한 라면, 맛이 정말 좋다. 공짜로 드립니다',	"
			/*갯수*/		+ "2,			"
			/*비용*/		+ "0,			"
			/*매장*/		+ "'1',		"			//0태초 1바보 2무한
			/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
			+ ");"); ProcBoard.st.executeUpdate(FreeNoodle_item_p);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
