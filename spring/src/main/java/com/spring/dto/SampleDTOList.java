package com.spring.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleDTOList {
	
	
	// SampleDTO 객체를 여러개 담는 리스트를 변수라 갖는 DTO
	private List<SampleDTO> list;
	// 
	
	public SampleDTOList() {
		list = new ArrayList<SampleDTO>();
	}
}