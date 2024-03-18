package Item_Public;

import java.sql.SQLException;

import Main.ProcBoard;
import Maps.Data;

public class V_0_Techo {  //태초마을
	// 유저 초기 아이템 지급
		static public void Basic_item_payment() {
			try {
				String RedPotion_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
				/*제목*/		+ "'빨간 포션', "
				/*설명*/		+ "'먹으면 힘이 나는 빨간 포션',	"
				/*갯수*/		+ "100,			"
				/*비용*/		+ "0,			"
				/*매장*/		+ "'0',		"			//0태초 1바보 2무한
				/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
				+ ");"); ProcBoard.st.executeUpdate(RedPotion_item_p);
				
				String bulePotion_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
				/*제목*/		+ "'파란 포션', "
				/*설명*/		+ "'먹으면 힘이 나는 파란 포션',	"
				/*갯수*/		+ "100,		"
				/*비용*/		+ "0,			"
				/*매장*/		+ "'0',		"			//0태초 1바보 2무한
				/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
				+ ");"); ProcBoard.st.executeUpdate(bulePotion_item_p);
				
				String Father_in_law_item_p = String.format("insert into item (I_NAME, I_TEXT, I_INT,I_MONEY,I_MY,I_FIELD) value("
				/*제목*/		+ "'장인어른', "
				/*설명*/		+ "'결혼도 안 하고 결혼한 듯한 답답한 분위기를 내보세요',	"
				/*갯수*/		+ "1,		"
				/*비용*/		+ "0,			"
				/*매장*/		+ "'0',		"			//0태초 1바보 2무한
				/*주인*/		+ "'"+Data.Main_C_NAME+"'		"
				+ ");"); ProcBoard.st.executeUpdate(Father_in_law_item_p);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
