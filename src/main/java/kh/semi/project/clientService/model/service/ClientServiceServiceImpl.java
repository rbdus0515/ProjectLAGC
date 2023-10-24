package kh.semi.project.clientService.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.clientService.model.dao.ClientServiceDAO;
import kh.semi.project.clientService.model.dto.ClientService;

@Service
public class ClientServiceServiceImpl implements ClientServiceService{

	@Autowired
	private ClientServiceDAO dao;

	@Override
	public List<ClientService> noticeList() {
		
		return dao.noticeList();
	}
	
	
}
