package kh.semi.project.myPage.model.service;

import java.util.List;
import java.util.Map;

import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.myPlan.model.dto.MyPlan;

public interface MyPageService {

	/** 1:1문의 조회
	 * @param memberNo
	 * @return
	 */
	List<Map<String, Object>> selectQNAAll(int memberNo);

	/** 좋아요 조회
	 * @param memberNo
	 * @return
	 */
	List<Map<String, Object>> selectLikeAll(int memberNo);

	/** 후기 조회
	 * @param memberNo
	 * @return
	 */
	List<Map<String, Object>> selectReplyAll(int memberNo);

	/** 나의 여행 조회
	 * @param memberNo
	 * @return
	 */
	List<Map<String, Object>> selectMyPlanAll(int memberNo);

	/** 후기 삭제
	 * @param replyNo
	 * @return
	 */
	int replyDelete(int replyNo);

	/** 문의 1개 조회
	 * @param qnaNo
	 * @return
	 */
	QNA selectQNA(int qnaNo);

	/** 나의 여행 세부 조회
	 * @param memberNo
	 * @return
	 */
	List<Map<String, Object>> selectMyPlanDetailAll(int memberNo);

	/** 나의 일정 지우기
	 * @param myPlanNo
	 * @return
	 */
	int deleteMyPlan(int myPlanNo);

	/** 나의 일정 만들기
	 * @param myPlan
	 * @return
	 */
	int save(MyPlan myPlan);


}
