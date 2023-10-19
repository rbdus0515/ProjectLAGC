package kh.semi.project.content.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.content.model.dao.ContentDAO;
import kh.semi.project.content.model.dto.Content;

@Service
public class ContetServiceImpl implements ContentService{

	@Autowired
	private ContentDAO dao;
	
	// content 상세페이지 조회
	@Override
	public List<Content> selectContentDetail(String area) {
		
		return dao.selectContentDetail(area);
	}

	
}
