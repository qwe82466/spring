package com.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleTV;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


//4.의존성 주입
@Controller
@RequestMapping("/sample4/*")
@Log4j
public class SampleController4 {
	//기존 방식으로 객체 생성
	
	
	//새로운방식
	// 이 어노테이션 붙으면 자동으로 주입된다. (무조건은 아님...-> 주입받으려면 bean으로 등록해놨어야함)
	//객체 생성은 xml 파일에 <bean>으로 등록하여, 스프링의 BeanFactory가 생성/관리하도록   해당 스프링빈(객체)이 필요한 
	//곳에서 주입반다(빌려와서) 사용가능하도록 되어있다.
	//@Autowirted : 의존성 자동 주입 ->root-context.xml 에서! 데려오는 것
			//1. 변수의 타입과 같은 빈이 있으면 주입 (변수이름x)
			//2. 같은 타입의 빈이 여러개 있다면, bean의 id 속성값과 변수명이 동일한것을 주입해줌.
	/*@Autowired
	private Date day = null;
	@Autowired
	private Date day2 = null;
	*/
	@Autowired
	private SampleTV tv =null;
	//@Setter(onMethod_=@Autowired)
	
	@RequestMapping("test")
	public String test() {
		//hello= new Date();
		log.info("test요청");
		//log.info(day);
		//log.info(day2);
		//tv.setPower(true);
		//tv.setCh(10);
		//tv.setCol("blue");
		
		log.info(tv.isPower()); //boolean 타입이라 ispower
		log.info(tv.getCh());
		log.info(tv.getCol());
		log.info(tv.getReg());
		return "sample/test";
	}
	
	@GetMapping("form")
	public String form() {
		log.info("form요청!!!");
		return "sample/form";
	}
	@PostMapping("login")
	public String login( SampleDTO dto) {
		log.info("login post요청!!!");
		log.info(dto.getId());
		log.info(dto.getPw());
		return "redirect:/sample4/test";
	}
	
	
	
}
