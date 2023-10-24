package kh.semi.project.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	
	@Autowired
	private ContentService service;
	
	// content 상세페이지 조회
	@GetMapping("/detail")
	public String selectContentDetail(String area, Model model) {
		
		// System.out.println("area : " + area);
		
		List<Content> list = service.selectContentDetail(area);
		
		/* for(Content ct : list) {
			System.out.println(ct);
		} */
		
		model.addAttribute("list", list);
		
		String path = "content/";
		
		if(area.equals("seo")) {
			path += "seoul";
			
		} else if(area.equals("gyeinc")) {
			path += "gyeonggiIncheon";
			
		} else if(area.equals("gan")) {
			path += "gangwon";
			
		} else if(area.equals("chu")) {
			path += "chungcheong";
			
		} else if(area.equals("jeo")) {
			path += "jeolla";
			
		} else if(area.equals("gye")) {
			path += "gyeongsang";
			
		} else if(area.equals("jej")) {
			path += "jeju";
			
		}
		
		return path;
		
	}
	
	// 이미지 삭제
	@GetMapping("/delete")
	public String contentDelete(Content content, Model model) {
		
		// System.out.println(content.toString());
		
		int result = service.contentDelete(content);
		
		String path = "content/";
		String area = null; 
		
		if(result > 0) { // 이미지 삭제 성공
			// System.out.println("이미지 삭제 성공");
			
			area = content.getAreaCode();
			
			// content 상세페이지 조회
			List<Content> list = service.selectContentDetail(area);
			
			/* for(Content ct : list) {
				System.out.println(ct);
			} */
			
			model.addAttribute("list", list);
			
		} else { // 이미지 삭제 실패
			// System.out.println("이미지 삭제 실패");
			
		}
		
		if(area.equals("seo")) {
			path += "seoul";
			
		} else if(area.equals("gyeinc")) {
			path += "gyeonggiIncheon";
			
		} else if(area.equals("gan")) {
			path += "gangwon";
			
		} else if(area.equals("chu")) {
			path += "chungcheong";
			
		} else if(area.equals("jeo")) {
			path += "jeolla";
			
		} else if(area.equals("gye")) {
			path += "gyeongsang";
			
		} else if(area.equals("jej")) {
			path += "jeju";
			
		}
		
		return path;
	}
}
