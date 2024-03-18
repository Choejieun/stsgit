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
<title>글 수정하기</title>
</head> 
<body>
<%request.setCharacterEncoding("UTF-8"); %>
	<div id="warp">
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
		<div id="mid">
			<div id="left">
				따봉 강아지 <img alt="멍멍이" src="/img/배너멍멍이.jpg" width="100%">
			</div>
			<div id="main">
				<h1>함께 할 때 더 즐거운 순간</h1>
		<div id="text"><strong>[공백]</strong> 님 지식공유 플랫폼 OKKY에서 다양한 사람을 만나고 생각의 폭을 넓혀보세요.</div>	

<%
Dto dto = (Dto)request.getAttribute("post");	//글 가져오기
String topick = request.getParameter("topick");
%>

<form action="/board/modify_edit" method="post">
<input type="hidden" name="topick" value="<%=topick%>">
<input type="hidden" name="num" value="<%=dto.num%>">
토픽<br>
<select name="topick_new" class="inputvalue">
<option value ="<%=topick%>"><%=topick%></option>
<option value ="lite">사는얘기</option>
<option value ="gathering">모임&스터디</option>
</select><br>
제목<br>
	<input name="title" value="<%=dto.title %>" class="inputvalue2"><br>
아이디<br>
	<input name="id" value="<%=dto.id %>" class="inputvalue2"><br>
내용<br>
	<textarea rows="20" cols="130" name="content" class="textarea"><%=dto.content %></textarea><br>
	<input type="submit" value="수정완료">
</form>

			</div> 
<!-- 			메인끝 -->
			<div id="right">
				따봉 강아지 <img alt="멍멍이" src="img/배너멍멍이.jpg" width="100%">
			</div>
		</div>
	</div>
</body>
</html>