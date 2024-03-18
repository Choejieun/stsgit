package com.peisia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.Cat;

@RequestMapping("/api/*")
@RestController
public class ApiCatController {
	@GetMapping("/catOne")			
	public Cat getCatOne() {			
		Cat cat = new Cat();		
		cat.setName("야옹ddd이");		
		cat.setHi("나는 안녕이다옹~");
		cat.setAge(5);		
				
		//이렇게 객체를 리턴하면 json 이 객체 구조로 해서 자동으로 출력됨. 		
		//즉, 이 주소로 api 요청을 하면 		
		//고양이 이름, 나이 json을 받아갈 수 있게 되는 것.		
		return cat; 		
	}			
	@GetMapping("/catTwo")			
	public Cat getCatTwo() {			
		Cat cat = new Cat();		
		cat.setName("떼껄룩");		
		cat.setAge(10);		
		return cat;		
	}
	@GetMapping("/dogOne")			
	public Cat getDogOne() {			
		Cat cat = new Cat();		
		cat.setName("강gd임");		
		cat.setAge(101);		
		return cat;		
	}
	
	@GetMapping("/box0")			
	public Cat getBox0() {
		Cat cat = new Cat();		
		cat.setName("box0.png");		
		cat.setAge(0);		
		return cat;		
	}
	@GetMapping("/box1")			
	public Cat getBox1() {
		Cat cat = new Cat();		
		cat.setName("box1.jpg");		
		cat.setAge(0);		
		return cat;		
	}
	@GetMapping("/box2")			
	public Cat getBox2() {
		Cat cat = new Cat();		
		cat.setName("box2.jpg");		
		cat.setAge(0);		
		return cat;		
	}
	@GetMapping("/box3")			
	public Cat getBox3() {
		Cat cat = new Cat();		
		cat.setName("box3.jpg");		
		cat.setAge(0);		
		return cat;		
	}
	
}