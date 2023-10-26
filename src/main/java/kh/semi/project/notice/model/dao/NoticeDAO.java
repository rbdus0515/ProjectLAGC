package kh.semi.project.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.notice.model.dto.Notice;
import kh.semi.project.notice.model.dto.Pagination;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/** noticeList 조회
	 * @param pagination
	 * @return List
	 */
	public List<Notice> selectNoticeList(Pagination pagination) {
		
		// RowBounds 객체
		// - 마이바티스에서 페이징처리를 위해 제공하는 객체
		// - offset 만큼 건너뛰고
		// 그 다음 지정된 행 개수만큼(limit) 만큼 조회

		// 1) offset 계산
		int offset
			= (pagination.getCurrentPage() - 1) * pagination.getLimit();
		
		// 2) RowBounds 객체 생성
		RowBounds rowBounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("noticeMapper.selectNoticeList", null, rowBounds);
	}
	
	public int getListCount() {
		
		return sqlSession.selectOne("noticeMapper.getListCount");
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
