<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 0. 웹 애플리케이션의 루트 경로(컨텍스트 경로) 를 가져와서 링크에 다 연결해줘야 함     -->
<!-- 1. 0을 위한 준비. jstl core 태그 선언     -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 2. 0을 위한 준비. el 태그로 가져올 수 있는데 이걸 더 짧게 찍기위해 변수 대입함.     -->    
<c:set var="cp" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/boxdance.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${cp}/resources/testapi.js"></script>
</head>
<body>
ajax api 테스트
<hr>
<button id="cat1">냥냥냥</button>
<div id="cat1_area"></div>
<button id="cat2">칡</button>
<div id="cat2_area"></div>
<button id="dog1">변신!</button>
<div id="dog1_area"></div>
<br>

<button id="box_0">박스 열기</button>
<button id="box_1">박스 접기</button>
<button id="box_2">박스 닫기</button>
<button id="box_3">테이핑</button>
<div id="box_0_img">
<img src="/resources/img/box3.jpg">
</div>
</body>
</html>