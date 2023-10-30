package kh.semi.project.myPage.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.content.model.dto.Reply;

@Repository
public class MyPageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/** 1:1 목록 조회
	 * @param qNAMap
	 * @return
	 */
	public List<Map<String, Object>> selectQNAAll(int memberNo) {

		return sqlSession.selectList("myPageMapper.selectQNAAll", memberNo);
	}

	/** 좋아요 목록 조회
	 * @param likeMap
	 * @return
	 */
	public List<Map<String, Object>> selectLikeAll(int memberNo) {

		return sqlSession.selectList("myPageMapper.selectLikeAll", memberNo);
	}

	/** 후기 목록 조회
	 * @param replyMap
	 * @return
	 */
	public List<Map<String, Object>> selectReplyAll(int memberNo) {

		return sqlSession.selectList("myPageMapper.selectReplyAll", memberNo);
	}

	public List<Map<String, Object>> selectMyPlanAll(int memberNo) {
	
		return sqlSession.selectList("myPageMapper.selectMyPlanAll", memberNo);
	}


	
}
