<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.peisia.db.Dto"%>
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/CSS/common.css">
<meta charset="UTF-8">
<title>글 읽기</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
					<%
					Dto r = (Dto)request.getAttribute("post");
					String topick = request.getParameter("topick");
					%>
	<div id="warp">
		<jsp:include page="x_top_Design.jsp"></jsp:include>
		<div id="mid">
		<jsp:include page="x_left_Design.jsp"></jsp:include>
			<div id="main">
				<img alt="중앙" src="/img/mid.png" width="100%"> <br>
			<div id="c"><div id="hr_1"></div><a href="/board/list?topick=<%=r.topick%>">&nbsp;커뮤니티&nbsp;</a><div id="hr_2"></div></div>
				<div id="bbs">
<div id = "user">
<img alt="/" src="/img/배너멍멍이.jpg">
					<div class="idbox">
					<a href="#"><%=r.id%></a> <br>
					<%=r.datatime%><br>
					</div>
					<div class="box">
					<div class="icon"><img alt="#" src="/img/퍼가기.png" width="100%"></div>
					<div class="icon"><img alt="#" src="/img/퍼가기.png" width="100%"></div>
					</div>
</div>					
					<h1><%=r.title%></h1>
					<div id="text">
					<%=r.content%>
					</div>
					<%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%><%=r.num%>
					
					<a href="/Xxx_del?num=<%=r.num%>">삭제하기</a>
					<a href="/board/modify?num=<%=r.num%>&topick=<%=r.topick%>">수정하기</a>
					<br>
			<img alt="#" src="/img/notbot.png">		
				</div>
				<div id="bottom">
<!-- 				하단 -->
				</div>
			</div>
			<jsp:include page="x_right_Design.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>