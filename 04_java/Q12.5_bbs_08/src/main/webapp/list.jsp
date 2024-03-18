<!-- 자바연결 -->
<%@page import="com.peisia.list.PrevNaxtProc"%>
<%@page import="com.peisia.list.PageBlock_F"%>
<%@page import="org.apache.naming.HandlerRef"%>
<%@page import="com.peisia.db.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.peisia.db.Dao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DatabaseMetaData"%>
<%@page import="com.peisia.db.Board"%>
<%@page import="com.peisia.list.Setting"%>
<%@page import="com.peisia.list.PageBlock_F"%>
<%@page import="com.peisia.list.PrevNaxtProc"%>
<!-- 이 import 문 추가 -->
<!-- 자바연결 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/CSS/common.css?ver=<%=System.currentTimeMillis()%>">
<meta charset="UTF-8">
<title>커뮤니티 8버전</title>
</head>
<body>
	<!-- 	세팅 시작		 -->
	<%
    request.setCharacterEncoding("UTF-8");
	Setting blp = (Setting) request.getAttribute("blp"); //서블릿~서비스에서 만들어 놓은 함수 호출
	ArrayList<Dto> posts = blp.getPosts(); //위 과정에서 만든 데이터 컬렉션 호출
	%>
	<!-- 	세팅 종료		 -->
	<div id="warp">
		<jsp:include page="x_top_list_Design.jsp"></jsp:include>
		<div id="bbs">

			<!-- 	값 노출 시작		 -->
			<%
			for (int i = 0; i < posts.size(); i = i + 1) {
			%>
			<div id="bottom_bar">
				<div id="idtext">
					[<%=posts.get(i).num%>] 🤷‍♀️<%=posts.get(i).id%>/<%=posts.get(i).datatime%></div>
				<a href="/board/read?num=<%=posts.get(i).num%>&topick=<%=posts.get(i).topick%>"><strong><%=posts.get(i).title%></strong></a>
			</div>
			<%
			}
			%>
			<!-- 	값 노출 종료		 -->

		</div>
		<jsp:include page="x_num_Design.jsp"></jsp:include>
	</div>
	<jsp:include page="x_right_Design.jsp"></jsp:include>
</body>
</html>