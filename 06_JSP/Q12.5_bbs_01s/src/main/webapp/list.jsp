<!-- 자바연결 -->
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DatabaseMetaData"%> <!-- 이 import 문 추가 -->
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="common.css">
<meta charset="UTF-8">
<title>게시판 - 글 리스트</title>
</head>
<body>
		<div id="main">

			<div id="bbs_title">
				<div class="title">no.</div>
				<div class="title">제목</div>
				<div class="id">작성자</div>
			</div>

			<!-- <hr> -->
			<%
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_1", "root", "root");
				Statement st = con.createStatement();
					// I_NO 열이 존재하는지 확인
					DatabaseMetaData metaData = con.getMetaData();
					ResultSet columns = metaData.getColumns(null, null, "main_board", "num");
					if (columns.next()) {
					// I_NO 열이 존재하면 삭제
					String dropAutoIncrementColumnQuery = "ALTER TABLE main_board DROP COLUMN num;";
					st.executeUpdate(dropAutoIncrementColumnQuery);
					}

					// 새로운 열 추가
					String addAutoIncrementColumnQuery = "ALTER TABLE main_board ADD COLUMN num INT AUTO_INCREMENT PRIMARY KEY;";
					st.executeUpdate(addAutoIncrementColumnQuery);
				

				ResultSet rs = st.executeQuery("select * from main_board;");
				while (rs.next()) {
					String no = rs.getString("num");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String id = rs.getString("id");
			%>

			<div id="bbs_list">
				<div class="title">
					[<%=no%>]
					<a href="read.jsp?num=<%=no %>"><%=title%></a>
				</div>
				<div class="id"><%=id%></div>
			</div>
			<%
			}

			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</div>
			<div id="main">
			<div id="bbs_but">
					<div class="title"></div>
			1 2 3  4 5 [6] 7 8
			<div class="a_boutton">
				<a href="write.jsp">글쓰기</a>
				</div></div>
			</div>
</body>
</html>