package kh.semi.project.myPage.cotroller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.manager.model.service.ManagerService;
import kh.semi.project.member.model.dto.Member;
import kh.semi.project.myPage.model.service.MyPageService;


@Controller
@RequestMapping("/myPage")
@SessionAttributes({"loginMember"})
public class MyPageController {
	
//	@Autowired
//	private MyPageService service;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private MyPageService service;
	
	/** 마이페이지 이동 컨트롤러
	 * @param loginMember
	 * @param model
	 * @return
	 */
	@GetMapping("/myPages")
	public String MyPagePage(@SessionAttribute("loginMember") Member loginMember, Model model) {
		
		if(loginMember.getMemberManagerFlag().equals("Y")) { // 관리자 계정일 떄
			
			int QNACount = managerService.QNACount();
			
			model.addAttribute("QNACount", QNACount);
		
		} else {  // 일반 계정일때
			
			int memberNo = loginMember.getMemberNo();
			
			List<Map<String, Object>> QNAList = new ArrayList<Map<String, Object>>(); 
			List<Map<String, Object>> likeList = new ArrayList<Map<String, Object>>(); 
			List<Map<String, Object>> replyList = new ArrayList<Map<String, Object>>(); 
			List<Map<String, Object>> myPlanList = new ArrayList<Map<String, Object>>(); 
			
			
			QNAList = service.selectQNAAll(memberNo);
			likeList = service.selectLikeAll(memberNo);
			replyList = service.selectReplyAll(memberNo);
			myPlanList = service.selectMyPlanAll(memberNo);
			
			System.out.println(myPlanList);
			
			
			
			model.addAttribute("QNAList", QNAList);
			model.addAttribute("likeList", likeList);
			model.addAttribute("replyList", replyList);
			model.addAttribute("myPlanList", myPlanList);
			
		}
		
		return "myPage/myPage";
		
	}
	
	/** 프로필 수정 이동 컨트롤러
	 * @return
	 */
	@GetMapping("/managingProfile")
	public String managingProfileForward() {
		
		
		return "myPage/managingProfile";
		
	}
}
