package kh.semi.project.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	/** 1:1 문의 이동
	 * @return
	 */
	@GetMapping("/managingAsk")
	public String managingAsk() {
		
		return "/manager/managingAsk";
	}
}
