<%@page import="com.peisia.userDB.LoginProc"%>
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
String id =request.getParameter("ID");
String pw =request.getParameter("PW");
String user_name =request.getParameter("USER_NAME");

LoginProc logP = new LoginProc();
LoginProc.Login_OK = logP.IDPWcheck(id,pw);
System.out.println("로그인체크 "+LoginProc.Login_OK);
user_name = logP.USER_NAMEcheck(id,pw);

if(LoginProc.Login_OK == true){
%>
<jsp:forward page="list.jsp"></jsp:forward>
<%
}else{%>
<script>
    alert("로그인 실패");
    window.location.href = "index.jsp"; // 로그인 실패 시 페이지 전환
</script>
<%}
%>
</body>
</html>