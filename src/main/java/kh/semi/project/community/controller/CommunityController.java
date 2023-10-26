package kh.semi.project.community.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.semi.project.community.model.dto.Community;
import kh.semi.project.community.model.service.CommunityService;
import kh.semi.project.member.model.dto.Member;

@Controller
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	@GetMapping("/communityPage")
	public String selectCommunityList(Model model) {
		
		List<Community> list = service.selectCommunityList();
		model.addAttribute("list", list);
		
		
		return "community/communityPage";
	}
	
	@GetMapping("/selectLocal")
	@ResponseBody
	public List<Community> selectLocalList(String areaCode) {
		
		
		List<Community> list = new ArrayList<Community>();
		
		list = service.selectLocalList(areaCode);
		
		
		return list;
	}

}
