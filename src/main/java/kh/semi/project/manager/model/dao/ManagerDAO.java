package kh.semi.project.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import kh.semi.project.manager.model.dto.QNA;

@Repository
public class ManagerDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** QNA 개수 조회 DAO
	 * @return
	 */
	public int QNACount() {

		return sqlSession.selectOne("managerMapper.QNACount");
	}
	
	/** QNA 목록 조회 DAO(답변 대기)
	 * @return
	 */
	public List<QNA> selectQNA() {

		return sqlSession.selectList("managerMapper.selectQNA");
	}


	/** QNA 목록 조회 DAO(답변 완료)
	 * @return
	 */
	public List<QNA> selectQNADone() {

		return sqlSession.selectList("managerMapper.selectQNADone");
	}

	/** QNA 답변 추가 DAO
	 * @param map
	 * @return
	 */
	public int insertAnswer(Map<String, Object> map) {

		return sqlSession.insert("managerMapper.insertAnswer", map);
	}

	/** QNA 답변 수정 DAO
	 * @param map
	 * @return
	 */
	public int updateAnswer(Map<String, Object> map) {
		
		return sqlSession.update("managerMapper.updateAnswer", map);
	}

}
