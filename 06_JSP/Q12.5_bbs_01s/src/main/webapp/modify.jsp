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
<title>게시판 - 글 수정하기</title>
</head>
<body>
	<div id="main">
		<%
		String num = request.getParameter("num"); //a href 를 통해 전달받음
		String title = null;
		String content = null;
		String id = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_1", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from main_board where num =" + num + ";");
			
			if(rs.next()){
				title = rs.getString("title");
				content = rs.getString("content");
				id = rs.getString("id");
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		%>
		<form action="modifyproc.jsp" method="get">
		<input type="hidden" name="num" value="<%=num%>">
			<div id="bbs_write">
				<div class="bbs_write_title">제목</div>
				<input type="text" name="title" value="<%=title%>" class="custom-width">
			</div>
			<div id="bbs_write">
				<div class="bbs_write_title">작성자</div>
				<input type="text" name="id" value="<%=id%>" class="custom-width">
			</div>
			<hr>
			<textarea rows="10" cols="102" name="content"><%=content%></textarea>
			<br> <input type="submit" value="글 수정 완료" id="bbs_submit">
		</form>
	</div>
</body>
</html>