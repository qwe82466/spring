package com.spring.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@Controller 선언시 컨트롤러 역할을 하는 클래스로 선언.
//자동으로 스프링객체(스프링 빈 == 객체 생성) 등록되게 해줌

@RequestMapping("/sample/*")
//해당 클래스 안에 있는 모든 주소 앞에 공통 주소로 적용
//실제로 들어오기 위해선 localhost:8080/sample/hello 로 들어와야함.
public class SampleController {

//메모 1
//mapping 주소 만들기
//해당 주소에서 처리해야 하는 기능들을 메서드들로 만들기
	
//주소 요청되었을때 해당 메서드로 들어가 기능 처리
	
	//---------------------------------------
	//매핑 메서드 작성 --> url 주소 localHost:8080/hello 로 들어옴
	//@RequestMapping("hello")
	//@RequestMapping(value="hello") 뒤에 메소드가 없으면 get,post 둘다 받음
	//@RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST}) get, post 둘다 받겠다 
	//@RequestMapping(value="hello")
	
	// sample/test sample/hello 둘다 일때 들어옴
	// 사실 둘다 페이지가 있을 수 있지면 hello이든 test 이든지간에 들어오면 hello 페이지로 보여주게됨
	//@RequestMapping({"hello","test"})	//hello, test 일때 들어옴
	
/*	public String hello() {
		System.out.println("hello 매핑 메서드 호출..");
		
		return "sample/hello";	//요청 들어왔을때 보여줘야 하는 view 이름 전달
	}*/
	
	//-----------------------------------------
	//주소의 경로를 String val에 담아주겠다
//	@RequestMapping("{test}")
//	public String hello(@PathVariable("test") String val) {
//		System.out.println("hello 매핑 메서드 호출..");
//		
//		System.out.println("test : " + val);
//		
//		return "sample/hello";	//요청 들어왔을때 보여줘야 하는 view 이름 전달
//	}
	
	//8080/sample/a or 8080/sample/b 등 한글자 요청하면 hello 로 이동
	// ? 갯수만큼 글자가 들어갈수 있음
	@RequestMapping("?")
	public String hello() {
		System.out.println("hello 매핑 메서드 호출..");
		
		return "sample/hello";	//요청 들어왔을때 보여줘야 하는 view 이름 전달
	}
	
	
	
	
	
	//쉬는시간 연습용
	@RequestMapping("hello2")
	public String hello2(Model model) {
		Date date = new Date();
		
		model.addAttribute("time", date);
		
		// views/sample/hello2.jsp 가아닌
		// views/hello2.jsp 위치임.
		return "hello2";
	}
	
	@RequestMapping("hello3")
	public void hello3() {
		System.out.println("hello3...");
		//return type void
		//이 주소로 들어오기 위해서는 class에서 받았던 sample 을 쳐야함
		// 8080/sample/hello3
	}
	
	/*
	//와일드 카드로 URL 매핑
	@RequestMapping("*")
	public String hello4() {
		System.out.println("***************");
		
		return "sample/hello";
	}
	*/
	
	
	//get, post 둘다 가능
	//@RequestMapping("hello5")
	
	//아래에 post 로 보내게 되면 405 에러. 허용되지 않은 메소드
	@RequestMapping(value="helloGet",method = {RequestMethod.GET})
	public String helloGet() {
		System.out.println("helloGet method get..");
		return "sample/hello";
	}
	
	@RequestMapping(value="helloPost",method = {RequestMethod.POST})
	public String helloPost() {
		System.out.println("helloPost method post..");
		return "sample/hello";
	}
	
	//get으로 보내기 http://localhost:8080/sample/helloGetPost
	@GetMapping("helloGetPost")
	public String hetlloGet2() {
		System.out.println("helloGet2 method get");
		return "sample/hello";
	}
	
	//post으로 보내기 http://localhost:8080/sample/helloGetPost
	@PostMapping("helloGetPost")
	public String hetlloPost2() {
		System.out.println("helloPost2 method post");
		return "sample/hello";
	}
	//주소는 같지만 같은 클래스내에 같은 메소드가 있을수는 없기때문에 위와 같이 지정해줌..
	//get 으로 보내면 Line120. helloGet2 method get 출력
	//post으로 보내면 Line127. helloPost2 method post 출력
	
	
	
	
}