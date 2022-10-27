package com.monkey.generator.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monkey.generator.model.Dict;
import com.monkey.generator.model.Luckgetmon;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LuckgetmonService implements LuckgetmonMapper{
	
	@Autowired
	private LuckgetmonMapper luckgetmonMapper;
	
	public List<Dict> getDict() {
		return luckgetmonMapper.getDict();
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

}
