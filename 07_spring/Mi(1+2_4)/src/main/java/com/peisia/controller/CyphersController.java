package com.peisia.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.cyphers.CyphersDto;
import com.peisia.cyphers.matches.CyphersDtoMatches;
import com.peisia.cyphers.matches.moreInfo.CyphersDtoMatchesINFO;
import com.peisia.cyphers.playeridLoad.CyphersDtoPlayer;
import com.peisia.cyphers.playeridLoad.Record;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Cyphers/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리
					// 해줌(@Auto.. 처럼)
@Controller
public class CyphersController {
	@RequestMapping("/cyphersMain")
	public void w(@RequestParam("username") String username, Model model) {
		// 인코딩 인증키
		String API_KEY = "QZNxtZj4eZAuCVAfEsVqj74eoKKS4SCO";

		String SEARCH_ID = username;
		log.info("현재입력된 이름 =======" + SEARCH_ID);
		String ID_URL = null;
		try {
			String encodedSearchId = URLEncoder.encode(SEARCH_ID, "UTF-8");
			ID_URL = "https://api.neople.co.kr/cy/players?nickname=" + encodedSearchId + "&wordType=full&apikey="
					+ API_KEY;                                                                                                               
			log.info("========" + ID_URL);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		RestTemplate restTemplate = new RestTemplate();
		//// **** 중요 **** uri
		URI uri2 = null; // java.net.URI 임포트 하셈
		try {
			uri2 = new URI(ID_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		CyphersDto cy = restTemplate.getForObject(uri2, CyphersDto.class); // 자기 클래스로 바꾸시오..
		String PLAYER_ID = cy.rows.get(0).playerId; // 유저 id 코드 api에서 따오기
		String API_URL = "https://api.neople.co.kr/cy/players/" + PLAYER_ID + "?apikey=" + API_KEY; // 유저 기본정보

		// 현재 시간을 가져옵니다.
		LocalDateTime now = LocalDateTime.now();
		// 날짜와 시간을 문자열로 변환합니다.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
		String endDate = now.format(formatter);

		// 30일 전 날짜를 계산합니다.
		LocalDateTime startDate = now.minusDays(90);
		// 날짜와 시간을 문자열로 변환합니다.
		String StartDate = startDate.format(formatter);

		String API_MATCHES_URL = "https://api.neople.co.kr/cy/players/" + PLAYER_ID + "/matches?" // 유저 매치정보
				+ "gameTypeId=normal" + "&startDate=" + StartDate + "&endDate=" + endDate + "&limit=100"
//				+ "&next=null"
				+ "&apikey=" + API_KEY;
		log.info(API_MATCHES_URL);

		//// **** 중요 **** uri
		URI uri = null; // java.net.URI 임포트 하셈
		URI uriMatches = null; // java.net.URI 임포트 하셈
		try {
			uri = new URI(API_URL);
			uriMatches = new URI(API_MATCHES_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String s = restTemplate.getForObject(uri, String.class); //
		String ss = restTemplate.getForObject(uriMatches, String.class); //
		log.info("====== 유저정보 " + s);
		log.info("====== 매치정보 " + ss);

		// 입력된 유저의 정보를 최정적으로 출력하는 문구
		CyphersDtoPlayer cyPlayer = restTemplate.getForObject(uri, CyphersDtoPlayer.class); // 자기 클래스로 바꾸시오..
		CyphersDtoMatches cyMatches = restTemplate.getForObject(uriMatches, CyphersDtoMatches.class); // 자기 클래스로 바꾸시오..

		// 각 매치 정보 가져오기(파티원,승리 패배)
		if ("normal".equals(cyMatches.matches.gameTypeId)) {
			model.addAttribute("PartyInfoArray", cyMatches.matches.rows);
		}

		// 유저정보 확인
		String nickname = cyPlayer.nickname; // 닉네임
		model.addAttribute("nickname", nickname);
		int grade = cyPlayer.grade; // 급수
		model.addAttribute("grade", grade);
		String characterName = cyPlayer.represent.characterName; // 대표캐릭터
		String characterID = cyPlayer.represent.characterId; // 대표캐릭터
		model.addAttribute("characterName", characterName);
		model.addAttribute("characterId", characterID);
		String clanName = cyPlayer.clanName; // 클랜명
		model.addAttribute("clanName", clanName);

// 현재 시즌 일반전
		for (Record record : cyPlayer.records) {
			if ("normal".equals(record.gameTypeId)) {
				model.addAttribute("normalWin", record.winCount);
				model.addAttribute("normalLose", record.loseCount);
				model.addAttribute("normalStop", record.stopCount);
				double  wincount = record.winCount;
				double  totalcount = record.loseCount+record.winCount+record.stopCount;
				model.addAttribute("normalRate", (int)((wincount/totalcount)*100)+" %"); //승률 구하는 식
				break;
			}
		}
// 현재 시즌 공식전
		for (Record record : cyPlayer.records) {
			if ("rating".equals(record.gameTypeId)) {
				model.addAttribute("ratingWin", record.winCount);
				model.addAttribute("ratingLose", record.loseCount);
				model.addAttribute("ratingStop", record.stopCount);
				break;
			} else {
				model.addAttribute("ratingWin", "/");
				model.addAttribute("ratingLose", "/");
				model.addAttribute("ratingStop", "/");
			}
		}

	}

	@GetMapping("/cyphersSearch")
	public void cyphersSearchPage() {
	}

	@GetMapping("/cyphersMatchINFO")
	public void cyphersMatchINFO(@RequestParam("matches") String matches, Model model) {
	    String API_KEY = "QZNxtZj4eZAuCVAfEsVqj74eoKKS4SCO";
	    String MATCHES_ID = matches;
	    String MATCHES_URL = "https://api.neople.co.kr/cy/matches/" + MATCHES_ID + "?&apikey=" + API_KEY;

	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = null;

	    try {
	        uri = new URI(MATCHES_URL);
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }

	    String s = restTemplate.getForObject(uri, String.class);
	    log.info("====== 매치 상세 정보 " + s);
	    
	    //매치상세 정보 가져오기
	    CyphersDtoMatchesINFO cyM = restTemplate.getForObject(uri, CyphersDtoMatchesINFO.class);
	     
	    //개별 요약용
	    model.addAttribute("MatchesINFO", cyM.players);
//	    model.addAttribute("attribute", cyM.players.get(0).position.attribute);
	    log.info(cyM.players.get(0).position.name);
	    
	    //상단 요약용 색인
	    for (int i = 0; i < 2; i++) {
	        String teamKey = "Team_" + i; 									//★★★★★
	        String teamPlayersKey = "Team_get" + i + "_";

	        model.addAttribute(teamKey, cyM.teams.get(i).result);
	        
	        for (int k = 0; k < 10; k++) {
        	String characterId = "characterId_" + k; 	
        	String characterName = "characterName_" + k; 	
        	String nowCharacterPL = "nowCharacterPL_" + k; 	
        	log.info("캐릭터 상세+코드"+cyM.players.get(k).playInfo.characterId);
        	log.info("캐릭터 상세+이름"+characterName+"::"+cyM.players.get(k).playInfo.characterName);
	        model.addAttribute(characterId, cyM.players.get(k).playInfo.characterId);
	        model.addAttribute(characterName, cyM.players.get(k).playInfo.characterName);
	        model.addAttribute(nowCharacterPL, cyM.players.get(k).nickname);
	        }
	        for (int j = 0; j < 5; j++) {
	            String playerKey = teamPlayersKey + j + "_ID";
	            String playerId = cyM.teams.get(i).players.get(j);
	            String API_URL = "https://api.neople.co.kr/cy/players/" + playerId + "?apikey=" + API_KEY;
	            URI playerUri = null;

	            try {
	                playerUri = new URI(API_URL);
	            } catch (URISyntaxException e) {
	                e.printStackTrace();
	            }
	            
	    	    //유저검색 도움
	            CyphersDtoPlayer playerDTO = restTemplate.getForObject(playerUri, CyphersDtoPlayer.class);
	            model.addAttribute(playerKey, playerDTO.nickname);
	            
	            
	        }
	    }
	}

}