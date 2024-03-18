<%@page import="java.util.ArrayList"%>
<%@page import="LoginDB.L_Dao"%>
<%@page import="LoginDB.L_Dto"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwRe = request.getParameter("pwRe");
	String name = request.getParameter("name");
	String regex = ".*[\\p{Punct}\\s].*";
	try {
	if (id.length() <= 0 || pw.length() <= 0 || pwRe.length() <= 0 || name.length() <= 0) {
		response.sendRedirect("signUp.jsp?mag=null");
	} else if (id.matches(regex) || pw.matches(regex) || pwRe.matches(regex) || name.matches(regex)) {
		response.sendRedirect("signUp.jsp?mag=*");
	} else if (!pw.equals(pwRe)) {
		response.sendRedirect("signUp.jsp?mag=pw");
	} else if (L_Dao.joinIdCk(id)) {
		L_Dto join = new L_Dto(id, pw, name);
		L_Dao.join(join);
		response.sendRedirect("login.jsp");
	} else {
		response.sendRedirect("signUp.jsp?mag=id");
	}
	}catch (NullPointerException e){
		response.sendRedirect("signUp.jsp?mag=null");
	}
	%>
</body>
</html>