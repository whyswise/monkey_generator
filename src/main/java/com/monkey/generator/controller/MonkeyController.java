package com.monkey.generator.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MonkeyController {
	
	@RequestMapping(value="/")
	public String index(ModelMap model, HttpSession session) {
		return "home";
	}
	
	@PostMapping(value="/event")
	@ResponseBody
	public String events(String title, String content, String reply, String addr, String banana, String rt, String tag) {
		StringBuilder sb = new StringBuilder();
		sb.append("@everyone<br>**[");
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
		
		
		return sb.toString();
	}
	
	

}
