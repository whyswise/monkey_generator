package com.monkey.generator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkey.generator.model.Bag;
import com.monkey.generator.model.Dict;
import com.monkey.generator.model.Item;
import com.monkey.generator.model.Luckgetmon;
import com.monkey.generator.model.Owner;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LuckgetmonService implements LuckgetmonMapper{
	
	@Autowired
	private LuckgetmonMapper luckgetmonMapper;
	
	public List<Dict> getDictList() {
		return luckgetmonMapper.getDictList();
	}
	
	public Dict getDict(int id) {
		return luckgetmonMapper.getDict(id);
	}
	
	public void catchLuckgetmon(Luckgetmon luckgetmon) {
		luckgetmonMapper.catchLuckgetmon(luckgetmon);
	}
	
	public List<Luckgetmon> viewMyLuckgetmon(String owner) {
		return luckgetmonMapper.viewMyLuckgetmon(owner);
	}
	
	public int changeNickname(Luckgetmon luckgetmon) {
		return luckgetmonMapper.changeNickname(luckgetmon);
	}
	
	public int changeOwner(Map<String, Object> info) {
		return luckgetmonMapper.changeOwner(info);
	}
	
	public void newOwner(String owner) {
		luckgetmonMapper.newOwner(owner);
	}
	
	public Owner infoOwner(String owner) {
		return luckgetmonMapper.infoOwner(owner);
	}
	
	public List<Item> viewAllItems() {
		return luckgetmonMapper.viewAllItems();
	}

	public Bag myItemCheck(Bag bag) {
		return luckgetmonMapper.myItemCheck(bag);
	}
	
	public int insertItem(Bag bag) {
		return luckgetmonMapper.insertItem(bag);
	}
	
	public int addItem(Bag bag) {
		return luckgetmonMapper.addItem(bag);
	}
	
	public List<Item> viewMyItems(String owner) {
		return luckgetmonMapper.viewMyItems(owner);
	}
	
	public void addMoney(Owner owner) {
		luckgetmonMapper.addMoney(owner);
	}
	
	public int recoveryLuckgetmon(String owner) {
		return luckgetmonMapper.recoveryLuckgetmon(owner);
	}
	
	public int fullHpCheck(String owner) {
		return luckgetmonMapper.fullHpCheck(owner);
	}
	
	public void setHp(Luckgetmon luckgetmon) {
		luckgetmonMapper.setHp(luckgetmon);
	}

}
