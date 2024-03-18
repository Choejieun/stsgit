<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 로비 메인</title>
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="chatRoom.css">
</head>
<body>
    <script>
//         function addContent() {
//             console.log("시스템 로그에 추가되었다.");
//             var scrollableDiv = document.getElementById("midChat");
//             scrollableDiv.scrollTop = scrollableDiv.scrollHeight;
//             window.scrollTo(0, document.body.scrollHeight);
//         }

//         function autoAddContent() {
//             // 일정 시간마다 addContent 함수 호출
//             setInterval(function() {
//                 addContent();
//             }, 0); // 1초 간격으로 변경하려면 숫자를 조절하세요
//         }

//         // 페이지 로딩 후 자동으로 실행
//         window.onload = autoAddContent;
    function addContent() {
        var scrollableDiv = document.getElementById("midChat");
        scrollableDiv.scrollTop = scrollableDiv.scrollHeight;
        window.scrollTo(0, document.body.scrollHeight);
 
    }

    function autoAddContent() {
        // 0 밀리초(즉, 즉시) 후에 addContent 함수를 한 번만 호출
        setTimeout(function() {
            addContent();
        }, 0);
    }

    // 페이지 로딩 후 자동으로 실행
    window.onload = autoAddContent;
</script>
	<%
	String myUserName = (String) session.getAttribute("userName");
	%>
	<a href="chatting.jsp?roomNo=1"><input type="submit" value="채팅방"></a>

	<div id="main">
		<header id="top"></header>
		<section id="mid">
			<div id="midLeft">
				<div id="chatTop">
					<div id="topText">채팅목록 ▼</div>
				</div>
				<%
				for (int i = 0; i < 60; i++) {
				%>
				더미글씨 <br>
				<%
				}
				%>

				<div id="chatRoom"></div>
			</div>
			<div id="midCenter">
				<div id="midChat">
			<jsp:include page="chatting.jsp"  flush="true">
			<jsp:param name="roomNo" value="1" />
			</jsp:include>
			
			<!-- 채팅 --> 
		<div id="Chat_Input_area">
			<form action="chattingProc.jsp" method="get">
				<input type="hidden" name="roomNo" value="1">
				<div class="textarea">
				<input class="inputvalue" type="text" name="chat" placeholder="채팅창">
				</div>
			</form>
		</div>
		<!-- 채팅-->
		
		
				</div>
			</div>
			<div id="midRight">
				<div id="midProfile">
					<img id="ProfileImage"
						src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
					<div id="ProfileText"><%=myUserName%>님 반갑습니다.
					</div>
				</div>
				<div id="midFriend">
					<div id="friendtop">
						<div id="friendText">친구목록 ▼</div>
					</div>
					<%
					for (int i = 0; i < 60; i++) {
					%>
					더미글씨 <br>
					<%
					}
					%>

				</div>
			</div>
		</section>
		<footer id="bot"></footer>
	</div>


</body>
</html>