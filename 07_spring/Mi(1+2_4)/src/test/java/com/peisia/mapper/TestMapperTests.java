package com.peisia.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peisia.spring.dto.TestDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//이 테스트 클래스는 스프링 프레임워크와 JUnit4를 함께 사용하여 테스트합니다.
@RunWith(SpringJUnit4ClassRunner.class)

//테스트를 위해 스프링의 설정 파일이 필요합니다. 
//이 설정 파일은 웹 애플리케이션의 루트 경로에 있는 특정 위치에 있습니다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

//해당 클래스에 대한 로깅 기능을 자동으로 추가할 수 있습니다.
@Log4j
public class TestMapperTests {
	
	//TestMapper.java(인터페이스)의 함수를 자식된 TestMapper.xml에서 재정의된 값으로 가져온다.
	@Setter(onMethod_ = @Autowired)
	private TestMapper mapper;
	
	@Test
	public void testGetList() {
		TestDto sData1 = mapper.getData1();
		TestDto sData2 = mapper.getData2();
		log.info(sData1);
		log.info(sData2);
		String s1 = sData1.getStr_data();
		String s2 = sData2.getStr_data();
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		int sum = n1 + n2;
		log.info("1+2 는 ==============:" + sum);
	}
	
}
