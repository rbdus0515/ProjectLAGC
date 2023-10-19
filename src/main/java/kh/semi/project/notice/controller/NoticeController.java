package kh.semi.project.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.semi.project.notice.model.dto.Notice;
import kh.semi.project.notice.model.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	// noticeList 조회
	@GetMapping("/noticeList")
	public String selectNoticeList(Model model) {
		
		List<Notice> list = service.selectNoticeList();
		
		/* for(Notice nt : list) {
			System.out.println(nt);
		} */
		
		model.addAttribute("list", list);
		
		return "notice/noticeList";
	}

}
