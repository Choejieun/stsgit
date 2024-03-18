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
<link rel="stylesheet"
	href="/CSS/common.css?ver=<%= System.currentTimeMillis() %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="x_top_Design.jsp"></jsp:include>
	<div id="mid">
		<jsp:include page="x_left_Design.jsp"></jsp:include>
		<div id="main">
			<img alt="중앙" src="/img/mid.png" width="100%"> <br>
			<div id="title">
				<h1>커뮤니티</h1>
				다양한 사람을 만나고 생각의 폭을 넓혀보세요.
			</div>
			<div id="toolbar">
				<!-- 작성하기 영역 -->
				<div id="toolbar_write">
					<a href="/write.jsp">✔작성하기</a>
				</div>
				<nav id="mid_li">
					<ul>
						<li><a href="/board/list?topick=lite&old=${blp.arrayOld}&word=${blp.searchWord}">사는얘기</a></li>
						<li><a href="/board/list?topick=gathering&old=${blp.arrayOld}&word=${blp.searchWord}">모임&스터디</a></li>
						<li><a href="/board/list?topick=all&old=${blp.arrayOld}">전체</a></li>
					</ul>
				</nav>
				<button id="toggleButton">정렬</button>
				<div id="overlay"></div>
				<div id="modal" >
					<ul>
						<%Setting blp = (Setting) request.getAttribute("blp");  %>
						<%=blp.getarrayOld_buttom()%>
<%-- 						<li><a href="/board/list?page=${blp.pageNum}&old=desc&topick=${blp.topick}">최신순</a></li> --%>
<%-- 						<li><a href="/board/list?page=${blp.pageNum}&old= &topick=${blp.topick} ">오래된순</a></li> --%>
					</ul>
				</div>

				<script>
  var toggleButton = document.getElementById('toggleButton');
  var modal = document.getElementById('modal');
  var overlay = document.getElementById('overlay');
  var closeButton = document.getElementById('closeButton');
  
  // 버튼 실행 시 아래 함수 실행
  toggleButton.onclick = function() { 
    modal.style.display = 'block';
    overlay.style.display = 'block';
  };

  // 최신순, 오래된순 영역 외에 아무 곳이나 클릭하면 팝업이 다시 닫힘
  overlay.onclick = function() {
    modal.style.display = 'none';
    overlay.style.display = 'none';
  };

// //   버튼 실행 시 아래 펑션 실행
//   toggleButton.addEventListener('click', function() { 
//     modal.style.display = 'block';
//     overlay.style.display = 'block';
//   });

// //   #최신순,오래된순 영역 외에 아무 곳이나  클릭하면 팝업이 다시 닫힘
//   overlay.addEventListener('click', function() {
// 	    modal.style.display = 'none';
// 	    overlay.style.display = 'none';
// 	  });
</script>
				<!-- 					ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ -->

			</div>
			<!-- 작성하기 영역 -->


			<div id="toolbar_word">
				<!-- 검색영역 -->
				<form action="/board/list" method="get">
					<div id="toolbar_word_button">
						<div class="textarea">
							<input class="inputvalue" type="text" name="word"
								placeholder="검색어를 입력해주세요"> 
								<input type="hidden"value="${blp.topick}" name="topick">
								<input type="hidden"value="${blp.arrayOld}" name="old">
						</div>
					</div>
				</form>
			</div>
			<!-- 검색영역-->
</body>
</html>