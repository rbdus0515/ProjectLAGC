package kh.semi.project.member.controller;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.semi.project.member.model.dto.Member;
import kh.semi.project.member.model.service.MemberService;

@SessionAttributes({"loginMember"})
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	
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
	@GetMapping("/findPassword")
	public String findPassword() {
	
		return "/member/findPassword";
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
						RedirectAttributes ra ) {
		
		int result = service.signUp(inputMember);
		
		String path = "redirect:";
		String message = null;
		
		if(result > 0) {
			path += "/";
			message = inputMember.getMemberNickname() + "님 가입을 환영합니다.";
		} else {
			path += "signUp";
			message = "회원가입 실패";
		}
		
		ra.addFlashAttribute("message",message);
		
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
							   @RequestHeader(value = "referer") String referer
			) {
		
		String path = "redirect:";
		String msg = null;
				
		inputMember.setMemberNo( loginMember.getMemberNo() );
		
		int pwCheck = service.selectPw(inputMember);
		
		if (pwCheck > 0 ) {
			
			msg = "비밀번호가 일치하지 않습니다.";
			path += referer;
			ra.addFlashAttribute("msg", msg);
			
			return path;
			
		}
		
		int result =  service.updateMember(inputMember);
		
		if(result > 0 ) {
			
			msg = "회원 정보 수정이 완료되었습니다.";
			path += "/";
			
			model.addAttribute("loginMember", inputMember);
			ra.addFlashAttribute("msg", msg);
			
		} else {
			
			msg = "프로필 수정이 완료되지 않았습니다.";
			path += referer;
			ra.addFlashAttribute("msg", msg);
		}
		
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
	
		return "/myPage/memberDelete";
	}
	
	/** 회원 탈퇴로 이동
	 * @return
	 */
	@PostMapping("/deleteMember")
	public String deleteMember() {
	
		return "/myPage/memberDelete";
	}
	
	
	
}
