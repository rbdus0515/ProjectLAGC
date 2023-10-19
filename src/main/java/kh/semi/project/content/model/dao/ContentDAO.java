package kh.semi.project.content.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.content.model.dto.Content;

@Repository
public class ContentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/** content 상세페이지 조회
	 * @param area
	 * @return List
	 */
	public List<Content> selectContentDetail(String area) {
		
		return sqlSession.selectList("contentMapper.selectContentDetail", area);
	}

}
