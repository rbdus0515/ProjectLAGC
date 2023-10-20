package kh.semi.project.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.semi.project.member.model.dao.MemberDAO;
import kh.semi.project.member.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	/** 로그인 서비스
	 *
	 */
	@Override
	public Member memberLogin(Member inputMember) {
		
		Member savedMember = dao.memberLogin(inputMember);
		
		if(savedMember != null) {
			
			if (bcrypt.matches(inputMember.getMemberPw(), savedMember.getMemberPw())) {
				
				savedMember.setMemberPw(null);
				
			} else {

				savedMember = null;
			
			}
		}
		
		return savedMember;
	}

	// 회원가입 서비스
	@Transactional
	@Override
	public int signUp(Member inputMember) {
		
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		
		return dao.signUp(inputMember);
	}

	/** 회원 정보 수정 서비스
	 * 
	 */
	@Override
	public int updateMember(Member inputMember) {

		String encPw = bcrypt.encode(inputMember.getMemberPw());
		
		inputMember.setMemberPw(encPw);
		
		return dao.updateMember(inputMember);
	
	}

	/** 비밀번호 조회 서비스
	 *
	 */
	@Override
	public int selectPw(Member inputMember) {
		
		int result = 0;
		
		String savedPw = dao.selectPw(inputMember);
		
		if(bcrypt.matches(inputMember.getMemberPw(), savedPw)) {
			
			result = 1;
			
		}
		
		return result;
	}

	
	/** 회원 탈퇴 서비스
	 *
	 */
	@Override
	public int deleteMember(Member loginMember) {

		
		String savedPw = dao.selectPw(loginMember);
		int result = 0;
		
		if( bcrypt.matches(loginMember.getMemberPw(), savedPw )) {
			
			result = dao.deleteMember(loginMember);
		
		} else {
			
			result = 0;
			
		}
		
		return result;
	}

	/** 비밀번호 변경 서비스
	 *
	 */
	@Override
	public int updatePw(Map<String, String> map, Member loginMember) {
		
		loginMember.setMemberPw(map.get("memberPw"));
		
		String savedPw = dao.selectPw(loginMember);
		
		int result = 0;
		
		
		if( bcrypt.matches(loginMember.getMemberPw(), savedPw )) {
		
			String newPw = bcrypt.encode(map.get("newPw"));
			
			loginMember.setMemberPw(newPw);
			
			result = dao.updatePw(loginMember);
			
		} else {
			
			result = 0;
		}
		
		return result;
	}
}
