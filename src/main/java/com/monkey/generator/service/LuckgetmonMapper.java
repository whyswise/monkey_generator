package com.monkey.generator.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.monkey.generator.model.Dict;
import com.monkey.generator.model.Luckgetmon;



@Mapper
public interface LuckgetmonMapper {
	public List<Dict> getDict();
	
	public void catchLuckgetmon(Luckgetmon luckgetmon);
	
	public List<Luckgetmon> viewMyLuckgetmon(String owner);
	
	public int changeNickname(Luckgetmon luckgetmon);
	
	public int changeOwner(Map<String, Object> info);
}
