<%@page import="org.apache.catalina.filters.AddDefaultCharsetFilter"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList <String> a = new ArrayList<String>();
	a.add("꾸엑이");
	a.add("꾸엑이2");
	a.add("꾸엑이3");
	for( int i = 0 ; i < 3 ; i ++){   				%>
	<%=a.get(i) %> <br/>
<%} %>
</body>
</html>