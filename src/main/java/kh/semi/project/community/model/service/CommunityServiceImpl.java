package kh.semi.project.community.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kh.semi.project.community.model.dao.CommunityDAO;
import kh.semi.project.community.model.dto.Community;
import kh.semi.project.community.model.dto.CommunityComment;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAO dao;

	@Override
	public List<Community> selectCommunityList() {

		
		return dao.selectCommunityList();
	}

	@Override
	public List<Community> selectLocalList(String areaCode) {
		
		return dao.selectLocalList(areaCode);
	}

	@Override
	@Transactional
	public int insertCom(Community inputCom) {
		
		return dao.insertCom(inputCom);
	}

	@Override
	public List<CommunityComment> selectCCommentList(int communityNo) {
		return dao.selectCCommentList(communityNo);
	}

	

	

	
	

	

}
