package kh.semi.project.content.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.dto.Reply;

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

	/** 모달창 오픈시 정보 가져오기
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

	/** 게시불 한개 조회
	 * @param contentNo
	 * @return
	 */
	public Map<String, Object> selcetOne(int contentNo) {
		
		return sqlSession.selectOne("contentMapper.selectOne", contentNo);
	}

	/** 후기 조회
	 * @param contentNo
	 * @return
	 */
	public List<Reply> seletReply(int contentNo) {

		return sqlSession.selectList("contentMapper.selectReply", contentNo);
	}
	
	/** 후기 삽입
	 * @param contentNo
	 * @param reply
	 * @param memberNo
	 * @return
	 */
	public int insertReply(int contentNo, String XSSreply, int memberNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("contentNo", contentNo);
		map.put("XSSreply", XSSreply);
		map.put("memberNo", memberNo);
		
		return sqlSession.insert("contentMapper.insertReply", map);
	}

	/** 컨텐츠 상세 조회
	 * @param map
	 * @return
	 */
	public Map<String, Object> searchContent(Map<String, Object> map) {
		return sqlSession.selectOne("contentMapper.searchContent", map);
	}

	/** 이미지 변경 후 컨텐츠 업데이트
	 * @param inputContent
	 * @return
	 */
	public int updateContent(Content inputContent) {
		return sqlSession.update("contentMapper.updateContent", inputContent);
	}
	
	/** 이미지 변경없이 컨텐츠 업데이트
	 * @param inputContent
	 * @param originImg
	 * @return
	 */
	public int updateContentOriginImg(Content inputContent) {
		return sqlSession.update("contentMapper.updateContent", inputContent);
	}

	/** 지도 핀 꽂기
	 * @return
	 */
	public List<Content> selectPlace() {

		return sqlSession.selectList("contentMapper.selectPlace");
	}

	
	

//	 * 	/** 여행지 검색
//	 */
//	 * @return
//	 */
//	public List<Content> searchLoca(String inputLoca) {
//		
//		return sqlSession.searchLoca("contentMapper.searchLoca", inputLoca);
//	}
//	
//	 

	
}