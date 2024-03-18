package LoginDB;

public class L_Db {
	public static final String DB_LINK =  "com.mysql.cj.jdbc.Driver";
	public static final String DB_NAME = "chat";
	public static final String DB_SQL_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
	public static final String DB_URL = DB_SQL_URL;
	public static final String DB_ID = "root";
	public static final String DB_PW = "root";
	public static final String DB_TABLE = "login"; // 이건 테이블명에 따라 변경됨
}