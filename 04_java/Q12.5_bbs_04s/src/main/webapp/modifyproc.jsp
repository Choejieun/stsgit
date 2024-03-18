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
String num = request.getParameter("num");
String topick = request.getParameter("topick");
String title = request.getParameter("title");
String id = request.getParameter("id");
String content = request.getParameter("content");
System.out.println(title);
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_2", "root", "root");
	Statement st = con.createStatement();
	String sql = "update main_board_2 set title = '"+title+"', id = '"+id+"', content = '"+content+"', datatime = now(), topick = '"+topick+"' where num = "+num+";";

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
%>