package com.monkey.generator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Bag {
	private int id;
	private String owner;
	private int item;
	private int ea;
	private int count;
	
	public Bag(String owner, int item, int ea) {
		this.owner = owner;
		this.item = item;
		this.ea = ea;
	}
}
