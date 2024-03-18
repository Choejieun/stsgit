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
<title>글 읽기</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
	<div id="warp">
		<jsp:include page="top_Design.jsp"></jsp:include>
		<div id="mid">
		<jsp:include page="left_Design.jsp"></jsp:include>
			<div id="main">
				<img alt="중앙" src="img/mid.png" width="100%"> <br>
			<div id="c"><div id="hr_1"></div><a href="list.jsp">&nbsp;커뮤니티&nbsp;</a><div id="hr_2"></div></div>
				<div id="bbs">
					<%
					String num = request.getParameter("num");
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs_2", "root", "root");
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("select * from main_board_2 where num = " + num + ";");
						System.out.print(rs);

						if (rs.next()) {
							String title = rs.getString("title");
							String id = rs.getString("id");
							String datatime = rs.getString("datatime");
							String content = rs.getString("content"); //미사용
					%>

<div id = "user">
<img alt="#" src="img/배너멍멍이.jpg">
					<div class="idbox">
					<a href="#"><%=id%></a> <br>
					<%=datatime%><br>
					</div>
					<div class="box">
					<div class="icon"><img alt="#" src="img/퍼가기.png" width="100%"></div>
					<div class="icon"><img alt="#" src="img/퍼가기.png" width="100%"></div>
					</div>
</div>					
					<h1><%=title%></h1>
					<div id="text">
					<%=content%>
					</div>
					<%
					}

					} catch (Exception e) {
					e.printStackTrace();
					}
					%>
					<a href="delproc.jsp?num=<%=num%>">삭제하기</a>
					<a href="modify.jsp?num=<%=num%>">수정하기</a>
					<br>
			<img alt="#" src="img/notbot.png">		
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