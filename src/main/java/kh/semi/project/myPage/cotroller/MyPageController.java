package kh.semi.project.myPage.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	
	@GetMapping("/myPages")
	public String MyPagePage(@SessionAttribute("loginMember") Member loginMember, Model model) {
		
		if(loginMember.getMemberManagerFlag().equals("Y")) {
			
			int QNACount = managerService.QNACount();
			
			model.addAttribute("QNACount", QNACount);
		}
		
		return "myPage/myPage";
		
	}
	
	/** 마이페이지 이동 컨트롤러
	 * @return
	 */
	@GetMapping("/managingProfile")
	public String managingProfileForward() {
		
		
		return "myPage/managingProfile";
		
	}
}
