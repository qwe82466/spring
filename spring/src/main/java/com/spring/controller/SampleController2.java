package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleDTOList;
import com.spring.dto.SampleTV;

import lombok.extern.log4j.Log4j;

//컨트롤러 해야하기에 무조건 붙여주기
@Controller
//주소 다르게 설정해주기 8080/sample2/* 로 접속하기
//samplecontroller 에서도 hello가 있지만 
//여기서 sample2 로 선언했기 때문에 sample2/hello 로 접속하기에 충돌나지 않음
@RequestMapping("/sample2/*")
@Log4j
public class SampleController2 {

	// 8080/sample2/hello?id=java 로 보내기
	//	@RequestMapping("hello") 는 post와 get 둘다 받음.
	//	@RequestMapping(value="hello", method = RequestMethod.GET)
	//	혹은
	@GetMapping("hello")
	public String hello(String id) {
		System.out.println("ID : " + id);
		return "sample/test";
	}
	
	// 8080/sample2/hello?id=java&pw=1234 로 보내기
	@GetMapping("hello2")
	public String hello2(String id,String pw) {
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		
		System.out.println(pw+10);
		return "sample/test";
	}
	
	@GetMapping("helloGetDTO")
	public String hello3(SampleDTO dto) {
		System.out.println("ID : " + dto.getId());
		System.out.println("PW : " + dto.getPw());
		
	//	System.out.println(pw+10);
		return "sample/test";
	}
	@GetMapping("helloGetDTO2")
	public String hello4(SampleDTO dto, String id, int pw) {
		System.out.println("ID : " + dto.getId());
		System.out.println("PW : " + dto.getPw());
		
		System.out.println("PW.int : " + pw);
		
	//	System.out.println(pw+10);
		return "sample/test";
	}

	//8080/sample2/test2?name=AAA&age=10
	@RequestMapping("test2")
	public String test2(@RequestParam("name")  String name2,@RequestParam("age") int age2) {
		log.info("test2 매핑 메서드 실행");
		log.info("name : " + name2);
		log.info("age : " + age2);
		
		return "sample/test";
	}
	
	// 동일한 이름의 파라미터가 여러개 전달되는 경우 ArrayList, 배열 사용 가능
	// 리스트 파라미터
	// 8080/sample2/hello3?names=AAA&names=BBB&names=CCC
	@RequestMapping("hello3")
	public String hello3(@RequestParam("names") ArrayList<String> names) {
		
		log.info(names);
		
		return "sample/test";
	}
	
	//배열은 @RequestParam 어노테이션 생략 가능
	@RequestMapping("hello4")
	public String hellor(String[] names) {
			
		log.info(names);
		//INFO : com.fsp.controller.SampleController2 - [Ljava.lang.String;@6a285b2d
		//배열 값들을 보기 위해서는
		
		for(String s : names) {
			log.info(s);
		}
		
		return "sample/test";
	}
	
	//객체 리스트
	@RequestMapping("hello5")
	public String hello5(SampleDTOList list) {
		// 8080/sample2/hello5?list[0].id=AAA&list[1].id=BBB
		// 400에러...
		// 톰캣에서 [] 를 인식하지 못해 에러 --> 유니코드로 보내주기
		
		// [==%5B  ]==%5D 
		//8080/sample2/hello5?list%5B0%5D.id=AAA&list%5B1%5D.id=BBB
		
		log.info(list);
		//INFO : com.fsp.controller.SampleController2 - SampleDTOList(list=[SampleDTO(id=AAA, pw=null), SampleDTO(id=BBB, pw=null)])
		
		return "sample/test";
	}
	
	@RequestMapping("form")
	public String form() {
		
	
		return "sample/form";
	}
	
	@RequestMapping("pro")
	public String pro(String id, String pw, SampleDTO dto, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info(id);
		log.info(pw);
		log.info(dto.getId());
		
		
		//view에 데이터 전달
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		//request로 데이터 전달
		request.setAttribute("reqId", id);
		request.setAttribute("reqPw", pw);
		
		
		
		return "sample/pro";
	}
	
	
	//ModelAndView
	@RequestMapping("pro2")
	public ModelAndView pro2(String id, String pw, SampleDTO dto) {
		//객체생성
		ModelAndView mv = new ModelAndView();
		//view에 전달할 데이터 추가
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.addObject("dto",dto);
		//이동할 view 이름 추가
		mv.setViewName("sample/pro");
		
		return mv;
	}
	
	
	@RequestMapping("pro3")
	public String pro3(@ModelAttribute("dto") SampleDTO dto, @ModelAttribute("id") String id,@ModelAttribute("pw") String pw ) {
		
		
		return "sample/pro";
	}
	
	@RequestMapping("hello6")
	public String hello6() {
		log.info("hello6 매핑");
		
		return "sample/test";
	}
	
	/*
	@ModelAttribute("tv") //별칭tv 를 달아줌
	public void getTV(String col, Model model) {
		log.info("GETtv 호출!!");
		SampleTV tv = new SampleTV();
		tv.setPower(true);
		tv.setCol(col);
		tv.setCh(10);
		
		//모델에다가 여러개 데이터 추가
		model.addAttribute("tv1", tv); //이러면 모델 1,2 여러개 데이터 추가해주기(tv여러대 정보 보내기)
		model.addAttribute("tv2", tv);
		//return tv;
		
	}
	*/
	
	@RequestMapping("hello7")
	@ResponseBody  //body로 응답하겠다(즉 우리가 보는 화면)
					//jsp페이를 만들지도 않았는데 보디에 hello..!가나옴
					//데이터 요청할때 사용한다.
					//자바스크립트 이용하여 메세지 요청할때
					//view 페이지로 응답하는 것이 아니라 , 데이터 응답해줄 때 주로 사용 (ajax사용시 주로 사용)
	public String hello7() {
		
		
		
		return "hello..!";
		
	}
	
	
	
	//@RequestMapping("hello8")  //하나만적으면 필수적으로 옵션값으로...
	//@RequestMapping(value="hello8", params = "id=java")
								//파라미터에서 아이디가 꼭 자바값으로 와야함! 안그러면 안들어가짐
	//@RequestMapping(value="hello8", params = {"id=java", "pw=1234"}) //꼭 java 1234가 와야함
	//@RequestMapping(value="hello8", params = {"id=java", "pw"})  // 꼭 java 하지만 비번은 아무거나 가능 단, 안보내면 안됨
																// 유효성 검사와 비슷하다.
	//@RequestMapping(value="hello8", params = {"id=admin", "pw" , "!age"}) //age오면 안됨
	@RequestMapping(value={"hello8","hello9"}, params = {"id=admin", "pw" , "!age"}, method= {RequestMethod.GET, RequestMethod.POST}) //hello9로 요청되도 된다. 배열값으로줌
	
	public String hello8() {
		//옵션들을 볼꺼에용? 읭?
		
		
		
		return "sample/test";
	}
	
	
	@RequestMapping("hello10")
	//public String hello10(@RequestParam(value="id", defaultValue ="lalalla") String msg) {
	
								//별명을 id로 붙여서 주소창에 msg말고 id로 해야함
								//파라미터에 아무것도 입력안했을 때 lalala 가 디폴트값
	//public String hello10(@RequestParam(value="id", required = true) String id) {
	public String hello10(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="pw", required = true)String pw,
			@RequestParam(value="auto", required = false, defaultValue = "0")String auto)	{
	
		log.info(id);
		log.info(pw);
		log.info(auto);
		
		return "sample/test";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}