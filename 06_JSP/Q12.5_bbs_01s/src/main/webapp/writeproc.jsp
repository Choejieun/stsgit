<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String title = request.getParameter("title");
	String id = request.getParameter("id");
	String content = request.getParameter("content");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_1", "root", "root");
		Statement st = con.createStatement();
		
		String sql = "insert into main_board (num, title, content, id) values("
		+"0"+",'"+title+"','"+content+"','"+id+"');";
		
		System.out.println("==== 전송하려는 sql: " + sql);		
		int resultCount = st.executeUpdate(sql);	// 글쓰기 sql 전송 ,업데이트
		if(resultCount == 1){
			System.out.println("==== 글쓰기 성공");
		} else {
			System.out.println("==== 글쓰기 실패");
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	response.sendRedirect("list.jsp");	// 글리스트 화면으로 강제 이동
	%>