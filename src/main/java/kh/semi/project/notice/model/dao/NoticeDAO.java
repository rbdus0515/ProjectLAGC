package kh.semi.project.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.notice.model.dto.Notice;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** noticeList 조회
	 * @return List
	 */
	public List<Notice> selectNoticeList() {
		
		return sqlSession.selectList("noticeMapper.selectNoticeList");
	}

	/** noticeDetail 조회
	 * @param noticeNo
	 * @return Notice
	 */
	public Notice selectNoticeDetail(int noticeNo) {
		
		return sqlSession.selectOne("noticeMapper.selectNoticeDetail", noticeNo);
	}

	/** 공지사항 INSERT
	 * @param notice
	 * @return int 
	 */
	public int insertNotice(Notice notice) {
		
		return sqlSession.insert("noticeMapper.insertNotice", notice);
	}

	/** 공지사항 UPDATE
	 * @param notice
	 * @return int
	 */
	public int updateNotice(Notice notice) {
		
		return sqlSession.update("noticeMapper.updateNotice", notice);
	}

	/** 공지사항 DELETE
	 * @param noticeNo
	 * @return int
	 */
	public int deleteNotice(int noticeNo) {
		
		return sqlSession.update("noticeMapper.deleteNotice", noticeNo);
	}

}
