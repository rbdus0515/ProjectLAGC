package kh.semi.project.notice.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.notice.model.dao.NoticeDAO;
import kh.semi.project.notice.model.dto.Notice;
import kh.semi.project.notice.model.dto.Pagination;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO dao;

	// noticeList 조회
	@Override
	public Map<String, Object> selectNoticeList(Map<String, Object> paramMap, int cp) {
		
		// 1. 특정 게시판의 삭제되지 않은 게시글 수 조회
		int listCount = dao.getListCount(paramMap);
		// System.out.println(listCount);
		// 2. 1번 조회 결과 + cp 를 이용해서 Pagination 객체 생성
		// -> 내부 필드가 모두 계산되어 초기화됨
		Pagination pagination = new Pagination(listCount, cp);
		
		// 3. 특정 게시판에서
		// 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
		// ex) 100개
		//	   10개 씩 보여준다
		//	   1page -> 100 ~ 91
		//     2page -> 90  ~ 81
		// 어떤 게시판에서(boardCode)
		// 몇페이지(pagination.currentPage)에 대한
		// 게시글 몇개(pagination.limit)인지 조회
		List<Notice> noticeList = dao.selectNoticeList(pagination, paramMap);

		// 4. pagination, boardList를 Map에 담아서 반환
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("noticeList", noticeList);
		
		return map;
	}

	// noticeDetail 조회
	@Override
	public Notice selectNoticeDetail(int noticeNo) {
		
		return dao.selectNoticeDetail(noticeNo);
	}

	// 공지사항 INSERT
	@Override
	public int insertNotice(Notice notice) {
		
		return dao.insertNotice(notice);
	}

	// 공지사항 UPDATE
	@Override
	public int updateNotice(Notice notice) {
		
		return dao.updateNotice(notice);
	}

	// 공지사항 DELETE
	@Override
	public int deleteNotice(int noticeNo) {
		
		return dao.deleteNotice(noticeNo);
	}

}
