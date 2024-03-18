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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/common.css?ver=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

				<div id="bottom">
					<!-- 	하단 버튼 출력 영역 시작 [1]		 -->		
					<div>			
					<%
					//이전 버튼
					if (PrevNaxtProc.hasPrev){
						if(Setting.searchWord == null){ //키워드 X
							System.out.println("이전 : "+PrevNaxtProc.prevPage);
							%>
								<a href="list.jsp?page=<%=PrevNaxtProc.prevPage %>">Prev</a>
							<%
						}else{
							%>
							<a href="list.jsp?page=<%=PrevNaxtProc.prevPage %>&word=<%=Setting.searchWord%> ">Prev</a>
						<%
						}}
					%>	
					</div>
					<!-- 	하단 버튼 출력 영역 종료 [1]		 -->
					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->
					<div id="num">
					<%
					if (PrevNaxtProc.hasPrev){ // 1번
						if(Setting.searchWord == null){ //키워드 X
							System.out.println("이전 : "+PrevNaxtProc.prevPage);
							%>
								<a href="list.jsp?page=1">1 ···</a>
							<%
						}else{
							%>
							<a href="list.jsp?page=1&word=<%=Setting.searchWord%> ">1 ···</a>
						<%			}}			%>	
<!-- 						/////////////////////////////////////////////////////////////////////////////////////////// -->
						<%
					for(int i = PageBlock_F.start_Block; i <= PageBlock_F.end_Block; i++ ){
						if(i == PageBlock_F.npageNum){
							%>
							<strong>[ <%=i %> ]</strong>
							<%
						}else{
							if(Setting.searchWord == null){ //키워드 X
								%>
									<a href="list.jsp?page=<%=i %>"><%=i %></a>
								<%
							}else{
								String urlEncodedSearchWord = java.net.URLEncoder.encode(Setting.searchWord);	
								%>
								<a href="list.jsp?page=<%=i %>&word=<%=Setting.searchWord%> "><%=i %></a>
							<%			}	}	}			%>	
<!-- 						/////////////////////////////////////////////////////////////////////////////////////////// -->
							<%
					Dao dao = new Dao(); 	//마지막 숫자
					if (PrevNaxtProc.hasNext){
						if(Setting.searchWord == null){ //키워드 X
							%>
								<a href="list.jsp?page=<%=dao.getTotalPagecount()%>">··· <%=dao.getTotalPagecount()%></a>
							<%	}else{	%>
							<a href="list.jsp?page=<%=dao.getSearchTotalPagecount(Setting.searchWord)%>
							&word=<%=Setting.searchWord%> ">··· <%=dao.getSearchTotalPagecount(Setting.searchWord)%></a>
						<%}}%>	
						</div>
					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->																		
					<!-- 	하단 버튼 출력 영역 시작 [3]		 -->		
					<div>
					<%
					//다음 버튼
					if (PrevNaxtProc.hasNext){
						if(Setting.searchWord == null){ //키워드 X
							%>
								<a href="list.jsp?page=<%=PrevNaxtProc.naxtPage %>">Next</a>
							<%
						}else{
							%>
							<a href="list.jsp?page=<%=PrevNaxtProc.naxtPage %>&word=<%=Setting.searchWord%> ">Next</a>
						<%
						}
						}
					%>	
					</div>
					<!-- 	하단 버튼 출력 영역 종료 [3]		 -->
				</div>

</body>
</html>