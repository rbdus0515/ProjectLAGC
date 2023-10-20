package kh.semi.project.member.model.service;

import java.util.Map;

import kh.semi.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return
	 */
	Member memberLogin(Member inputMember);

	/** 회원가입 서비스
	 * @param inputMember
	 * @return result
	 */
	int signUp(Member inputMember);

	/** 회원 정보 수정 서비스
	 * @param inputMember
	 * @return
	 */
	int updateMember(Member inputMember);

	/** 비밀번호 조회 서비스
	 * @param inputMember
	 * @return
	 */
	int selectPw(Member inputMember);

	/** 회원 탈퇴 서비스
	 * @param map
	 * @return
	 */
	int deleteMember(Member loginMember);

	/** 비밀번호 변경 서비스
	 * @param map
	 * @param loginMember 
	 * @return
	 */
	int updatePw(Map<String, String> map, Member loginMember);

}
