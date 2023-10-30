package kh.semi.project.myPage.model.service;

import java.util.List;
import java.util.Map;

import kh.semi.project.content.model.dto.Reply;

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


}
