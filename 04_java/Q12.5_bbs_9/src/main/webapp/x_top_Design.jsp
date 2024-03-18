<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DatabaseMetaData"%>
<!-- 이 import 문 추가 -->
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/CSS/common.css?ver=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div id="top">
			<div id="logoMOD">
				<img alt="logo" src="/img/logo.png">
			</div>
			<div id="navMOD">
				<nav>
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</nav>
			</div>
			<div id="toolbar_login">로그인</div>
			<div id="toolbar_join">회원가입</div>
		</div>
</body>
</html>