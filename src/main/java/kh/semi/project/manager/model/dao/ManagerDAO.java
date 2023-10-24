package kh.semi.project.manager.model.dao;

import java.util.List;

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
	
	/** QNA 목록 조회 DAO
	 * @return
	 */
	public List<QNA> selectQNA() {

		return sqlSession.selectList("managerMapper.selectQNA");
	}


	public List<QNA> selectQNADone() {

		return sqlSession.selectList("managerMapper.selectQNADone");
	}

}
