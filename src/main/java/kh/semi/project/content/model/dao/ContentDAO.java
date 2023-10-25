package kh.semi.project.content.model.dao;

import java.util.List;
import java.util.Map;

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

	/** 이미지 삭제
	 * @param content
	 * @return int
	 */
	public int contentDelete(Content content) {
		
		return sqlSession.update("contentMapper.contentDelete", content);
	}

	/** 컨텐츠 추가
	 * @param inputContent
	 * @return
	 */
	public int insertContent(Content inputContent) {
		
		return sqlSession.insert("contentMapper.insertContent", inputContent);
	}

	/** 메인화면에 뿌려줄 전체 컨텐츠 조회
	 * @return
	 */
	public List<Content> selectAll() {
		
		return sqlSession.selectList("contentMapper.selectAll");
	}

	/** 좋아요 여부 조회
	 * @param map
	 * @return
	 */
	public int selectLike(Map<String, Object> map) {

		return sqlSession.selectOne("contentMapper.selectLike", map);
	}

	/** 좋아요 개수 조회
	 * @param map
	 * @return
	 */
	public int selectLikeCount(Map<String, Object> map) {

		return sqlSession.selectOne("contentMapper.selectLikeCount", map);
	}

}
