<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
<%
/* 	GuestVO read = (GuestVO)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext(); */
%>	

글번호:${read.bno}
<hr>
글내용:		
	<form action="/guest/modify" method="post">
		<input type="hidden" name='bno' value='${read.bno}' >
		<textarea name='btext'>${read.btext}</textarea>
		<input type="submit" value="수정하기">
	</form>
	
	
	<!-- 
<%-- <% --%>
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
<!-- %>

<%-- 글번호:<%=bno %><br> --%>
글내용:	

	<form action="/guest/modify" method="post">
<%-- 		<input type="hidden" name='bno' value='<%=bno %>' > --%>
		<textarea name='btext'>
<%-- 			<%=btext %> --%>
		</textarea>
		<input type="submit" value="수정하기">
	</form>
		 -->
</body>
</html>