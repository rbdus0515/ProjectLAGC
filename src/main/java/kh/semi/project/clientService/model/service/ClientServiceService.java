package kh.semi.project.clientService.model.service;

import java.util.List;

import kh.semi.project.clientService.model.dto.ClientService;
import kh.semi.project.manager.model.dto.QNA;

public interface ClientServiceService {

	List<ClientService> noticeList();

	/** 문의사항 삽입 
	 * @param qna
	 * @return
	 */
	int insertQNA(QNA qna);

}
