package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.service.TestService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/test/*")
//@AllArgsConstructor
@Controller
public class TestController {
		
	@Setter(onMethod_ = @Autowired)
	private TestService service;
	//작업자
	
	@GetMapping("/getOnePlusTwo")
	public void getOnePlusTwo(Model model) {
//	public void getOnePlusTwo() {
		log.info("getOnePlusTwo ==========================================");
		String one = service.getOne();
		String two = service.getTwo();
		Integer sum = Integer.parseInt(one) + Integer.parseInt(two); 
		
		log.info("(여기 컨트롤러임) 1 더하기 2는 = " + sum);
		log.info("수정됨=-- " + sum);
		System.out.println("똥싸개");
		
		model.addAttribute("sum",sum);
//		Model 인터페이스를 구현한 객체입니다.
//		"addAttribute()" 메서드는 뷰로 전달할 데이터를 추가하는 메서드입니다.
//		model.addAttribute("매개변수(데이터 이름orKey)",실제 데이터); --- 데이터를 뷰로 전달
//		"${sum}"과 같은 형태로 사용하여 화면에 값을 표시할 수 있습니다.
	}
}
