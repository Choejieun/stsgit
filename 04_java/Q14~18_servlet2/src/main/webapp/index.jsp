<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="test" method="get">
<input type="text"  name="id">
<input type="text" name="pw">
<input type="submit">
</form>
<br>
<form action="test_2" method="post">
<input type="text" name="id">
<input type="text" name="pw">
<input type="submit">
</form>
<br>
<form action="test_move_url">
<input type="submit" value="이동하기">
</form>

</body>
</html>