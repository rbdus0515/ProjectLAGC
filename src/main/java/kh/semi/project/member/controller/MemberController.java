package kh.semi.project.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.semi.project.content.model.service.ContentService;
import kh.semi.project.member.model.dto.Member;
import kh.semi.project.member.model.service.MemberService;
import oracle.jdbc.proxy.annotation.Post;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	/** 로그인 이동
	 * @return
	 */
	@GetMapping("/login")
	public String login() {
	
		return "/member/login";
	}
	
	/** 아이디 찾기 이동
	 * @return
	 */
	@GetMapping("/findId")
	public String findId() {
	
		return "/member/findId";
	}
	
	/** 비밀번호 찾기 이동
	 * @return
	 */
	@GetMapping("/findPwBeforeId")
	public String findPassword() {
	
		return "/member/findPwBeforeId";
	}
	
	/** 로그아웃
	 * @param status
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(SessionStatus status, RedirectAttributes ra) {
		
		String msg = "로그아웃 되었습니다.";
		
		ra.addFlashAttribute("msg", msg);
		
		status.setComplete();
		
		return "redirect:/";
		
	}

	// 회원가입 페이지 이동
	@GetMapping("/signUp")
	public String signUp() {
		
		return "/member/signUp";
	}
	
	// 회원가입 진행
	@PostMapping("/signUp")
	public String signUp(Member inputMember,
						Model model,
						RedirectAttributes ra,
						@RequestParam("profileImage") MultipartFile profileImage,
						HttpSession session) throws Exception, IOException {
		
		String webPath = "/resources/img/member/";
		String filePath = session.getServletContext().getRealPath(webPath);

		int result = service.signUp(inputMember, profileImage, webPath, filePath);
		
		String path = "redirect:";
		String msg = null;
		
		System.out.println("test");
		
		if(result > 0) {
			model.addAttribute("loginMember", inputMember);
			path += "/";
			msg = inputMember.getMemberNickname() + "님 가입을 환영합니다.";
		} else {
			path += "signUp";
			msg = "회원 가입 실패";
		}
		
		ra.addFlashAttribute("msg",msg);
		
		return path;
	}
	
	/** 로그인
	 * @param inputMember
	 * @param model
	 * @param ra
	 * @param resp
	 * @param referer
	 * @return
	 */
	@PostMapping("/login")
	public String memberLogin(Member inputMember, Model model, 
			RedirectAttributes ra, HttpServletResponse resp,
			@RequestHeader(value = "referer") String referer) {
	
		
		Member loginMember = service.memberLogin(inputMember);
		String msg = null;
		String path = "redirect:";
		
		if(loginMember != null) { // 로그인 성공
			
			model.addAttribute("loginMember", loginMember); 
			msg = "로그인 되었습니다.";
			path += "/";
			ra.addFlashAttribute("msg", msg);
			
		} else {
			
			path += referer;
						
			msg = "회원 정보가 일치하지 않습니다.";
			ra.addFlashAttribute("msg", msg);

		}
		

		return path;
		
	}

	/** 회원 정보 수정
	 * @return
	 */
	@PostMapping("/info")
	public String updateMember(@SessionAttribute("loginMember") Member loginMember, // 로그인 멤버
							   Member inputMember,	 // 수정할 정보 
							   RedirectAttributes ra,
							   Model model,
							   @RequestHeader(value = "referer") String referer,
							   @RequestParam(value="profileImage", required = false) MultipartFile profileImage,
							   HttpSession session
			)  throws IllegalStateException, IOException {
		
		String path = "redirect:";
		String msg = null;
		
		inputMember.setMemberNo( loginMember.getMemberNo() );
		
		
		String webPath = "/resources/img/member/";
		String filePath = session.getServletContext().getRealPath(webPath);

		
		int pwCheck = service.selectPw(inputMember);
		
		if (pwCheck == 0 ) {
			
			msg = "비밀번호가 일치하지 않습니다.";
			path += referer;
			ra.addFlashAttribute("msg", msg);
			
			return path;
			
		}
		
		int result =  service.updateMember(inputMember, webPath, filePath, profileImage, loginMember);
		
		if(result > 0 ) {
			
			msg = "회원 정보 수정이 완료되었습니다.";
			path += "/";
			
			loginMember.setMemberProfileImage(inputMember.getMemberProfileImage());
			loginMember.setMemberId(inputMember.getMemberId());
			loginMember.setMemberName(inputMember.getMemberName());
			loginMember.setMemberEmail(inputMember.getMemberEmail());
			loginMember.setMemberPhone(inputMember.getMemberPhone());
			loginMember.setMemberNickname(inputMember.getMemberNickname());
			
			
		} else {
			
			msg = "프로필 수정이 완료되지 않았습니다.";
			path += referer;
		}
		
		ra.addFlashAttribute("msg", msg);
		return path;
	}
	
	/** 비밀번호 수정 이동
	 * @return
	 */
	@GetMapping("/updatePw")
	public String updatePw() {
	
		return "/member/updatePw";
	}
	
	/** 회원 탈퇴로 이동
	 * @return
	 */
	@GetMapping("/delete")
	public String delete() {
	
		return "/member/memberDelete";
	}
	
	/** 회원 탈퇴
	 * @return
	 */
	@PostMapping("/memberDelete")
	public String deleteMember(String memberPw,
							   SessionStatus status,
							   RedirectAttributes ra,
							   @SessionAttribute("loginMember") Member loginMember,
							   @RequestHeader(value = "referer") String referer
			) {
		
		loginMember.setMemberPw(memberPw);
		
		String msg= null;
		String path = "redirect:";
		
		int result = service.deleteMember(loginMember);
		
		if(result > 0) {
			
			msg = "회원 탈퇴가 완료되었습니다.";
			path += "/";
			status.setComplete();
			
		} else {
			
			msg = "본 계정의 암호와 일치하지 않습니다.";
			path += referer;
			
		}
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}

	/** 비밀번호 수정
	 * @return
	 */
	@PostMapping("/updatePw")
	public String updatePw(String memberPw,
						  @RequestParam(value = "newMemberPw") String newPw,
						  @SessionAttribute("loginMember") Member loginMember,
						  SessionStatus status,
						  RedirectAttributes ra,
						  @RequestHeader(value = "referer") String referer
			) {
				
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberPw", memberPw);
		map.put("newPw", newPw);
		
		int result = service.updatePw(map, loginMember);

		String msg= null;
		String path = "redirect:";
		
		if(result > 0) { // 현재 비밀번호가 같을때
	
			msg = "비밀번호가 변경되었습니다. 다시 로그인 해주세요";
			path += "/";
			status.setComplete();
			
		
		} else { //현재 비밀번호가 다를때
			
			msg = "암호가 일치하지 않습니다. 확인 후 다시 시도해주세요";
			path += referer;
			
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
		
	}
	
	/** 아이디 입력 후 비밀번호 찾기로 이동
	 * @param memberId
	 * @param ra
	 * @param referer
	 * @return
	 */
	@GetMapping("/findPwAfterId")
	public String findPwAfterId(String memberId, 
								RedirectAttributes ra, 
								@RequestHeader(value = "referer") String referer,
								Model model
			) {
	
		int result = service.selectId(memberId);
		String msg = null;
		String path = null;
		
		if(result > 0) {
		
			path = "/member/findPwAfterId";
			model.addAttribute("memberId", memberId);
			
		} else {
			
			msg = "존재하는 아이디가 없습니다.";
			path = "redirect:" + referer;
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}

	/** 좋아요 저장
	 * @return
	 */
	@GetMapping("/like")
	@ResponseBody
	public int like(int contentNo, @SessionAttribute(value="loginMember", required=false) Member loginMember) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("contentNo", contentNo);
		map.put("memberNo", loginMember.getMemberNo());
		
		int likeCheck = contentService.selectLike(map);
		int result = 0;
		
		if(likeCheck > 0) {
			
			result = service.deleteLike(map);
			
			if(result > 0) {
				
				result = 0;
				
			} 
			
		} else {
			
			result = service.insertLike(map);
		}
		
		return result;
	}

	/** 아이디 찾기
	 * @param memberName
	 * @param memberEmail
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping("/findId")
	public String findId(String memberName, String memberEmail, RedirectAttributes ra, @RequestHeader(value = "referer") String referer) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberName", memberName);
		map.put("memberEmail", memberEmail);
		
		String id = service.findId(map);
		String msg = null;
		String path = "redirect:";
		
		if(id != null) {
			
			msg = "회원님의 아이디는" + id + "입니다.";
			path += "/";
			
		}else {
			
			msg = "일치하는 회원 정보가 없습니다.";
			path += referer;
			
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}
	
	/** 비밀번호 변경 이동
	 * @param memberName
	 * @param memberEmail
	 * @param ra
	 * @return
	 */
	@PostMapping("/changePw")
	public String changePw(String memberName, 
						   String memberEmail, 
						   String memberId,
						   RedirectAttributes ra,
						   Model model,
						   @RequestHeader(value = "referer") String referer
							) {
		
		Member member = new Member();
		
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		member.setMemberId(memberId);
		
		String path = "redirect:";
		String msg = "";
		
		int result = service.selectMember(member);

		if(result > 0) {
			
			model.addAttribute("member", member);
			path = "/member/changePw";
		
		} else {
			
			msg = "일치하는 회원 정보가 없습니다.";
			path = "redirect:" + referer;
		}
		
		ra.addFlashAttribute("msg",msg);
		
		return path;
	}
	
	/** 비밀번호 변경
	 * @param memberName
	 * @param memberEmail
	 * @param ra
	 * @return
	 */
	@PostMapping("/changePw2")
	public String changePw2(String memberName, 
						   String memberEmail, 
						   String newMemberPw,
						   RedirectAttributes ra,
						   @RequestHeader(value = "referer") String referer
						   ) {
		
		Member member = new Member();
		String path = "redirect:";
		String msg = "";
		
		member.setMemberName(memberName);
		member.setMemberEmail(memberEmail);
		member.setMemberPw(newMemberPw);
		
		int result = service.changePw(member);

		if(result > 0) {
			
			msg = "비밀번호 변경이 완료되었습니다.";
			path += "/";
		
		} else {
			
			msg = "비밀번호 변경에 실패하였습니다.";
			path += referer;
			
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}

}
