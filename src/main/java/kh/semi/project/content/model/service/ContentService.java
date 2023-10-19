package kh.semi.project.content.model.service;

import java.util.List;

import kh.semi.project.content.model.dto.Content;

public interface ContentService {

	/** content 상세페이지 조회
	 * @param area
	 * @return List
	 */
	List<Content> selectContentDetail(String area);

}
