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
<form action="/Pr2/Pr2_main">
<input type="text" name="SearchQ"  placeholder="검색어를 입력하세요">
</form>
<c:forEach var="ID" items="${youtubeItems }" >
<iframe id="ytplayer" type="text/html" width="720" height="405"
src="https://www.youtube.com/embed/${ID.id.videoId }"
frameborder="0" allowfullscreen>
</iframe><br>
</c:forEach>
</body>
</html>