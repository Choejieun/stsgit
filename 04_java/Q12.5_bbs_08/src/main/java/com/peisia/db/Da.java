package com.peisia.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Da {
	protected Connection con=null;
	protected Statement st = null;
	protected void connect() {
		try {
			////고정 1
			Class.forName(Db.DB_JDBC_DRIVER_PACKAGE_PATH);
			////고정 2
			con = DriverManager.getConnection(Db.DB_URL, Db.DB_ID, Db.DB_PW);			
			////고정 3
			st=con.createStatement();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void update(String sql) {
		try {
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void close() {
		try {
			////고정 4
			st.close();
			////고정 5
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void Number_check() {
		connect();
		try {
			// I_NO 열이 존재하는지 확인
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "main_board_3", "num");
			if (columns.next()) {
				// I_NO 열이 존재하면 삭제
				String dropAutoIncrementColumnQuery = "ALTER TABLE main_board_3 DROP COLUMN num;";
				st.executeUpdate(dropAutoIncrementColumnQuery);
			}
			// 새로운 열 추가
			String addAutoIncrementColumnQuery = "ALTER TABLE main_board_3 ADD COLUMN num INT AUTO_INCREMENT PRIMARY KEY;";
			st.executeUpdate(addAutoIncrementColumnQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(); // [고정4,5]
	}
	
}
