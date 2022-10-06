package com.monkey.generator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonInclude;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @JsonInclude(JsonInclude.Include.NON_NULL)
public class Pagenation {
	@Min(value = 10, message = "10에서 100 사이의 숫자를 입력해 주세요.")
	@Max(value = 100, message = "10에서 100 사이의 숫자를 입력해 주세요.") // 1.아파트 2.빌라 3.오피스텔
	@ApiModelProperty(value = "페이지당 보여주는 값의 갯수", allowableValues = "010,025,050,100", example = "010")
	private Integer limit;
	@ApiModelProperty(hidden = true)
	private Integer offset;
	@ApiModelProperty(value = "페이지", example = "0")
	@Positive(message = "1 이상의 숫자를 입력해주세요")
	private int page;
	@ApiModelProperty(hidden = true)
	private int totalPage;
	@ApiModelProperty(hidden = true)
	private String order;
	@NotNull(message = "건축물 형태를 입력해주세요.")
	@Min(value = 1, message = "1에서 3 사이의 숫자를 입력해 주세요.")
	@Max(value = 3, message = "1에서 3 사이의 숫자를 입력해 주세요.") // 1.아파트 2.빌라 3.오피스텔
	@ApiModelProperty(value = "건축물 형태 - 1.아파트 2.빌라 3.오피스텔", allowableValues = "1,2,3", example = "1")
	private int building_type;
	@NotNull(message = "대출 용도를 입력해주세요.")
	@Min(value = 1, message = "1에서 4 사이의 숫자를 입력해 주세요.")
	@Max(value = 4, message = "1에서 4 사이의 숫자를 입력해 주세요.") // 1.구입자금 2.생활자금(퇴거자금) 3.전세자금 4.사업자금
	@ApiModelProperty(value = "대출 용도 - 1.구입자금 2.생활자금(퇴거자금) 3.전세자금 4.사업자금", allowableValues = "1,2,3,4", example = "1")
	private int loan_use;
	
	public Pagenation() {
		this.limit = 10;
		this.offset = 0;
		this.page = 1;
	}
	
	public Pagenation(int limit, int offset, int page) {
		this.limit = limit;
		this.offset = offset;
		this.page = page;
	}
	
	public Pagenation(int building_type, int loan_use) {
		this.limit = 10;
		this.offset = 0;
		this.page = 1;
		this.building_type = building_type;
		this.loan_use = loan_use;
	}
	
	
	public Pagenation(int limit, int offset, int page, int building_type, int loan_use) {
		this.limit = limit;
		this.offset = offset;
		this.page = page;
		this.building_type = building_type;
		this.loan_use = loan_use;
	}
	


}
