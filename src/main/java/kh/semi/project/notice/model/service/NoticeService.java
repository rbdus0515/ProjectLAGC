package kh.semi.project.notice.model.service;

import java.util.List;
import java.util.Map;

import kh.semi.project.notice.model.dto.Notice;

public interface NoticeService {

	/** noticeList 조회
	 * @param cp
	 * @return Map
	 */
	Map<String, Object> selectNoticeList(int cp);

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
	 * @return int
	 */
	int updateNotice(Notice notice);

	/** 공지사항 DELETE
	 * @param noticeNo
	 * @return int
	 */
	int deleteNotice(int noticeNo);

}
