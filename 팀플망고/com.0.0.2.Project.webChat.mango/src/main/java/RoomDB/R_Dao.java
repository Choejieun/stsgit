package RoomDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class R_Dao extends R_Db {

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static ArrayList<R_Dto> roomList;
	private static ArrayList<String> roomNo;

	private static void start() {
		try {
			Class.forName(DB_LINK);
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void close() {
		try {
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void create(String userNo,String roomName, String roomStat) { // 방 만들기
		chatroom(userNo,roomName,roomStat); // 채팅창 정보 생성, 유저 넘버, 설정한 채팅이름, 채팅창 노출 여부 등
		String roomNo = roomNo(userNo); // 채팅창 넘버 구하는함수
		chatJoin(userNo,roomNo); // 채팅창 넘버와 유저 넘버를 묶어서 연관시키는 함수
	}

	private static void chatroom(String userNo, String roomName,String roomStat) { // 채팅방 정보 생성 <-- 첫번째
		String sql = String.format("INSERT INTO %s(bossNo,roomName,roomStat,userMax)values(%s,'%s',0,10)", DB_TABLE,userNo,roomName,roomStat);
		// 공개 비공개 or 최대인원수는 임시로 지정해줌
		try {	
			start();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	private static String roomNo(String userNo) {
		String sql = String.format("SELECT MAX(roomNo) FROM %s WHERE bossNo = %s",DB_TABLE,userNo); 
		// 가장 마지막에 만들어진게 바로전에 INSERT 해준 값이기 때문에 MAX 로 값을 구해줌, 유저넘버가 들어간이유는 혹시라도 동시에 방만드는경우가 생길까봐
		String re = null;
		try {
			start();
			rs = st.executeQuery(sql);
			rs.next();
			re = rs.getString("MAX(roomNo)"); 
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return re;
	}
	
	private static void chatJoin(String userNo,String roomNo) { // 두번째
		String sql = String.format("INSERT INTO chatjoin(userNo,roomNo)values(%s,%s)", userNo,
				roomNo);
		// 채팅넘버와 유저 넘버 연관시켜줌
		try {
			start();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
