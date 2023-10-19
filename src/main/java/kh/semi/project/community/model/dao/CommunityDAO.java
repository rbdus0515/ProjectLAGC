package kh.semi.project.community.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kh.semi.project.community.model.dto.Community;

@Repository
public class CommunityDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Community> selectCommunityList() {
		
		return sqlSession.selectList("communityMapper.selectCommunityList");
	}
	

}
