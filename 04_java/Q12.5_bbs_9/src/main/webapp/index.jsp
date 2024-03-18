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
<link rel="stylesheet" href="/CSS/index.css">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%  	request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<div id="warp">

<form action="/Controller_Login/login" method="post">
<input type="text" name="ID" placeholder="아이디 입력">
<input type="password" name="PW" placeholder="비밀번호 입력">
<input type="submit" value="로그인">
</form>


<form action="join.jsp" method="post">
<input type="submit" value="회원가입">
</form>

</div>
</body>
</html>