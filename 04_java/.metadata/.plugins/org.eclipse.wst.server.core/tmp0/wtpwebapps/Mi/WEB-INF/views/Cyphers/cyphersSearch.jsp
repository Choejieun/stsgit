<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
    <c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/CyphersCommon.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="warp_common">
<a class="titleTEXT">전적 검색</a>
<form action="/Cyphers/cyphersMain">
<input type="text" name="username" autocomplete="off">
<!-- <input type="submit" value="검색"> -->
</form>

</div>
</body>
</html>