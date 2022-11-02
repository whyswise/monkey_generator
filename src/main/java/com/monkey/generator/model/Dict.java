package com.monkey.generator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class Dict {
	private int id;
	private String name;
	private String type;
	private String type2;
	private String place;
	private int h;
	private int a;
	private int b;
	private int c;
	private int d;
	private int s;
	private Integer max_h;
	private Integer max_a;
	private Integer max_b;
	private Integer max_c;
	private Integer max_d;
	private Integer max_s;
}
