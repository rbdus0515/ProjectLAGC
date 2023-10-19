package kh.semi.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.member.model.dto.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 로그인 DAO
	 * @param inputMember
	 * @return
	 */
	public Member memberLogin(Member inputMember) {

		return sqlSession.selectOne("memberMapper.memberLogin", inputMember);
	}

	/** 회원가입 DAO
	 * @param inputMember
	 * @return result
	 */
	public int signUp(Member inputMember) {
		
		return sqlSession.insert("memberMapper.signUp", inputMember);
	}

	/** 회원 정보 수정 DAO
	 * @param inputMember
	 * @return
	 */
	public int updateMember(Member inputMember) {

		return sqlSession.update("memberMapper.updateMember", inputMember);
	}

	/** 비밀번호 조회 DAO
	 * @param inputMember
	 * @return
	 */
	public String selectPw(Member inputMember) {

		return sqlSession.selectOne("memberMapper.selectPw", inputMember);
	}

}
