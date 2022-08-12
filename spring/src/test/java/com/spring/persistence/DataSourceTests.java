package com.spring.persistence;

import static org.junit.Assert.fail;


import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

/*
	@RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시함
			JUnit 테스트할때 어플리케이션컨텍스트 만들고 관리해주는 작업 진행.
			테스트환경을 개별적으로 만들어줌(오프라인)
	@ContextConfiguration: 지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링내에
		객체로 등록하게 해줌. (테스트시 필요한 설정파일 지정) ()안에 작성하는 문자열은 file 이나 classpath을 이용가능.
*/


@RunWith(SpringJUnit4ClassRunner.class)
//workspace에 저장된 파일경로
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Setter(onMethod_= @Autowired) // DI 의존성 주입기 (자동주입 받는 것)   === root-context에 있던 것
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		
		
	}

}
