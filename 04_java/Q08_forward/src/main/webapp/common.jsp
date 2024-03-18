<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a href='index1.jsp'>페이지1</a>
<a href='index2.jsp'>페이지2</a>

<%
	int xxx = Integer.parseInt(request.getParameter("x"));
	int yyy = Integer.parseInt(request.getParameter("y"));
%>

<%=xxx+yyy%>개
