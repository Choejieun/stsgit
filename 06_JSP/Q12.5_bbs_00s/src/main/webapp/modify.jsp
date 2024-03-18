<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글 수정하기</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<div id ="a">
<%
//파라미터를 통해 데이터 받기
	String num = request.getParameter("num");
	String title = null;
	String id = null;
	String content = null;

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
		Statement st = con.createStatement();
		
		String sql = "select * from cat_board where num = "+num+";";
		ResultSet rs = st.executeQuery(sql);	// 수정 할 글 하나 읽기 sql 전송
		rs.next();	// 글 선반에서 글 하나 꺼내서 작업대에 올리기.
		title = rs.getString("title");
		id = rs.getString("id");
		content = rs.getString("content");
		System.out.println("==== 전송하려는 sql:" + sql);		
		int resultCount = st.executeUpdate(sql);	// 글쓰기 sql 전송
		if(resultCount == 1){
			System.out.println("==== 글삭제 성공");
		} else {
			System.out.println("==== 글삭제 실패");
		}
	} catch (Exception e) {		
		e.printStackTrace();
	}
%>
<hr>
<form action="modifyproc.jsp" method="get">
	<input type="hidden" name="num" value="<%=num%>"><br>
	글제목:<input name="title" value="<%=title%>"><br>
	글작성자id:<input name="id"  value="<%=id%>"><br>
	글내용:<textarea name="content" rows="5" cols="50"><%=content %></textarea>
	<input type="submit" value="글쓰기">
</form>

</div>
</body>
</html>