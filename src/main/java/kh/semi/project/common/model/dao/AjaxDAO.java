package kh.semi.project.common.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AjaxDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 아이디 중복검사 DAO
	 * @param memberId
	 * @return
	 */
	public int selectId(String memberId) {

		int result = sqlSession.selectOne("ajaxMapper.selectId", memberId);
		
		return result;
	}

	/** 닉네임 중복검사 DAO
	 * @param nickname
	 * @return
	 */
	public int selectNickname(String nickname) {

		return sqlSession.selectOne("ajaxMapper.selectNickname", nickname);
	}

	/** 인증키 메일 전송 후 원래 저장된 인증키가 있으면 업데이트 DAO
	 * @param map
	 * @return
	 */
	public int updateAuthKey(Map<String, String> map) {

		return sqlSession.update("ajaxMapper.updateAuthKey", map);
	}

	/** 저장된 인증키가 없으면 인서트 DAO
	 * @param map
	 * @return
	 */
	public int insertAuthKey(Map<String, String> map) {

		return sqlSession.insert("ajaxMapper.insertAuthKey", map);
	}

	/** 인증키 확인 DAO
	 * @param map
	 * @return
	 */
	public int checkAuthKey(Map<String, String> map) {

		return sqlSession.selectOne("ajaxMapper.checkAuthKey", map);
	}

	
}
