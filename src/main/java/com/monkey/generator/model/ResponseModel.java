package com.monkey.generator.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ResponseModel {
	@ApiModelProperty(example = "상태코드")
	private int status;
	@ApiModelProperty(example = "결과")
	private boolean result;
	@ApiModelProperty(example = "메세지")
	private String message;
	@ApiModelProperty(example = "에러")
	private List<String> error;
	@ApiModelProperty(example = "데이터")
	private Object data;

	public ResponseModel(int status, boolean result, String message, List<String> error) {
		this.status = status;
		this.result = result;
		this.message = message;
		this.error = error;
	}
	
	public ResponseModel(int status, boolean result, String message, Object data) {
		this.status = status;
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public ResponseModel(int status, boolean result, String message) {
		this.status = status;
		this.result = result;
		this.message = message;
	}
}
