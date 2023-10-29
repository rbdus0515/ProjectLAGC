package kh.semi.project.notice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String selectNoticeList(@RequestParam(value="cp", required = false, defaultValue = "1") int cp, @RequestParam Map<String, Object> paramMap, Model model) {
		
		Map<String, Object> map = service.selectNoticeList(paramMap, cp);
		
		// System.out.println(map);
		
		model.addAttribute("map", map);

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
		
		String path = "redirect:";
		String message = "";
		
		if(result > 0) { // 공지사항 추가 성공
			// System.out.println("공지사항 추가 성공");
			
			message = "공지사항 추가 성공";
			
			// noticeList 조회
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			Map<String, Object> map = service.selectNoticeList(paramMap, 1);
			
			model.addAttribute("map", map);
			
			path += "noticeList";
			
		} else { // 공지사항 추가 실패
			// System.out.println("공지사항 추가 실패");
			
			message = "공지사항 추가 실패";
			
			path += "insertPage";
			
		}
		
		ra.addFlashAttribute("msg", message);
		
		return path;
	}
	
	// 공지사항 UPDATE
	@GetMapping("/update")
	public String updateNotice(Notice notice, Model model) {
		
		// System.out.println(notice);
		
		int result = service.updateNotice(notice);
		
		String path = "notice/";
		
		/* if(result > 0) {
			System.out.println("공지사항 수정 성공");
			
			
		} else {
			System.out.println("공지사항 수정 실패");
			
		} */
		
		path += "noticeDetail";
		
		return path;
	}
	
	// 공지사항 DELETE
	@GetMapping("/delete")
	public String deleteNotice(int noticeNo, Model model) {
		
		int result = service.deleteNotice(noticeNo);
		
		if(result > 0) {
			// System.out.println("공지사항 삭제 성공");

			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			Map<String, Object> map = service.selectNoticeList(paramMap, 1);
			
			/* for(Notice nt : list) {
				System.out.println(nt);
			} */
		
			model.addAttribute("map", map);
			
		} else {
			// System.out.println("공지사항 삭제 실패");
			
		}
		
		return "notice/noticeList";
	}
	

}
