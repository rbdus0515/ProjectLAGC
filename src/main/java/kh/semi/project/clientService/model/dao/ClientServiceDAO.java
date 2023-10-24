package kh.semi.project.clientService.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.clientService.model.dto.ClientService;

@Repository
public class ClientServiceDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<ClientService> noticeList() {
		
		return sqlSession.selectList("clientServiceMapper.noticeList");
	}

}
