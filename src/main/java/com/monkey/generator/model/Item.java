package com.monkey.generator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
	private int id;
	private String item_name;
	private String description;
	private int price;
	private int cashprice;
	private int ea;
	private String owner;
}
