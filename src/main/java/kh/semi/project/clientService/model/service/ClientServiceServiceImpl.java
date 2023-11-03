package kh.semi.project.clientService.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.semi.project.clientService.model.dao.ClientServiceDAO;
import kh.semi.project.clientService.model.dto.ClientService;
import kh.semi.project.manager.model.dto.QNA;

@Service
public class ClientServiceServiceImpl implements ClientServiceService{

	@Autowired
	private ClientServiceDAO dao;

	@Override
	public List<ClientService> noticeList() {
		
		return dao.noticeList();
	}

	/** 문의사항 삽입
	 *
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertQNA(QNA qna) {

		return dao.insertQNA(qna);
	}
	
	
}
