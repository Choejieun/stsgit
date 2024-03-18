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
<link rel="stylesheet" href="css/common.css?ver=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>커뮤니티 5버전</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<%
	 int num = 0;
	%>
	<div id="warp">
		<jsp:include page="top_list_Design.jsp"></jsp:include>
				<div id="bbs">
				
				
					<!-- 	세팅 시작		 -->
					<%
					Setting.searchWord = request.getParameter("word"); //검색 유무
					Setting.pageNum = request.getParameter("page"); //페이지 선택유무
					Setting.PageNum_void(); // 1번째 페이지인지 검사
					
					Setting set = new Setting(); // setting 불러오기
					ArrayList<Dto> posts =  set.posts_void(null); //문자 데이터 가져오기
					Setting.totalPage_void(); //전체 글 수 가져오기
					%>
					<!-- 	세팅 종료		 -->
					
					
					<!-- 	값 노출 시작		 -->
					<%
					for (int i = 0; i < posts.size(); i = i + 1) {
					%>
					<div id="bottom_bar">
						<div id="idtext">
							[<%=posts.get(i).num%>] 🤷‍♀️<%=posts.get(i).id%>/<%=posts.get(i).datatime%></div>
						<a href="read.jsp?num=<%=posts.get(i).num%>"><strong><%=posts.get(i).title%></strong></a><br>
					</div>
					<%
					}
					%>
					<!-- 	값 노출 종료		 -->
					
					
					<!-- 	페이지 블럭 시작		 -->			
					<%
					PageBlock_F.npageNum = PageBlock_F.npageNum_set(); //문자열 숫자열변화
					PageBlock_F.PageBlock_F(); //블럭관련 연산자
					 %>		
					<!-- 	페이지 블럭 종료		 -->
					
					
					<!-- 	이전/다음 블럭 버튼 시작		 -->
					<%
					PrevNaxtProc.PrevNaxtProc(); //이전 다음 활성화 검사
					%>
					<!-- 	이전/다음 블럭 버튼 종료		 -->	
								  
				</div>
				<jsp:include page="num_Design.jsp"></jsp:include>
			</div>
			<jsp:include page="right_Design.jsp"></jsp:include>
</body>
</html>