<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="x" class="testBean.Bean">
<jsp:setProperty name="x" property="*"  />
</jsp:useBean>

<hr>
이름 : <%=x.getName() %>
<br>
숫자 : <%=x.getNumber() %>
<hr>
이름 : ${x.name}
<br>
숫자 : ${x.number}

</body>
</html>