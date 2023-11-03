package kh.semi.project.myPage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.myPage.model.dao.MyPageDAO;
import kh.semi.project.myPlan.model.dto.MyPlan;

@Service
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageDAO dao;

	/** 1:1문의 조회
	 *
	 */
	@Override
	public List<Map<String, Object>> selectQNAAll(int memberNo) {
		
		return dao.selectQNAAll(memberNo);
	}

	/** 좋아요 조회
	 *
	 */
	@Override
	public List<Map<String, Object>> selectLikeAll(int memberNo) {
		
		return dao.selectLikeAll(memberNo);
	}

	/** 후기 조회
	 *
	 */
	@Override
	public List<Map<String, Object>> selectReplyAll(int memberNo) {
		
		return dao.selectReplyAll(memberNo);
	}

	/** 나의 여행 조회
	 *
	 */
	@Override
	public List<Map<String, Object>> selectMyPlanAll(int memberNo) {

		return dao.selectMyPlanAll(memberNo);
	}

	/** 후기 삭제
	 *
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int replyDelete(int replyNo) {
		
		return dao.replyDelete(replyNo);
	}

	/** 문의 1개 조회
	 *
	 */
	@Override
	public QNA selectQNA(int qnaNo) {

		return dao.selectQNA(qnaNo);
	}

	/** 나의 일정 세부 조회
	 *
	 */
	@Override
	public List<Map<String, Object>> selectMyPlanDetailAll(int memberNo) {

		return dao.selectMyPlanDetailAll(memberNo);
	}

	/** 나의 일정 지우기
	 *
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteMyPlan(int myPlanNo) {

		return dao.deleteMyPlan(myPlanNo);
	}

	/** 나의 일정 만들기
	 *
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int save(MyPlan myPlan) {
		
		return dao.save(myPlan);
	}


}
