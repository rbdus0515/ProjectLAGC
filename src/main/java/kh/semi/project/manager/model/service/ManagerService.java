package kh.semi.project.manager.model.service;

import java.util.List;

import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.member.model.dto.Member;

public interface ManagerService {

	/** QNA 목록 개수 조회 서비스
	 * @return
	 */
	int QNACount();
	
	/** QNA 목록 조회 서비스(답변 대기)
	 * @return
	 */
	List<QNA> selectQNA();


	/** QNA 목록 조회 서비스(답변 완료)
	 * @return
	 */
	List<QNA> selectQNADone();

}
