package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.db.Dao;

@WebServlet("/Xxx_del")
public class Xxx_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding("UTF-8"); 
	    String num = request.getParameter("num");

	    Dao cat = new Dao();
	    cat.del(num);

	    response.sendRedirect("list.jsp");
	    System.out.println("삭제로그----------------------");

	}

}
