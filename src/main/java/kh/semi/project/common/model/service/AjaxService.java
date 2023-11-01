package kh.semi.project.common.model.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import kh.semi.project.content.model.dto.Content;

public interface AjaxService {

	int selectId(String memberId);

	int selectNickname(String nickname);

	int sendAuthKey(String memberEmail);

	int checkAuthKey(String inputKey, String memberEmail);

	int dupCheck(String memberEmail);

	List<Content> selectRecommend(Map<String, Object> map);

}
