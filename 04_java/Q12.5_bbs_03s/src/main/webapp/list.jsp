<!-- 자바연결 -->
<%@page import="com.peisia.db.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dao"%>
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
<link rel="stylesheet" href="common.css">
<meta charset="UTF-8">
<title>커뮤니티</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<%
	int num = 0;
	%>
	<div id="warp">
		<jsp:include page="top_Design.jsp"></jsp:include>
		<div id="mid">
			<jsp:include page="left_Design.jsp"></jsp:include>
			<div id="main">
				<img alt="중앙" src="img/mid.png" width="100%"> <br>
				<div id="title">
					<h1>커뮤니티</h1>
					다양한 사람을 만나고 생각의 폭을 넓혀보세요.
				</div>
				<div id=toolbar>
					<div id="toolbar_write">
						<a href="write.jsp">✔작성하기</a>
					</div>
					<nav>
						<ul>
							<li><a href="#">사는얘기</a></li>
							<li><a href="#">모임&스터디</a></li>
							<li><a href="#">전체</a></li>
						</ul>
					</nav>
					<div id="toolbar_ORDER">정렬</div>
				</div>
				<div id="bbs">
					<%
					String pageNum = request.getParameter("page");
					
					Dao dao = new Dao();
					ArrayList<Dto> posts = dao.list();

					
// 결과값 영역
					for (int i = 0; i < posts.size(); i = i + 1) {
					%>
					<div id="bottom_bar"><div id="idtext">
							[<%=posts.get(i).num%>] 🤷‍♀️<%=posts.get(i).id%>/<%=posts.get(i).datatime%></div>
						<a href="read.jsp?num=<%=posts.get(i).num%>"><strong><%=posts.get(i).title%></strong></a><br>
					</div>
					<%
					}
					%>
<!-- 결과값 영역 -->
				</div>
				<div id="bottom">
					<div>Next</div>
					123456789
					<div>Next</div>
				</div>
			</div>
			<jsp:include page="right_Design.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>