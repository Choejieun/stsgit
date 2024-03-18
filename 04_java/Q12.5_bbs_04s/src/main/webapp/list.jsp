<!-- 자바연결 -->
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
					<!-- 	세팅 시작		 -->
					<%
					String pageNum = request.getParameter("page"); //페이지 선택유무
					if (pageNum == null) {
						pageNum = "1";
					}
					System.out.println(pageNum);

					int totalPage = 0; //전체 페이지 변수 선언
					Dao dao = new Dao(); //Dao 불러오기
					ArrayList<Dto> posts = null;
					String searchWord = request.getParameter("word"); //검색 유무
					if (searchWord == null || searchWord.equals("null")) {
						posts = dao.list(pageNum); //전체 기준 데이터 가져오기
						totalPage = dao.getTotalPagecount();
					} else {
						posts = dao.searchlist(pageNum, searchWord); //전체 기준 데이터 가져오기
						totalPage = dao.getSearchTotalPagecount(searchWord);
					}
					;
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
				int npageNum = Integer.parseInt(pageNum);
					 
				//전체 블럭 수 구하기
				int Full_Block = (int)Math.ceil((double) totalPage / Board.PAGE_LINK_AMOUNT);
			
				//현재 블럭 구하기
				int now_Block = (int)Math.ceil((double)npageNum / Board.PAGE_LINK_AMOUNT);
				System.out.println("현재 페이지 : "+npageNum);
				System.out.println("현재블록 : "+now_Block);
				
				//시작 페이지 블럭 구하기 (결과값이 1 이상이면 *블럭에 보이는 수+1 하여 블럭당 첫번째 숫자다.)
				int start_Block =(int)Math.ceil((double) (now_Block-1) * Board.PAGE_LINK_AMOUNT+1);
				//마지막 페이지 블럭 구하기 (결과값이 현재 블럭에서 보이는 블럭당 마지막 숫자다.)
				int end_Block =(int)Math.ceil((double) now_Block * Board.PAGE_LINK_AMOUNT);
				if(end_Block > totalPage){
					end_Block = totalPage;
				}
					 %>		
					<!-- 	페이지 블럭 종료		 -->
					<!-- 	이전/다음 블럭 버튼 시작		 -->
					<%
					int prevPage = 0;
					int naxtPage = 0;
					
					// [이전] 블럭 버튼 활성화 유무 검색
					boolean hasPrev = true;
					if(now_Block == 1){
						hasPrev = false;
					}else{
						hasPrev = true;
						prevPage = (now_Block -1)* Board.PAGE_LINK_AMOUNT; //페이징 시 최대 페이지를 저장
					}
					// [다음] 블럭 버튼 활성화 유무 검색
					boolean hasNext = true;
					System.out.println("최대 블록 : "+Full_Block);
					if(now_Block >= Full_Block){
						hasNext = false;
					}else{
						hasNext = true;
						naxtPage = now_Block * Board.PAGE_LINK_AMOUNT+1;//페이징 시 최소 페이지를 저장
					}
					%>
					<!-- 	이전/다음 블럭 버튼 종료		 -->				  
				</div>
				<div id="bottom">
					<!-- 	하단 버튼 출력 영역 시작 [1]		 -->		
					<div>					
					<%
					//이전 버튼
					if (hasPrev){
						if(searchWord == null){ //키워드 X
							System.out.println("이전 : "+prevPage);
							%>
								<a href="list.jsp?page=<%=prevPage %>">Prev</a>
							<%
						}else{
							%>
							<a href="list.jsp?page=<%=prevPage %>&word=<%=searchWord%> ">Prev</a>
						<%
						}}
					%>	
					</div>
					<!-- 	하단 버튼 출력 영역 종료 [1]		 -->
					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->
					<%
					System.out.println("시작 블록 : "+start_Block);
					System.out.println("끝 블록 : "+end_Block);
					for(int i = start_Block; i <= end_Block; i++ ){
						if(i == npageNum){
							%>
							<strong>[ <%=i %> ]</strong>
							<%
						}else{
							if(searchWord == null){ //키워드 X
								%>
									<a href="list.jsp?page=<%=i %>"><%=i %></a>
								<%
							}else{
								%>
								<a href="list.jsp?page=<%=i %>&word=<%=searchWord%> "><%=i %></a>
							<%
							}	
						}
					}
					%>
					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->																		
					<!-- 	하단 버튼 출력 영역 시작 [3]		 -->		
					<div>
					<%
					//다음 버튼
					if (hasNext){
						if(searchWord == null){ //키워드 X
							%>
								<a href="list.jsp?page=<%=naxtPage %>">Next</a>
							<%
						}else{
							%>
							<a href="list.jsp?page=<%=naxtPage %>&word=<%=searchWord%> ">Next</a>
						<%
						}
						}
					%>	
					</div>
					<!-- 	하단 버튼 출력 영역 종료 [3]		 -->
				</div>
				<form action="list.jsp">
				<input type="text" name="word"><input type="submit" value="검색">
				</form>
			</div>
			<jsp:include page="right_Design.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>