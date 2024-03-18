package ChatDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import LoginDB.L_Db;

public class C_Dao extends C_Db {

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	
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
	

	public ArrayList<C_Dto> chattingList(String roomNo) {
		ArrayList<C_Dto> list = new ArrayList<C_Dto>();
		String roomName = DB_TABLE + roomNo;
		String sql = String.format("SELECT * FROM %s ",roomName);
		try {
			
			start();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new C_Dto(rs.getString("userNo"), rs.getString("chat"),rs.getString("time")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
	public String name(String userNo,String query) {
		String sql = String.format("SELECT * FROM %s WHERE userNo = %s",L_Db.DB_TABLE,userNo);
		String a = null;
		try {
			start();
			 rs = st.executeQuery(sql);
			rs.next();
			a = rs.getString(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return a;
	}

	public static void chatting(String roomNo, String chat,String userNo) {
		String roomName = DB_TABLE + roomNo;
		String newChat=null;
		if(chat.matches("'")) {
			newChat = chat.replace("'","~");			
		}else {
			newChat = chat;
		}
		
		
		String sql = String.format("INSERT INTO %s(userNo,chat)VALUES(%s,'%s')",roomName,userNo,newChat);
		System.out.println(sql);
		try {
			start();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public static String chatName(String no) {
		start();
		String sql = String.format("SELECT * FROM %s WHERE userNo = "+no,L_Db.DB_TABLE);
		String name = null;
		try {
		rs = st.executeQuery(sql);
		rs.next();
		name = rs.getString("userName");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return name;
	}
	public static String chatTag(String no) {
		String sql = String.format("SELECT * FROM %s WHERE userNo = "+no,L_Db.DB_TABLE);
		String tag = null;
		try {
			start();
			rs = st.executeQuery(sql);
			rs.next();
			tag = String.format(rs.getString("userTag"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return tag;
	}
	
}
