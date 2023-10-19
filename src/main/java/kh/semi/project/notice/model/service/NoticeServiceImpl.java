package kh.semi.project.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.notice.model.dao.NoticeDAO;
import kh.semi.project.notice.model.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO dao;

	// noticeList 조회
	@Override
	public List<Notice> selectNoticeList() {
		
		return dao.selectNoticeList();
	}

}
