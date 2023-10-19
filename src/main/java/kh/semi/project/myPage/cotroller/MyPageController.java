package kh.semi.project.myPage.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.semi.project.myPage.model.service.MyPageService;


@Controller
@RequestMapping("/myPage")
public class MyPageController {
	
//	@Autowired
//	private MyPageService service;
	
	@GetMapping("/myPages")
	public String MyPagePage() {
		
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
