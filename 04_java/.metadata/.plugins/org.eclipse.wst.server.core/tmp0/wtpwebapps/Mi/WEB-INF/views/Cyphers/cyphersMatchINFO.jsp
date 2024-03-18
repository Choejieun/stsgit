<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!-- el변수 cp에 경로저장 -->

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/CyphersMatcgINFO.css">
<link rel="stylesheet" href="/resources/CyphersMain.css">
<meta charset="UTF-8">
<title>매치 상세 정보</title>
</head>
<body>
<div id="topbar">
<form action="/Cyphers/cyphersMain">
<input type="text" name="username" autocomplete="off" placeholder="닉네임을 입력해주세요">
</form>
</div>

	<!-- 검색창 -->
	<!-- 상단 결과 요약 -->
	<div id="main_result">
		<div
			class="<c:if test='${Team_0 eq "win"}'>win_area</c:if><c:if test='${Team_0 eq "lose"}'>lose_area</c:if>">
			<c:if test="${Team_0 eq 'lose'}">
				<a class="lose">LOSE</a>
			</c:if>
			<c:if test="${Team_0 eq 'win'}">
				<a class="win">WIN</a>
			</c:if>
			<br>
			<c:forEach var="i" begin="0" end="4">
				<%
				int iValue = (Integer) pageContext.getAttribute("i");
				String teamGet0ID = (String) pageContext.findAttribute("Team_get0_" + iValue + "_ID");
				%>
				<div class="playinfo_main" onclick="cyphersMain('<%=teamGet0ID%>')">
					<c:forEach var="k" begin="0" end="9">
						<%
						int k = (Integer) pageContext.getAttribute("k");
						String nowCharacterPL = (String) pageContext.findAttribute("nowCharacterPL_" + k);
						String characterId = (String) pageContext.findAttribute("characterId_" + k);
						String characterName = (String) pageContext.findAttribute("characterName_" + k);
						%>
						<%
						if (nowCharacterPL.equals(teamGet0ID)) {
						%>
						<!-- 캐릭터 아이콘 불러오기 -->
						<div class="charactename">
							<img
								src="https://img-api.neople.co.kr/cy/characters/<%=characterId%>"><%=characterName%>
						</div>
						<%
						}
						%>
					</c:forEach>
					<a href="/Cyphers/cyphersMain?username=<%=teamGet0ID%>"><%=teamGet0ID%></a>
					<br>
				</div>
			</c:forEach>
		</div>

		<div
			class="<c:if test='${Team_1 eq "win"}'>win_area</c:if><c:if test='${Team_1 eq "lose"}'>lose_area</c:if>">
			<c:if test="${Team_1 eq 'lose'}">
				<a class="lose">LOSE</a>
			</c:if>
			<c:if test="${Team_1 eq 'win'}">
				<a class="win">WIN</a>
			</c:if>
			<br>
			<c:forEach var="i" begin="0" end="4">
				<%
				int iValue = (Integer) pageContext.getAttribute("i");
				String teamGet0ID = (String) pageContext.findAttribute("Team_get1_" + iValue + "_ID");
				%>
				<div class="playinfo_main" onclick="cyphersMain('<%=teamGet0ID%>')">
					<c:forEach var="k" begin="0" end="9">
						<%
						int k = (Integer) pageContext.getAttribute("k");
						String nowCharacterPL = (String) pageContext.findAttribute("nowCharacterPL_" + k);
						String characterId = (String) pageContext.findAttribute("characterId_" + k);
						String characterName = (String) pageContext.findAttribute("characterName_" + k);
						%>
						<%
						if (nowCharacterPL.equals(teamGet0ID)) {
						%>
						<!-- 캐릭터 아이콘 불러오기 -->
						<div class="charactename">
							<img
								src="https://img-api.neople.co.kr/cy/characters/<%=characterId%>"><%=characterName%>
						</div>
						<%
						}
						%>
					</c:forEach>
					<a href="/Cyphers/cyphersMain?username=<%=teamGet0ID%>"><%=teamGet0ID%></a>
					<br>
				</div>
			</c:forEach>
		</div>
		<script>
			function cyphersMain(nickname) {
				window.location.href = '/Cyphers/cyphersMain?username='
						+ nickname;
			}
		</script>
	</div>
	<!-- 상단 결과 요약 -->
	<!-- ----------------------------------------------------- -->
		<div id="warp_bot">
		<!-- 개별 상세  -->
		<!-- 유저 전체 색인 -->
		<div class="personal_div">
		<%-- 함수: 개별 유저 정보 표시 --%>
		<c:forEach var="MatchesPlayer" items="${MatchesINFO}">
    	<c:if test="${MatchesPlayer.nickname eq Team_get0_0_ID or
                 MatchesPlayer.nickname eq Team_get0_1_ID or
                 MatchesPlayer.nickname eq Team_get0_2_ID or
                 MatchesPlayer.nickname eq Team_get0_3_ID or
                 MatchesPlayer.nickname eq Team_get0_4_ID}">
        <c:set var="teamColor" value="${Team_0 eq 'win' ? 'blue_aa' : 'red_aa'}" />
        <c:set var="partyIdToExclude" value="b762303013093c43599c55f64fdcff53" />
        <c:set var="matchesPlayerPartyId" value="${MatchesPlayer.playInfo.partyId}" />
        
        <c:set var="playerNickname" value="${MatchesPlayer.nickname}" />
        <c:set var="characterId" value="${MatchesPlayer.playInfo.characterId}" />
        <c:set var="characterName" value="${MatchesPlayer.playInfo.characterName}" />
        <c:set var="level" value="${MatchesPlayer.playInfo.level}" />
        <c:set var="killCount" value="${MatchesPlayer.playInfo.killCount}" />
        <c:set var="deathCount" value="${MatchesPlayer.playInfo.deathCount}" />
        <c:set var="assistCount" value="${MatchesPlayer.playInfo.assistCount}" />
        <c:set var="attackPoint" value="${MatchesPlayer.playInfo.attackPoint}" />
        <c:set var="damagePoint" value="${MatchesPlayer.playInfo.damagePoint}" />
        <c:set var="towerAttackPoint" value="${MatchesPlayer.playInfo.towerAttackPoint}" />
        <c:set var="battlePoint" value="${MatchesPlayer.playInfo.battlePoint}" />
        <c:set var="sightPoint" value="${MatchesPlayer.playInfo.sightPoint}" />
        <c:set var="getCoin" value="${MatchesPlayer.playInfo.getCoin}" />
        <c:set var="spendCoin" value="${MatchesPlayer.playInfo.spendCoin}" />
        <c:set var="spendConsumablesCoin" value="${MatchesPlayer.playInfo.spendConsumablesCoin}" />
        <c:set var="csCount" value="${MatchesPlayer.playInfo.sentinelKillCount + MatchesPlayer.playInfo.demolisherKillCount}" />
        <c:set var="PositionName" value="${MatchesPlayer.position.name}" />
        <div class="${teamColor}">
            <a href="/Cyphers/cyphersMain?username=${playerNickname}">${playerNickname }</a><br>
            <!-- 색인 유저당 관련 정보 출력 -->
     <c:choose>
    <c:when test="${PositionName eq '탱커' }">
       <img alt="포지션" src="/resources/img/3.png">
    </c:when>
    <c:when test="${PositionName eq '서포터' }">
    <img alt="포지션" src="/resources/img/4.png">
    </c:when>
    <c:when test="${PositionName eq '근거리딜러' }">
    <img alt="포지션" src="/resources/img/1.png">
    </c:when>
    <c:when test="${PositionName eq '원거리딜러' }">
    <img alt="포지션" src="/resources/img/2.png">
    </c:when>
	</c:choose>
            <img src="https://img-api.neople.co.kr/cy/characters/${characterId}">${characterName}<br>
            Lv.${level}<br>
            [K/D/A] [${killCount}/${deathCount}/${assistCount}]<br>
            준 피해량: <fmt:formatNumber value="${attackPoint}" pattern="#,##0"/> // 받은 피해량: <fmt:formatNumber value="${damagePoint}" pattern="#,##0"/><br>
            타워 공격량: <fmt:formatNumber value="${towerAttackPoint}" pattern="#,##0"/> // 전투참여: ${battlePoint} // 시야확보: ${sightPoint}<br>
            코인 흭득량: <fmt:formatNumber value="${getCoin}" pattern="#,##0"/> // 코인 소모량: <fmt:formatNumber value="${spendCoin}" pattern="#,##0"/> // 소모품 소비량: <fmt:formatNumber value="${spendConsumablesCoin}" pattern="#,##0"/><br>
            CS: ${csCount}<br>
            <!-- 파티원 검사 -->
            <c:forEach var="two" items="${MatchesINFO}">
                <c:if test="${matchesPlayerPartyId eq two.playInfo.partyId
                                && playerNickname ne two.nickname 
                                && matchesPlayerPartyId ne partyIdToExclude}">
                    (#파티:<a href="/Cyphers/cyphersMain?username=${two.nickname}">${two.nickname}</a>)
                </c:if>
            </c:forEach><!-- 파티원 검사 -->
            <!-- 색인 유저당 관련 정보 출력 -->
        </div>
    </c:if>
</c:forEach><!-- 개별 유저 정보 표시 반복문 종료 -->
</div>
<!--  --------------------------------------------------------------------------------  -->						
		<!-- 유저 전체 색인 -->
<div class="personal_div">
            <%-- 함수: 개별 유저 정보 표시 --%>
			<c:forEach var="MatchesPlayer" items="${MatchesINFO}">
    		<c:if test="${MatchesPlayer.nickname eq Team_get1_0_ID or
                 MatchesPlayer.nickname eq Team_get1_1_ID or
                 MatchesPlayer.nickname eq Team_get1_2_ID or
                 MatchesPlayer.nickname eq Team_get1_3_ID or
                 MatchesPlayer.nickname eq Team_get1_4_ID}">
        <c:set var="teamColor" value="${Team_1 eq 'win' ? 'blue_aa' : 'red_aa'}" />
        <c:set var="partyIdToExclude" value="b762303013093c43599c55f64fdcff53" />
        <c:set var="matchesPlayerPartyId" value="${MatchesPlayer.playInfo.partyId}" />
        
        <c:set var="playerNickname" value="${MatchesPlayer.nickname}" />
        <c:set var="characterId" value="${MatchesPlayer.playInfo.characterId}" />
        <c:set var="characterName" value="${MatchesPlayer.playInfo.characterName}" />
        <c:set var="level" value="${MatchesPlayer.playInfo.level}" />
        <c:set var="killCount" value="${MatchesPlayer.playInfo.killCount}" />
        <c:set var="deathCount" value="${MatchesPlayer.playInfo.deathCount}" />
        <c:set var="assistCount" value="${MatchesPlayer.playInfo.assistCount}" />
        <c:set var="attackPoint" value="${MatchesPlayer.playInfo.attackPoint}" />
        <c:set var="damagePoint" value="${MatchesPlayer.playInfo.damagePoint}" />
        <c:set var="towerAttackPoint" value="${MatchesPlayer.playInfo.towerAttackPoint}" />
        <c:set var="battlePoint" value="${MatchesPlayer.playInfo.battlePoint}" />
        <c:set var="sightPoint" value="${MatchesPlayer.playInfo.sightPoint}" />
        <c:set var="getCoin" value="${MatchesPlayer.playInfo.getCoin}" />
        <c:set var="spendCoin" value="${MatchesPlayer.playInfo.spendCoin}" />
        <c:set var="spendConsumablesCoin" value="${MatchesPlayer.playInfo.spendConsumablesCoin}" />
        <c:set var="csCount" value="${MatchesPlayer.playInfo.sentinelKillCount + MatchesPlayer.playInfo.demolisherKillCount}" />
        <c:set var="PositionName" value="${MatchesPlayer.position.name}" />
        
        <div class="${teamColor}">
        <a href="/Cyphers/cyphersMain?username=${playerNickname}">${playerNickname}</a><br>
            <!-- 색인 유저당 관련 정보 출력 -->
     <c:choose>
    <c:when test="${PositionName eq '탱커' }">
       <img alt="포지션" src="/resources/img/3.png">
    </c:when>
    <c:when test="${PositionName eq '서포터' }">
    <img alt="포지션" src="/resources/img/4.png">
    </c:when>
    <c:when test="${PositionName eq '근거리딜러' }">
    <img alt="포지션" src="/resources/img/1.png">
    </c:when>
    <c:when test="${PositionName eq '원거리딜러' }">
    <img alt="포지션" src="/resources/img/2.png">
    </c:when>
	</c:choose>
            <img src="https://img-api.neople.co.kr/cy/characters/${characterId}">${characterName}<br>
            Lv.${level}<br>
            [K/D/A] [${killCount}/${deathCount}/${assistCount}]<br>
            준 피해량: <fmt:formatNumber value="${attackPoint}" pattern="#,##0"/> // 받은 피해량: <fmt:formatNumber value="${damagePoint}" pattern="#,##0"/><br>
            타워 공격량: <fmt:formatNumber value="${towerAttackPoint}" pattern="#,##0"/> // 전투참여: ${battlePoint} // 시야확보: ${sightPoint}<br>
            코인 흭득량: <fmt:formatNumber value="${getCoin}" pattern="#,##0"/> // 코인 소모량: <fmt:formatNumber value="${spendCoin}" pattern="#,##0"/> // 소모품 소비량: <fmt:formatNumber value="${spendConsumablesCoin}" pattern="#,##0"/><br>
            CS: ${csCount}<br>
            <!-- 파티원 검사 -->
            <c:forEach var="two" items="${MatchesINFO}">
                <c:if test="${matchesPlayerPartyId eq two.playInfo.partyId
                                && playerNickname ne two.nickname 
                                && matchesPlayerPartyId ne partyIdToExclude}">
                    (#파티:<a href="/Cyphers/cyphersMain?username=${two.nickname}">${two.nickname}</a>)
                </c:if>
            </c:forEach><!-- 파티원 검사 -->
            <!-- 색인 유저당 관련 정보 출력 -->
        </div>
    	</c:if>
		</c:forEach><!-- 개별 유저 정보 표시 반복문 종료 -->
				</div>
		</div><!-- warp_bot -->
</body>
</html>