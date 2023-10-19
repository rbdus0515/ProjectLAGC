package kh.semi.project.community.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kh.semi.project.community.model.dao.CommunityDAO;
import kh.semi.project.community.model.dto.Community;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityDAO dao;

	@Override
	public List<Community> selectCommunityList() {

		
		return dao.selectCommunityList();
	}

	



}
