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
	@Transactional(rollbackFor = Exception.class)
	public int insertCom(Community inputCom) {
		
		return dao.insertCom(inputCom);
	}

	@Override
	public List<CommunityComment> selectCCommentList(int communityNo) {
		return dao.selectCCommentList(communityNo);
	}

	@Override
	public List<Community> selectComList(int communityNo) {
		return dao.selectComList(communityNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteCom(int communityNo) {
		return dao.deleteCom(communityNo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int editCom(Community com) {
		return dao.editCom(com);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int readCountPlus(Map<String, Object> readMap) {
		return dao.readCountPlus(readMap);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertCComment(CommunityComment cCom) {
		return dao.insertCComment(cCom);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteCComment(int communityCommentNo) {
		return dao.deleteCComment(communityCommentNo);
	}

	

}

	

	

	
	

	


