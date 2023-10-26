package kh.semi.project.content.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.content.model.service.ContentService;
import kh.semi.project.member.model.dto.Member;

@Controller
@RequestMapping("/content")
@SessionAttributes({"loginMember"})
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

	// 컨텐츠 추가
	@PostMapping("/adminEditPopUp")
	public String insertContent(Content inputContent,
								Model model,
								RedirectAttributes ra,
								@RequestParam("uploadPlaceImg") MultipartFile uploadPlaceImg,
								HttpSession session
								) throws Exception, IOException {
		
		String webPath = "/resources/img/content/";
		String filePath = session.getServletContext().getRealPath(webPath);
		
		int result = service.insertContent(inputContent, uploadPlaceImg, webPath, filePath);
		
		String path = "redirect:";
		String msg = null;
		String area = null;
		
		if(result > 0) {
			model.addAttribute("loginMember", inputContent);
			path += "/";
			msg = "업로드 성공!";
		} else {
			path += "/";
			msg = "업로드 실패";
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
		
		ra.addFlashAttribute("msg",msg);
		
		return path;
	}
	
	/** 모달창 오픈시 정보 가져오기
	 * @return
	 */
	@GetMapping("/like")
	@ResponseBody
	public Map<String, Object> like(int contentNo, 
									@SessionAttribute(value="loginMember", required=false) Member loginMember,
									Model model
									) {
		
		Map<String, Object> mapForLike = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int likeYesOrNo  = 0;
		int likeCount = 0;
		
		mapForLike.put("contentNo", contentNo);
		
		if(loginMember != null) {
			
			mapForLike.put("memberNo", loginMember.getMemberNo());
			likeYesOrNo = service.selectLike(mapForLike);
			likeCount= service.selectLikeCount(mapForLike);	
			
		} else {
		
			likeCount= service.selectLikeCount(mapForLike);
			
		}
				
		map = service.selectOne(contentNo);
		
		map.put("likeYesOrNo", likeYesOrNo);
		map.put("likeCount", likeCount);
		
		
		List<Reply> replyList = new ArrayList<Reply>();
		
		replyList = service.selectReply(contentNo);
		
		if(!replyList.isEmpty()) {
			
			for(int i = 0 ; i < replyList.size() ; i ++) {

				map.put("reply" + i, replyList.get(i));
				
				}
			
				
		} else {
			
			for(int i = 0 ; i < 3 ; i ++) {
				
				map.put("reply" + i, "작성된 후기가 없습니다.");
			}
		}
		
		
		return map;
		
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public Map<String, Object> insertReply(int contentNo,
										   String reply, 
										   @SessionAttribute("loginMember") Member loginMember,
										   RedirectAttributes ra
										   ) {
		
		int memberNo = loginMember.getMemberNo();
		int result = service.insertReply(contentNo, reply, memberNo);
		String msg = null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(result > 0) {
			
			List<Reply> replyList = new ArrayList<Reply>();
			
			replyList = service.selectReply(contentNo);
			
			if(!replyList.isEmpty()) {
				
				for(int i = 0 ; i < replyList.size() ; i ++) {

					map.put("reply" + i, replyList.get(i));
					
					}
				
					
			} else {
				
				for(int i = 0 ; i < 3 ; i ++) {
					
					map.put("reply" + i, "작성된 후기가 없습니다.");
				}
			}
			
			msg = "후기 작성을 완료하였습니다.";
			
		} else {
			
			msg = "후기 작성에 실패하였습니다.";
			
		}
	
		ra.addFlashAttribute("msg", msg);
		
		return map;
	}
}
