package kh.semi.project.community.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import kh.semi.project.community.model.dto.Community;
import kh.semi.project.community.model.dto.CommunityComment;

public interface CommunityService {

	List<Community> selectCommunityList();

	List<Community> selectLocalList(String areaCode);

	int insertCom(Community inputCom);

	List<CommunityComment> selectCCommentList(int communityNo);

	List<Community> selectComList(int communityNo);

	int deleteCom(int communityNo);

	int editCom(Community com);

	int readCountPlus(Map<String, Object> readMap);

	int insertCComment(CommunityComment cCom);

	int deleteCComment(int communityCommentNo);

	

	

	


}
