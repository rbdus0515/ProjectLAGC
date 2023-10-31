package kh.semi.project.myPage.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.manager.model.dto.QNA;

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

	/** 나의 일정 목록 조회
	 * @param memberNo
	 * @return
	 */
	public List<Map<String, Object>> selectMyPlanAll(int memberNo) {
	
		return sqlSession.selectList("myPageMapper.selectMyPlanAll", memberNo);
	}

	/** 후기 삭제
	 * @param replyNo
	 * @return
	 */
	public int replyDelete(int replyNo) {

		return sqlSession.update("myPageMapper.replyDelete", replyNo);
	}

	/** 문의 한개 조회
	 * @param qnaNo
	 * @return
	 */
	public QNA selectQNA(int qnaNo) {

		return sqlSession.selectOne("managerMapper.selectQNAOne", qnaNo);
	}

	/** 나의 일정 세부 조회
	 * @param memberNo
	 * @return
	 */
	public List<Map<String, Object>> selectMyPlanDetailAll(int memberNo) {

		return sqlSession.selectList("myPageMapper.selectMyPlanDetailAll", memberNo);
	}

	public int deleteMyPlan(int myPlanNo) {
		
		return sqlSession.delete("myPageMapper.deleteMyPlan", myPlanNo);
	}


	
}
