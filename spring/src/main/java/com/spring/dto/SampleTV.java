package com.spring.dto;



import java.beans.ConstructorProperties;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data //기본생성자 개터 세터 투스트링 여러가지 자동으로 생성 , 롱복쓰는듯
@Getter @Setter @ToString //@NoArgsConstructor//기본생성자
//@AllArgsConstructor //모든 변수를 매개변수로 갖는 생성자 
@RequiredArgsConstructor  //특정변수를 생성자  매개변수로 갖게 만들고, @nonnull 이나 final일경우 매개변수로 포함된다
public class SampleTV {
	
	@NonNull
	private boolean power;
	@NonNull
	private int ch;
	private final String col;
	private Date reg;

	/*
	public SampleTV() {}
	
	@ConstructorProperties({"power","ch","col","reg"}) //원래 이름무시하는데 이렇게 하면 변수이름까지 컴파일된다
	public SampleTV( boolean power, int ch, String col, Date reg) {
		this.power = power; this.ch= ch; this.col=col; this.reg=reg;
	}
	
	*/
	
	
	
	
	
	

}
