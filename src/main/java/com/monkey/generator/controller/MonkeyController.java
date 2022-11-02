package com.monkey.generator.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.monkey.generator.model.Bag;
import com.monkey.generator.model.Dict;
import com.monkey.generator.model.Luckgetmon;
import com.monkey.generator.model.Owner;
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
	public Object getDictList() {
		return luckgetmonService.getDictList();
	}
	
	@ApiOperation(value = "럭겟몬 정보 호출", notes = "럭겟몬 정보를 호출 한다.")
	@GetMapping(value="/getDict/{id}")
	@ResponseBody
	public Object getDict(@PathVariable("id") int id) {
		return luckgetmonService.getDict(id);
	}
	
	@ApiOperation(value = "럭겟몬 획득", notes = "해당 정보의 럭겟몬을 획득.")
	@PostMapping(value="/catchMon")
	@ResponseBody
	public Object catchMon(@RequestBody Luckgetmon mon) {
		luckgetmonService.catchLuckgetmon(mon);
		return "잡기 완료";
	}
	
	@ApiOperation(value = "럭겟몬 확인", notes = "해당 오너의 럭겟몬을 확인.")
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
	
	@ApiOperation(value = "트레이너 등록", notes = "럭겟몬 트레이터 등록.")
	@GetMapping(value="/newOwner")
	@ResponseBody
	public Object newOwner(String owner) {
		try {
			luckgetmonService.newOwner(owner);
			return "등록 완료";
		} catch (Exception e) {
			return "등록 실패";
		}
		
	}
	
	@ApiOperation(value = "아이템 리스트 확인", notes = "모든 아이템을 확인한다.")
	@GetMapping(value="/viewAllItems")
	@ResponseBody
	public Object viewAllItems() {
		return luckgetmonService.viewAllItems();
	}
	
	@ApiOperation(value = "내 아이템 리스트 확인", notes = "유저가 소유한 아이템을 확인한다.")
	@GetMapping(value="/viewMyItems")
	@ResponseBody
	public Object viewMyItems(String owner) {
		return luckgetmonService.viewMyItems(owner);
	}
	
	@ApiOperation(value = "아이템 획득 or 추가", notes = "유저에게 아이템을 획득 or 추가한다한다.")
	@GetMapping(value="/itemGetOrAdd")
	@ResponseBody
	public Object itemGetOrAdd(Bag bag) {
		int check = 0;
		Bag item_num = luckgetmonService.myItemCheck(bag);
		if(item_num.getCount()!=0 && bag.getEa()<0 && item_num.getEa() + bag.getEa()<0) {
			return "0개 이하 감소 불가";
		}
		if(item_num.getCount()==0) {
			if(bag.getEa()<0) {
				return "0개 이하 획득 불가";
			}
			check = luckgetmonService.insertItem(bag);
		} else {
			check = luckgetmonService.addItem(bag);
		}
		if(check == 0) {
			return "호출 실패";
		} else if(item_num.getCount()==0) {
			return "획득 성공";
		} else if(bag.getEa()<0) {
			return "감소 성공";
		} else {
			return "추가 성공";
		}
	}
	
	@ApiOperation(value = "럭겟몬 회복하기", notes = "모든 럭겟몬을 회복한다.")
	@GetMapping(value="/recoveryLuckgetmon")
	@ResponseBody
	public Object recoveryLuckgetmon(String owner) {
		int check = luckgetmonService.fullHpCheck(owner);
		if(check == 0) {
			return "체력 최대";
		} else {
			luckgetmonService.recoveryLuckgetmon(owner);
			return check;
		}
	}
	
	@ApiOperation(value = "럭겟몬 체력 설정", notes = "럭겟몬의 체력을 설정한다.")
	@GetMapping(value="/setHp")
	@ResponseBody
	public Object setHp(Luckgetmon luckgetmon) {
		luckgetmonService.setHp(luckgetmon);
		return "변경 완료";
	}
	
	@ApiOperation(value = "파일럿 클로버 추가", notes = "파일럿의 클로버를 더하거나 뺀다.")
	@GetMapping(value="/addMoney")
	@ResponseBody
	public Object addMoney(Owner owner) {
		luckgetmonService.addMoney(owner);
		return luckgetmonService.infoOwner(owner.getId());
	}
	
	@ApiOperation(value = "내 정보 보기", notes = "파일럿의 정보를 확인한다.")
	@GetMapping(value="/infoOwner")
	@ResponseBody
	public Object infoOwner(String owner) {
		return luckgetmonService.infoOwner(owner);
	}

}
