package kh.semi.project.content.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kh.semi.project.content.model.dto.Content;

public interface ContentService {

	/** content 상세페이지 조회
	 * @param area
	 * @return List
	 */
	List<Content> selectContentDetail(String area);

	/** 이미지 삭제
	 * @param content
	 * @return int
	 */
	int contentDelete(Content content);

	int insertContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException ;

	/** 메인화면에서 보여줄 콘텐츠 전체 조회
	 * @return
	 */
	List<Content> selectAll();

	/** 좋아요 처리
	 * @param map
	 * @return
	 */
	int selectLike(Map<String, Object> map);

	/** 좋아요 수 조회
	 * @param map
	 * @return
	 */
	int selectLikeCount(Map<String, Object> map);

}
