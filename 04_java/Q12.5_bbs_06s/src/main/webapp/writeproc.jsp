<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
<%
String topick = request.getParameter("topick");
String title = request.getParameter("title");
String id = request.getParameter("id");
String content = request.getParameter("content");
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_3", "root", "root");
	Statement st = con.createStatement();
	String sql = "INSERT INTO main_board_3 (title, id, content, datatime, topick) VALUES ('" + title + "', '" + id + "', '" + content + "', NOW(), '" + topick + "')";

    int result = st.executeUpdate(sql);
	System.out.print("실행문 : "+sql);
	
	if(result == 1){
		System.out.print("글작성 성공");
	}else{
		System.out.print("글작성 실패");
	}
	
} catch (Exception e) {		
e.printStackTrace();
}	

response.sendRedirect("list.jsp");
%>