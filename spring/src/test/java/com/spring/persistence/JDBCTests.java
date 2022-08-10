package com.spring.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
/*
 	@RunWith : 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 표시함
 			JUnit 테스트할때 어플리케이션컨텍스트 만들고 관리해주는 작업 진행.
 			테스트환경을 개별적으로 만들어줌(오프라인)
*/
//@RunWith(SpringJUnit4ClassRunner.class)


//JDBC 연동 테스트 클래스
@Log4j // 콘솔에 화면찍는 거 가능
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		try(Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.250:1521:ORCL","java10","java10")){
			log.info(conn);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
}
