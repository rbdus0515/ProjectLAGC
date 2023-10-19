package kh.semi.project.common.model.service;

public interface AjaxService {

	int selectId(String memberId);

	int selectNickname(String nickname);

	int sendAuthKey(String memberEmail);

	int checkAuthKey(String inputKey, String memberEmail);

}
