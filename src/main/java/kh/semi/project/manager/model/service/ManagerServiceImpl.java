package kh.semi.project.manager.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.manager.model.dao.ManagerDAO;
import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.member.model.dto.Member;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO dao;
	
	/** QNA 목록 개수 조회 서비스
	 *
	 */
	@Override
	public int QNACount() {

		return dao.QNACount();
	}
	
	/** QNA 목록 조회 서비스(답변 대기)
	 *
	 */
	@Override
	public List<QNA> selectQNA() {

		return dao.selectQNA();
	}

	/** QNA 목록 조회 서비스(답변 완료)
	 *
	 */
	@Override
	public List<QNA> selectQNADone() {

		return dao.selectQNADone();
	}

	/** QNA 답변 추가
	 *
	 */
	@Override
	public int insertAnswer(Map<String, Object> map) {

		return dao.insertAnswer(map);
	}

	/** QNA 답변 수정
	 *
	 */
	@Override
	public int updateAnswer(Map<String, Object> map) {
		
		return dao.updateAnswer(map);
	}

	
	
}
