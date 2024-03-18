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
<link rel="stylesheet" href="common.css">
<meta charset="UTF-8">
<title>커뮤니티</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<%int num = 0; %>
	<div id="warp">
		<div id="top">
			<div id="logoMOD">
				<img alt="logo" src="img/logo.png">
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
				따봉 강아지 <img alt="멍멍이" src="img/배너멍멍이.jpg" width="100%">
			</div>
			<div id="main">
				<img alt="중앙" src="img/mid.png" width="100%"> <br>
				<div id="title">
					<h1>커뮤니티</h1>
					다양한 사람을 만나고 생각의 폭을 넓혀보세요.
				</div>
				<div id=toolbar>
					<div id="toolbar_write">
					<a href="write.jsp">✔작성하기</a></div>
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
					try {
						request.setCharacterEncoding("UTF-8");	// 이거 안하면 한글 깨짐.
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_2", "root", "root");
						Statement st = con.createStatement();

						// I_NO 열이 존재하는지 확인
						DatabaseMetaData metaData = con.getMetaData();
						ResultSet columns = metaData.getColumns(null, null, "main_board_2", "num");
						if (columns.next()) {
							// I_NO 열이 존재하면 삭제
							String dropAutoIncrementColumnQuery = "ALTER TABLE main_board_2 DROP COLUMN num;";
							st.executeUpdate(dropAutoIncrementColumnQuery);
						}

						// 새로운 열 추가
						String addAutoIncrementColumnQuery = "ALTER TABLE main_board_2 ADD COLUMN num INT AUTO_INCREMENT PRIMARY KEY;";
						st.executeUpdate(addAutoIncrementColumnQuery);

						ResultSet rs = st.executeQuery("select * from main_board_2;");

						while (rs.next()) {
							num = rs.getInt("num");
							String title = rs.getString("title");
							String id = rs.getString("id");
							String datatime = rs.getString("datatime");
							String content = rs.getString("content"); //미사용
					%>
					<div id="bottom_bar">
						<div id="idtext">
							[<%=num%>] 🤷‍♀️
							<%=id%>
							/
							<%=datatime%></div>
					<a href="read.jsp?num=<%=num %>"><strong><%=title%></strong></a><br>
					</div>
					<%
					
					}

					} catch (Exception e) {
					e.printStackTrace();
					}
					%>
				</div>
				<div id="bottom">
					<div>Next</div>
					123456789
					<div>Next</div>
				</div>
			</div>
			<div id="right">
				따봉 강아지 <img alt="멍멍이" src="img/관심이.jpg" width="100%">
			</div>
		</div>
	</div>
</body>
</html>