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
<c:forEach var="Search_main" items="${Search_main}">
${Search_main.searchTerms}
</c:forEach>
<c:forEach var="Search_items" items="${Search_items}">
<pre>
<a href="${Search_items.link}">${Search_items.title}</a>
hi
${Search_items.pagemap.cseImage.src}
<c:forEach var="Search_items_img_V" items="${Search_items.pagemap.cseImage}">
${Search_items_img_V.src }
<img src="${Search_items_img_V.src }"> 
hi
</c:forEach>
</pre>
</c:forEach>
</body>
</html>