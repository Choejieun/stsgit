package com.peisia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peisia.dto.MemberDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/login/*")	//프로젝트 루트 경로 이하 /guest 상위폴더로 진입 시 여기로 진입하게 됨.  
@AllArgsConstructor	//필드 값을 매개변수로 하는 생성자를 스프링이 알아서 만들어 줌. 그리고 그런 형태의 생성자를 추가하면 스프링이 알아서 객체관리 해줌(@Auto.. 처럼)
@Controller
public class loginController {
//	}
	
//	private GuestService service;
	
	   // currentPage와 함께 페이지 링크 수를 직접 전달
    @GetMapping("/loginFom")
    public void regFom() {
    	
    }
    
    @GetMapping("/loginProc")
    public void regProc(MemberDto m, HttpSession session) {
    	String id =m.getId();
    	log.info("[로그인]========== id :"+id+"===pw:"+m.getPw());
    	session.setAttribute("id", id);
    }
	
}