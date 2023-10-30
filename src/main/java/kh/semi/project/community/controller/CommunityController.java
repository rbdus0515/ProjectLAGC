package kh.semi.project.community.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@SessionAttributes({"loginMember"})
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private CommunityService service;
	
	// 커뮤니티 페이지 이동
	@GetMapping("/communityPage")
	public String selectCommunityList(Model model) {
		
		List<Community> list = service.selectCommunityList();
		model.addAttribute("list", list);
		
		
		return "community/communityPage";
	}
	
	// 지역 조회 ajax
	@GetMapping("/selectLocal")
	@ResponseBody
	public List<Community> selectLocalList(String areaCode) {
		
		
		List<Community> list = new ArrayList<Community>();
		
		list = service.selectLocalList(areaCode);
		
		System.out.println(list);
		System.out.println(areaCode);
		
		
		return list;
	}
	
	// 커뮤니티 추가
	@PostMapping("/insertCom")
	public String insertCom(Community inputCom, @SessionAttribute("loginMember") Member loginMember) {
		
		inputCom.setMemberNo(loginMember.getMemberNo());
		

		int result = service.insertCom(inputCom);
		
		return "redirect:/community/communityPage";
	}

}
