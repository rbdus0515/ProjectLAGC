package kh.semi.project.clientService.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.clientService.model.dto.ClientService;
import kh.semi.project.manager.model.dto.QNA;

@Repository
public class ClientServiceDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ClientService> noticeList() {
		
		return sqlSession.selectList("clientServiceMapper.noticeList");
	}

	/** 문의사항 삽입
	 * @param qna
	 * @return
	 */
	public int insertQNA(QNA qna) {

		return sqlSession.insert("clientServiceMapper.insertQNA", qna);
	}

}
