<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀 입력</title>
</head>
<body>
<%
	boolean hasCookie = false; // 쿠키가 있는지 여부를 나타내는 변수

	Cookie [] cookies = request.getCookies(); // 쿠키 배열 가져오기
	if(cookies!=null){
		for(int i=0; i<cookies.length; i++){ // 모든 쿠키 반복
			if(cookies[i].getName().equals("countCookie")){ // 쿠키 이름이 "countCookie"인 경우
				hasCookie = true; // 쿠키가 있음을 표시
				
				String countString = cookies[i].getValue(); // 쿠키 값 가져오기
%>
				쿠키 이름: <%=cookies[i].getName() %>
				쿠키 값: <%=countString %>
				<br>
				<%=countString %> 번째 방문!
<%				
				
				// 쿠키 갱신
				int count = Integer.parseInt(countString) + 1; // 쿠키 값 증가
				Cookie cookie = new Cookie("countCookie", count+""); // 갱신된 쿠키 생성
				response.addCookie(cookie); // 응답에 쿠키 추가
			}
		}
	}
	
	if(hasCookie == false){ // 쿠키가 없는 경우
		Cookie cookie = new Cookie("countCookie", "1"); // 새로운 쿠키 생성 및 초기화
		//cookie.setMaxAge(60);	// 초 단위. 1분
		response.addCookie(cookie); // 응답에 쿠키 추가
%>		
		쿠키 이름: <%=cookie.getName() %>
		쿠키 값: <%=cookie.getValue() %>
		<br>
		<%=cookie.getValue() %> 번째 방문!
		
<%		
		cookie = new Cookie("countCookie", "2"); // 두 번째 쿠키 생성
		response.addCookie(cookie); // 응답에 쿠키 추가
	}
	
%>
</body>
</html>
