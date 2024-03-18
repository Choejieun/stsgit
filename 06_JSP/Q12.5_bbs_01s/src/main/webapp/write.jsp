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
<title>게시판 - 글 쓰기</title>
</head>
<body>
	<div id="main">
		<form action="writeproc.jsp" method="get">
		<div id ="bbs_write">
			<div class="bbs_write_title">제목</div><input type="text" name="title" class="custom-width">
		</div>
		<div id ="bbs_write">
			<div class="bbs_write_title">작성자</div><input type="text" name="id" class="custom-width">
		</div>
		<hr>
			<textarea rows="10" cols="102" name="content"></textarea>
			<br> <input type="submit" value="글작성 완료" id="bbs_submit">
		</form>
	</div>
</body>
</html>