package com.peisia.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db {

	static public String DB_JDBC_DRIVER_PACKAGE_PATH = "com.mysql.cj.jdbc.Driver";	//mysql
	
	static private String DB_NAME = "bbs_3";
	static private String DB_URL_MYSQL = "jdbc:mysql://localhost:3306/"+DB_NAME;	//mysql
	static public String DB_URL = DB_URL_MYSQL;	//디비 바뀌면 여기 바꾸시오.
	static public String DB_ID = "root";
	static public String DB_PW = "root";
	
	/* table들 */
	////	게시판
	public static final String TABLE_PS_BOARD_FREE = "main_board_3";	//자유게시판
	
	static public Connection con = null;
	static public Statement stmt = null;
	static public ResultSet rs = null;
	static public int result = 0;
}
