package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.peisia.google.GoogleSearchDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/Pr1/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌(@Auto.. 처럼)
@Controller
public class googleController {
	@RequestMapping("/Pr1_main")
	public void ffvixmain(@RequestParam("SearchQ") String SearchQ, Model model) {				
		String API_KEY = "AIzaSyAJ3ySaW26tlc1QrySK__0YcATBgUolbWI";									
		String API_ID = "05a3c017af122473a";									
		String API_Q = SearchQ;									
		String API_URL ="https://www.googleapis.com/customsearch/v1?key="+API_KEY+"&cx="+API_ID+"&q="+API_Q;
		log.info(API_URL);
	RestTemplate restTemplate = new RestTemplate();									
	
	//// **** 중요 **** uri									
	URI uri = null; //java.net.URI 임포트 하셈									
	try {									
		uri = new URI(API_URL);								
	} catch (URISyntaxException e) {									
		e.printStackTrace();								
	}			
	
	GoogleSearchDto google = restTemplate.getForObject(uri, GoogleSearchDto.class); // 자기 클래스로 바꾸시오..
	model.addAttribute("Search_main", google.queries.request);
	model.addAttribute("Search_items", google.items);
}
	
	@RequestMapping("/Pr1_Search")
	public void Pr1_search() {
	}	
}