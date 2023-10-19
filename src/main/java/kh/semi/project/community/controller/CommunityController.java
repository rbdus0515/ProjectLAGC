package kh.semi.project.community.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.semi.project.community.model.dto.Community;
import kh.semi.project.community.model.service.CommunityService;

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
}
