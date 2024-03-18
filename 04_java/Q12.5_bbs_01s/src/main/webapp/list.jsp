<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="common.css">
<meta charset="UTF-8">
<title>게시판 - 글 리스트</title>
</head>
<body>

<hr>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_1", "root", "root");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from main_board;");
	
	while(rs.next()){
		String no = rs.getString("num");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		%>
		
		[<%=no %>] <%=title %> <%=content %> <%=id %> <br>
		
		<% 
	}
	
} catch (Exception e) {		
e.printStackTrace();
}	
%>

</body>
</html>