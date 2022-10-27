package com.monkey.generator.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.monkey.generator.model.Luckgetmon;
import com.monkey.generator.service.LuckgetmonService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@Controller
public class MonkeyController {
	
	@Autowired
	LuckgetmonService luckgetmonService;
	
	@ApiIgnore
	@RequestMapping(value="/")
	public String index(ModelMap model, HttpSession session) {
		return "home";
	}
	
	@ApiIgnore
	@PostMapping(value="/event")
	@ResponseBody
	public String events(String title, String content, String reply, String addr, String banana, String rt, String tag) {
		StringBuilder sb = new StringBuilder();
		sb.append("```@everyone<br>**[");
		sb.append(title);
		sb.append("]**<br><br>");
		sb.append(content.replace("\n","<br>"));
		sb.append("<br><br>**+");
		sb.append(banana);
		sb.append("BANANA:banana:**<br>:one:");
		sb.append(rt);
		sb.append("<br>:two:");
		sb.append(reply);
		if(!"".equals(tag)) {
			sb.append(" 다음 태그 포함 : `");
			sb.append(tag);
		}
		sb.append("`<br>:three:#🎫ㅣ이벤트채굴 에 링크 투척 ㄱ ㄱ<br><br>");
		sb.append(addr);
		sb.append("```");
		
		
		return sb.toString();
	}
	
	@ApiOperation(value = "럭겟몬도감 정보 호출", notes = "럭겟몬도감을 호출 한다.")
	@GetMapping(value="/getDict")
	@ResponseBody
	public Object getDict() {
		return luckgetmonService.getDict();
	}
	
	@ApiOperation(value = "럭겟몬 획득", notes = "해당 정보의 럭겟몬을 획득.")
	@PostMapping(value="/catchMon")
	@ResponseBody
	public Object catchMon(@RequestBody Luckgetmon mon) {
		luckgetmonService.catchLuckgetmon(mon);
		return "잡기 완료";
	}
	
	@ApiOperation(value = "럭겟몬 확인", notes = "해당 오너의 럭겟몬을 획득.")
	@GetMapping(value="/viewMyLuckgetmon")
	@ResponseBody
	public Object viewMyLuckgetmon(String owner) {
		return luckgetmonService.viewMyLuckgetmon(owner);
	}
	
	@ApiOperation(value = "럭겟몬 별명 변경", notes = "해당 럭겟몬의 별명을 변경.")
	@GetMapping(value="/changeNickname")
	@ResponseBody
	public Object changeNickname(Luckgetmon luckgetmon) {
		if(luckgetmonService.changeNickname(luckgetmon) == 0) {
			return "변경 실패";
		} else {
			return "변경 성공";
		}
	}
	
	@ApiOperation(value = "럭겟몬 소유 변경", notes = "해당 럭겟몬의 소유자를 변경.")
	@GetMapping(value="/changeOwner")
	@ResponseBody
	public Object changeOwner(Luckgetmon luckgetmon, String new_owner) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("luckgetmon", luckgetmon);
		map.put("new_owner", new_owner);
		if(luckgetmonService.changeOwner(map) == 0) {
			return "변경 실패";
		} else {
			return "변경 성공";
		}
	}

}
