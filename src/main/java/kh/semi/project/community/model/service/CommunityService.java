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

	


}
