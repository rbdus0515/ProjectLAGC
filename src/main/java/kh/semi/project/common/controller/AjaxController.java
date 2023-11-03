package kh.semi.project.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.mail.internet.ContentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.semi.project.common.model.service.AjaxService;
import kh.semi.project.content.model.dto.Content;
import kh.semi.project.member.model.dto.Member;

@Controller
@SessionAttributes({"loginMember"})
public class AjaxController {

	Random random = new Random();
	
	@Autowired
	private AjaxService service;
	
	/** 아이디 중복 검사
	 * @param memberId
	 * @return
	 */
	@GetMapping("/selectId")
	@ResponseBody
	public int selectId(String memberId,
						@SessionAttribute(value = "loginMember", required = false) Member loginMember
			) {
		int result = service.selectId(memberId);
		
		if(loginMember != null) {
			
			if(loginMember.getMemberId().equals(memberId)) {
			result = 0;
			}
			
		} 
		
		return result;
	}
	
	/** 닉네임 중복 검사
	 * @param memberId
	 * @return
	 */
	@GetMapping("/selectNickname")
	@ResponseBody
	public int selectNickname( String nickname,
							   @SessionAttribute(value = "loginMember", required = false) Member loginMember
			) {
		
		int result = service.selectNickname(nickname);
		
		if(loginMember != null) {
			
			if(loginMember.getMemberNickname().equals(nickname)) {
				result = 0;
				
			}
			
		}
		
		return result;
	}
	
	/** 인증키 전송
	 * @param memberEmail
	 * @return
	 */
	@GetMapping("/email/sendAuthKey")
	@ResponseBody
	public int sendAuthKey(String memberEmail) {
		
		return service.sendAuthKey(memberEmail);
	}

	/** 인증키 확인
	 * @param memberEmail
	 * @return
	 */
	@GetMapping("/email/checkAuthKey")
	@ResponseBody
	public int checkAuthKey(String inputKey, String memberEmail) {
		
		return service.checkAuthKey(inputKey, memberEmail);
	}
	
	/** 아이디 찾기를 위한 인증키 전송
	 * @param memberEmail
	 * @return
	 */
	@GetMapping("/email/sendAuthKeyForId")
	@ResponseBody
	public int sendAuthKeyForId(String memberEmail) {
		
		int dupCheck = service.dupCheck(memberEmail);
		int result = 0;
		
		if(dupCheck == 0) {
			
			result = -1;
			
		} else {
			
			result = service.sendAuthKey(memberEmail);
			
		}
		
		return result;
	}
	
	/** 추천 콘텐츠 반환 및 중복검사
	 * @param map
	 * @return
	 */
	@PostMapping("/recommend")
	@ResponseBody
	public List<Content> recommend(@RequestBody Map<String, Object> map) {
	
		List<Content> list = service.selectRecommend(map);
		
		List<Content> randomList = new ArrayList<Content>();
		
		int tempNo = 0;
		
		for(int i = 0 ; i < 2 ; i++) {

			int randomNo = random.nextInt(list.size());

			if(randomNo == tempNo) {
				
				i-- ;
				continue;
				
			} else {
				
				randomList.add(list.get(randomNo));
				
				tempNo = randomNo;
				
			}
			
		}
		
		return randomList; 
	}
	
}
