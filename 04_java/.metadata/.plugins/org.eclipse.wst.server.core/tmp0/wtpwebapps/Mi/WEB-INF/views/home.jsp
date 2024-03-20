<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->									
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->									
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->									
<c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
<html>
<head>
<link rel="stylesheet" href="/resources/common.css" >
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="${cp}/guest/testapi">test api</a>
<a href="${cp}/guest/getList">방명록</a>
<a href="${cp}/reg/regFom">회원가입</a>
<a href="${cp}/login/loginFom">로그인</a>
<a href="${cp}/weaher/apitest">날씨</a>
<a href="${cp}/Cyphers/cyphersSearch">사이퍼즈</a>
<a href="${cp}/Pr1/Pr1_Search">검색하기</a>
<a href="${cp}/Pr2/Pr2_Search">유튜브보기</a>
<%-- <a href="${cp}/guest/getList?currentPage=1">[방명록]</a> --%>

세션 ${id}

</body>
</html>
