package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement; // Statement 클래스를 import 추가

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Xxx_write")
public class Xxx_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		String topick = request.getParameter("topick");
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_3", "root", "root");
			Statement st = con.createStatement();
			String sql = "INSERT INTO main_board_3 (title, id, content, datatime, topick) VALUES ('" + title + "', '" + id + "', '" + content + "', NOW(), '" + topick + "')";
		} catch (Exception e) {		
		e.printStackTrace();
		}	

		response.sendRedirect("list.jsp");
	}
}
