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
<title>Insert title here</title>
</head>
<body>
	<div id="main">
		<%
	String num = request.getParameter("num");
	String title = null;
	String content = null;
	String id = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_1", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from main_board where num =" + num + ";");

		if (rs.next()) {
			title = rs.getString("title");
			content = rs.getString("content");
			id = rs.getString("id");
	%>
		<!-- 	제목영역 -->
		<div id="bbs_list">
			<div class="title">
				title -
				<%=title%></div>
			<div class="id">
				[<%=id%>]
			</div>
		</div>
		<!-- 	내용물 영영 -->
		<div class="bbs_text">
			<%=content%>
		</div>

		<%
		}
			} catch (Exception e) {
			e.printStackTrace();
		}
		%>
	</div>
	<div id="main">
		<div id="bbs_Right_align">
			<div class="a_boutton">
				<a href="delproc.jsp?num=<%=num%>">글 삭제하기</a>
			</div>
			<div class="a_boutton">
				<a href="modify.jsp?num=<%=num%>">글 수정하기</a>
			</div>
		</div>
	</div>

</body>
</html>