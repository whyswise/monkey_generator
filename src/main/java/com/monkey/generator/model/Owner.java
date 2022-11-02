package com.monkey.generator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {
	private String id;
	private int luck;
	private int clover;
	private int tired;
	private boolean badge1;
	private boolean badge2;
	private boolean badge3;
}
