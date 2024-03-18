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
@WebServlet("/Xxx_modify")
public class Xxx_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	   
	    String num = request.getParameter("num");
	    String topick = request.getParameter("topick");
	    String title = request.getParameter("title");
	    String id = request.getParameter("id");
	    String content = request.getParameter("content");
	    System.out.println(title);
	    try{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_3", "root", "root");
	    	Statement st=con.createStatement();
	    	String sql = "update main_board_3 set title = '"+title+"', id = '"+id+"', content = '"+content+"', datatime = now(), topick = '"+topick+"' where num = "+num+";";
	        int result = st.executeUpdate(sql);
	    	System.out.print("실행문 : "+sql);
	    	
	    	if(result == 1){
	    		System.out.print("글수정 성공");
	    	}else{
	    		System.out.print("글수정 실패");
	    	}
	    	
	    } catch (Exception e) {		
	    e.printStackTrace();
	    }	

	    response.sendRedirect("list.jsp");
		
		
	}


}
