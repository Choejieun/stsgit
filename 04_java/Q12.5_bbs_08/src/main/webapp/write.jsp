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
<title>글 쓰기</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
	<div id="warp">
		<jsp:include page="x_top_Design.jsp"></jsp:include>
		<div id="mid">
			<jsp:include page="x_left_Design.jsp"></jsp:include>
			<div id="main">
				<h1>함께 할 때 더 즐거운 순간</h1>
				<div id="text">
					<strong>[공백]</strong> 님 지식공유 플랫폼 OKKY에서 다양한 사람을 만나고 생각의 폭을 넓혀보세요.
				</div>

				<form action="/board/write" method="post">
				<input type="hidden" name="old" value="desc">
					토픽
					<br> <select name="topick_new" class="inputvalue">
						<option value="free">토픽을 선택해주세요</option>
						<option value="lite">사는얘기</option>
						<option value="gathering">모임&스터디</option>
					</select>
					
					<br> 제목<br> <input name="title" value="title" class="inputvalue2">
					<br> 아이디<br> <input name="id" value="id" class="inputvalue2">
					<br> 내용<br>
					<textarea rows="20" cols="130" name="content" class="textarea"></textarea>
					
					<br> <input type="submit">
				</form>

			</div>
			<!-- 			메인끝 -->
			<jsp:include page="x_right_Design.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>