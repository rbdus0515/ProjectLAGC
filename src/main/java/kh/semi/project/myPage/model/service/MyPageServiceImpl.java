package kh.semi.project.myPage.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.content.model.dto.Reply;
import kh.semi.project.myPage.model.dao.MyPageDAO;

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


}
