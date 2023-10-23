package kh.semi.project.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	// noticeDetail 조회
	@GetMapping("/detail")
	public String selectNoticeDetail(int noticeNo, Model model) {
		
		Notice notice = service.selectNoticeDetail(noticeNo);
		
		// System.out.println(notice.toString());
		
		model.addAttribute("notice", notice);
		
		return "notice/noticeDetail";
		
	}
	
	// 공지사항 추가버튼 클릭 시, jsp로 리다이렉트
	@GetMapping("/insertPage")
	public String insertPage() {
		
		return "notice/noticeInsert";
	}
	
	// 공지사항 INSERT
	@PostMapping("/insert")
	public String insertNotice(Notice notice, Model model, RedirectAttributes ra) {
		
		int result = service.insertNotice(notice);
		
		String msg = null;
		String path = "redirect:";
		
		if(result > 0) { // 공지사항 추가 성공
			System.out.println("공지사항 추가 성공");
			
			msg = "공지사항 추가 성공";
			
			// noticeList 조회
			List<Notice> list = service.selectNoticeList();
			
			model.addAttribute("list", list);
			
			path += "noticeList";
			
		} else { // 공지사항 추가 실패
			System.out.println("공지사항 추가 실패");
			
			msg = "공지사항 추가 실패";
			
			path += "insert";
			
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}
	

}
