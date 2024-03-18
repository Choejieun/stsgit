package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.KWeatherDto;
import com.peisia.dto.MemberDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/weaher/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌(@Auto.. 처럼)
@Controller
public class WeaherController {
//	}
	
//	private GuestService service;
	
	   // currentPage와 함께 페이지 링크 수를 직접 전달
	@RequestMapping("/apitest")
	public void w() {										
		//// 우리나라 공공 api ////									
		//인코딩 인증키									
		String API_KEY = "TDf%2Fho9nOMC2Ho71ocCWLwhwgKl9KBhSyyX67Pylaw%2BN0V7GQsIt%2B7UaJQsN9X%2FrpsIc%2FJJR%2Bltqo30nKyUXjA%3D%3D";									
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20230220&endDt=20230220&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;									
				// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.							
		RestTemplate restTemplate = new RestTemplate();									
											
		//// **** 중요 **** uri									
		URI uri = null; //java.net.URI 임포트 하셈									
		try {									
			uri = new URI(API_URL);								
		} catch (URISyntaxException e) {									
			e.printStackTrace();								
		}									
											
//		String s = restTemplate.getForObject(uri, String.class); //									
//		log.info("====== 우리나라 날씨 잘 나오나? "+s);					
		KWeatherDto kw = restTemplate.getForObject(uri, KWeatherDto.class); // 자기 클래스로 바꾸시오..
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);									
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);									
		String location = kw.response.body.items.item.get(0).stnNm;	// "get" 데이터 구조(리스트, 배열 등) 특정 요소 가져오는 메서드
		String tMin = kw.response.body.items.item.get(0).minTa;									
		String tMax = kw.response.body.items.item.get(0).maxTa;									
		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);									
		log.info(ddara);									
		
	}										
    
    @GetMapping("/loginProc")
    public void regProc(MemberDto m, HttpSession session) {
    }
	
}