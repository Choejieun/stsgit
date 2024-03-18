package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.cyphers.matches.moreInfo.CyphersDtoMatchesINFO;
import com.peisia.cyphers.playeridLoad.CyphersDtoPlayer;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Tourism/*") // 프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.
@AllArgsConstructor // 필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리
					// 해줌(@Auto.. 처럼)
@Controller
public class TourismController {
	@GetMapping("/TourismMain")
	public void cyphersSearchPage() {
		String API_KEY = "7ff23dcb-37e8-44e9-989e-f18780fc8ed4";
//	    String MATCHES_URL = "ㅇㅇ" + API_KEY;
		
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = null;
	    //매치상세 정보 가져오기
	    CyphersDtoMatchesINFO cyM = restTemplate.getForObject(uri, CyphersDtoMatchesINFO.class);
	}
	@GetMapping("/null")
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