<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>									
    <c:set var="cp" value="${pageContext.request.contextPath}" /><!-- el변수 cp에 경로저장 -->									
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <script async src="https://cse.google.com/cse.js?cx=05a3c017af122473a"> -->
<!-- </script> -->
<!-- <div class="gcse-search"></div> -->
<form action="/Pr2/Pr2_main">
<input type="text" name="SearchQ"  placeholder="검색어를 입력하세요">
</form>
</body>
</html>