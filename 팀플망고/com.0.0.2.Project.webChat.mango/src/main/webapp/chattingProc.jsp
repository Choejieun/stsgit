<%@page import="ChatDB.C_Dao"%>
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
	request.setCharacterEncoding("UTF-8");

	String chat = request.getParameter("chat");

	String roomNo = request.getParameter("roomNo");
	String userNo = (String) session.getAttribute("userNo");
	C_Dao.chatting(roomNo, chat, userNo);
	response.sendRedirect("index.jsp?roomNo=" + roomNo);
	%>
</body>
</html>