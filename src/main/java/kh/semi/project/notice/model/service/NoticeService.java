package kh.semi.project.notice.model.service;

import java.util.List;

import kh.semi.project.notice.model.dto.Notice;

public interface NoticeService {

	/** noticeList 조회
	 * @return List
	 */
	List<Notice> selectNoticeList();

	/** noticeDetail 조회
	 * @param noticeNo
	 * @return Notice
	 */
	Notice selectNoticeDetail(int noticeNo);

	/** 공지사항 INSERT
	 * @param notice
	 * @return int
	 */
	int insertNotice(Notice notice);

	/** 공지사항 UPDATE
	 * @param notice
	 * @return
	 */
	int updateNotice(Notice notice);

}
