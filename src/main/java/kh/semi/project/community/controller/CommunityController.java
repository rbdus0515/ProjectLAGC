package kh.semi.project.community.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import kh.semi.project.community.model.dto.CommunityComment;
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
		
//		System.out.println(list);
//		System.out.println(areaCode);
		
		
		return list;
	}
	
	// 커뮤니티 추가
	@PostMapping("/insertCom")
	public String insertCom(Community inputCom, @SessionAttribute("loginMember") Member loginMember) {
		
		inputCom.setMemberNo(loginMember.getMemberNo());
		

		int result = service.insertCom(inputCom);
		
		return "redirect:/community/communityPage";
	}
	
	// 모달창 조회
	@GetMapping("/modal")
	@ResponseBody
	public Map<String, Object> selectCCommentList(int communityNo) {
		
//		System.out.println("communityNo : " + communityNo);
		
	
		// 커뮤
		List<Community> selectComList = new ArrayList<Community>();
		
		selectComList = service.selectComList(communityNo);
		
		// 조회수 + 1
		int readCountUp = selectComList.get(0).getReadCount();	
		int newReadCountNo = readCountUp + 1;
		selectComList.get(0).setReadCount(newReadCountNo);
		
		int selectedCommunityNo = selectComList.get(0).getCommunityNo();
		
//		System.out.println(newReadCountNo);
//		System.out.println(selectedCommunityNo);
		
		Map<String, Object> readMap = new HashMap<String, Object>();
		
		readMap.put("communityNo", selectedCommunityNo);
		readMap.put("readCount", newReadCountNo);
		
//		System.out.println(readMap);
		
		int result = service.readCountPlus(readMap);
		
//		System.out.println(result);
		
		
		// 댓글
		List<CommunityComment> ccomentList = new ArrayList<CommunityComment>();
			
		ccomentList = service.selectCCommentList(communityNo);
			
//		System.out.println("ccomentList : " + ccomentList);
		
		
		// 본문 + 댓글 -> JSON 으로 변경
		Map<String, Object> comboMap = new HashMap<String, Object>();
		
		comboMap.put("selectComList", selectComList);
		comboMap.put("ccomentList", ccomentList);
		
//		System.out.println("comboMap" + comboMap);
		

		return comboMap;
	}
	
	
	// 커뮤니티 삭제
	@GetMapping("/deleteCom")
	public String deleteCom(int communityNo) {
		
		int result = service.deleteCom(communityNo);
		
		if(result > 0) {
			System.out.println(communityNo + "번 커뮤니티 삭제 완료");
		}else {
			System.out.println(communityNo + "번 커뮤니티 삭제 실패");
		}
		
		return "redirect:/community/communityPage";
	}
	
	// 커뮤니티 수정
	@PostMapping("/editCom")
	public String editCom(Community com) {
		
//		System.out.println("커뮤니티 수정 com: " + com);
		
		int result = service.editCom(com);
		
		if(result > 0) {
			System.out.println("수정완료");
		}else {
			System.out.println("수정실패");
		}
		
		return "redirect:/community/communityPage";
		
	}
	
	// 댓글 추가
	@PostMapping("/insertCComment")
	public String insertCComment(CommunityComment cCom, @SessionAttribute("loginMember") Member loginMember) {
		
//		System.out.println("cCom : " + cCom);
		
		cCom.setMemberNo(loginMember.getMemberNo());
		
		int result = service.insertCComment(cCom);
		
		if(result > 0) {
			System.out.println("댓글 추가 성공");
		}else {
			System.out.println("댓글 추가 실패");
		}
		
		return "redirect:/community/communityPage";
	}
	
	// 댓글 삭제
	@GetMapping("/deleteCComment")
	public String deleteCComment(int communityCommentNo) {
		
		int result = service.deleteCComment(communityCommentNo);
		
		return "redirect:/community/communityPage";
	}
	


}
