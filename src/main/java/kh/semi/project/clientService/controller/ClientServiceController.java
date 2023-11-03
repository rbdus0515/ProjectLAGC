package kh.semi.project.clientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.semi.project.clientService.model.dto.ClientService;
import kh.semi.project.clientService.model.service.ClientServiceService;
import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.member.model.dto.Member;

@Controller
@RequestMapping("/clientService")
@SessionAttributes({"loginMember"})
public class ClientServiceController {
	
	@Autowired
	private ClientServiceService service;
	
	@GetMapping("/clientServicePage")
	public String clientServicePage(Model model) {
		
		List<ClientService> list = service.noticeList();
		model.addAttribute("list", list);
		
		return "/clientService/clientServicePage";
	}
	
	/** 1:1 문의 입력
	 * @param QNATitle
	 * @param QNAContent
	 * @param loginMember
	 * @param ra
	 * @param referer
	 * @return
	 */
	@PostMapping("/submitQna")
	public String submitQna(String QNATitle,
							String QNAContent,
							@SessionAttribute("loginMember") Member loginMember,
							RedirectAttributes ra,
							@RequestHeader(value = "referer") String referer
			){
		
		String msg = "";
		
		QNA qna = new QNA();
		
		qna.setQNATitle(QNATitle);
		qna.setQNAContent(QNAContent);
		qna.setMemberNo(loginMember.getMemberNo());
		
		int result = service.insertQNA(qna);
		
		if(result > 0) {
			
			msg = "문의사항이 등록되었습니다.";
			
		} else {
			
			msg = "문의사항 등록이 실패했습니다.";
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:" + referer;
	}

}
