package com.monkey.generator.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
//@JsonInclude(JsonInclude.Include.NON_NULL) null이 아닌 것만 포함
//ALWAYS : 속성의 값에 의존하지 말고 항상 포함
//NOT_EMPTY : null 또는 값이 빈 경우가 아니면 포함
//NOT_NULL : null 이 아니면 포함
//NOT_DEFAULT : bean의 기본생성자로 정의된 필드값과 다르게 변경된 필드만 포함
public class Json {
	private int id;
	private String name;
	private String data;
	@JsonIgnore // json return에 포함되지 않음
	private String jsonignore;
	@JsonProperty(value = "변경된 값")//해당 값으로 변경되서 포함
	private String jsonproperty;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date createdDate;
	
}
