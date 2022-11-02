package com.monkey.generator.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.monkey.generator.model.Bag;
import com.monkey.generator.model.Dict;
import com.monkey.generator.model.Item;
import com.monkey.generator.model.Luckgetmon;
import com.monkey.generator.model.Owner;



@Mapper
public interface LuckgetmonMapper {
	public List<Dict> getDictList();
	
	public Dict getDict(int id);
	
	public void catchLuckgetmon(Luckgetmon luckgetmon);
	
	public List<Luckgetmon> viewMyLuckgetmon(String owner);
	
	public int changeNickname(Luckgetmon luckgetmon);
	
	public int changeOwner(Map<String, Object> info);
	
	public void newOwner(String owner);
	
	public Owner infoOwner(String owner);
	
	public List<Item> viewAllItems();
	
	public Bag myItemCheck(Bag bag);
	
	public int insertItem(Bag bag);
	
	public int addItem(Bag bag);
	
	public List<Item> viewMyItems(String owner);
	
	public void addMoney(Owner owner);
	
	public int recoveryLuckgetmon(String owner);
	
	public int fullHpCheck(String owner);
	
	public void setHp(Luckgetmon luckgetmon);
}
