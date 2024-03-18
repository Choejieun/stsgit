<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<%  	request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<form action="/Controller_Login/join" method="post">
아이디<input type="text" name="id"> <br>
비밀번호 <input type="password" name="pw"> <br>
비밀번호 체크 <input type="password" name="pw_ck"> <br>
닉네임 <input type="text" name="userNAME">
<input type="submit">
</form>
</body>
</html>