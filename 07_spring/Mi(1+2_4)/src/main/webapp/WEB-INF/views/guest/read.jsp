<%@page import="com.peisia.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->							
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->							
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>							
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->							
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->							
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/common.css" >
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	GuestDto read = (GuestDto)request.getAttribute("read");
	long bno = read.getBno();
	String btext = read.getBtext();
%>	

글본문
글번호:<%=bno %>
글내용:<%=btext %>
<hr>
<a href="${cp}/guest/del?bno=${read.bno}">삭제하기</a>
<br>
<a href="${cp}/guest/modify?bno=${read.bno}">수정하기</a>
<br>
<a href="${cp}/guest/getList">글 리스트</a>

<!-- _________EL적용 시_________ -->
<!--
 글 읽기 
<hr>
글번호:${read.bno}
<hr>
 글내용:${read.btext} --%>
 -->
</body>
</html>