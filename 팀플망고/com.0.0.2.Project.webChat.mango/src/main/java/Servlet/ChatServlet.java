package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginDB.L_Dao;
import LoginDB.L_Db;
import LoginDB.L_Dto;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static void start() {
		try {
			Class.forName(L_Db.DB_LINK);
			con = DriverManager.getConnection(L_Db.DB_URL, L_Db.DB_ID, L_Db.DB_PW);
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		L_Dto idCk = new L_Dto(id, pw);
		if (L_Dao.login(idCk)) {
			String sql = String.format("SELECT * FROM login WHERE id = '%s' AND pw = '%s'", id, pw);
			try {
				start();
				rs = st.executeQuery(sql);
				rs.next();
				session.setAttribute("userNo", rs.getString("userNo"));
				session.setAttribute("userName", rs.getString("userName"));
				session.setAttribute("userTag", rs.getString("userTag"));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}
	
	
}
