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
    // 한글 깨짐을 방지하기 위해 요청의 문자 인코딩을 UTF-8로 설정
	request.setCharacterEncoding("UTF-8");

    // "hobby" 매개변수의 값을 배열로 받음
	String nS[] = request.getParameterValues("hobby");
	//Java에서 배열을 선언할 때는 변수 이름 뒤에 대괄호([])를 사용합니다.

    // 주석 처리한 코드: 배열의 각 요소를 출력
	//out.println(nS[0]);
	//out.println(nS[1]);

    // 만약 "hobby" 매개변수가 전달되었다면
	if(nS != null){		
        // 배열의 각 요소를 반복하여 출력
		for(int i=0; i < nS.length; i++){ 
			out.println(nS[i]);
		}
	}
    else{
    	out.print("떙");
    }
%>


</body>
</html>