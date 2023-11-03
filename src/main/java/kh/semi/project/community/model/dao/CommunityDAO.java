package kh.semi.project.community.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import kh.semi.project.community.model.dto.Community;
import kh.semi.project.community.model.dto.CommunityComment;

@Repository
public class CommunityDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<Community> selectCommunityList() {
		
		return sqlSession.selectList("communityMapper.selectCommunityList");
	}

	public List<Community> selectLocalList(String areaCode) {
		
		return sqlSession.selectList("communityMapper.selectLocalList", areaCode);
	}

	public int insertCom(Community inputCom) {
		
		return sqlSession.insert("communityMapper.insertCom", inputCom);
	}

	public List<CommunityComment> selectCCommentList(int communityNo) {
		return sqlSession.selectList("communityMapper.selectCCommentList", communityNo);
	}

	public List<Community> selectComList(int communityNo) {
		return sqlSession.selectList("communityMapper.selectComList", communityNo);
	}

	public int deleteCom(int communityNo) {
		return sqlSession.update("communityMapper.deleteCom", communityNo);
	}

	public int editCom(Community com) {
		return sqlSession.update("communityMapper.editCom", com);
	}

	public int readCountPlus(Map<String, Object> readMap) {
		return sqlSession.update("communityMapper.readCountPlus", readMap);
	}

	public int insertCComment(CommunityComment cCom) {
		return sqlSession.insert("communityMapper.insertCComment", cCom);
	}

	public int deleteCComment(int communityCommentNo) {
		return sqlSession.update("communityMapper.deleteCComment", communityCommentNo);
	}

	

	
	



}
