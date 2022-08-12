package com.spring.dto;

import lombok.Data;

@Data
public class SampleDTO {
	
	private String id;
	private String pw;
	
	//원래였으면 getter, setter을 만들어야 함.
	//하지만 위에서 data를 어노테이션 함.
	// 자동으로 get, set 해줌.

}