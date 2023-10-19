package kh.semi.project.notice.model.service;

import java.util.List;

import kh.semi.project.notice.model.dto.Notice;

public interface NoticeService {

	/** noticeList 조회
	 * @return List
	 */
	List<Notice> selectNoticeList();

}
