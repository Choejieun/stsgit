package Selective;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Main.ProcBoard;

public class ItemOP {
	Connection con = null;
	Statement st = null;
	ResultSet result = null;
	
	static public void bag() {
		ProcBoard procBoard = new ProcBoard();
		procBoard.runbag();
		
		}
		
	static public void shop() {
		ProcBoard procBoard = new ProcBoard();
		procBoard.runshop();
		
		}
}
