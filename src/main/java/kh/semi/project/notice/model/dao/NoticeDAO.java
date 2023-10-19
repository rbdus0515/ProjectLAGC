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

}
