<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.peisia.hello.Cat"%>  
	<!--      반자동 임포트 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  Cat aa = new Cat(); %>

<%= aa.name %>

</body>
</html>