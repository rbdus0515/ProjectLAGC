package kh.semi.project.content.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.dto.Reply;

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

	/** 컨텐츠 추가
	 * @param inputContent
	 * @param uploadPlaceImg
	 * @param webPath
	 * @param filePath
	 * @return result
	 * @throws Exception
	 * @throws IOException
	 */
	int insertContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException ;

	/** 메인화면에서 보여줄 콘텐츠 전체 조회
	 * @return
	 */
	List<Content> selectAll();

	/** 모달창 오픈시 정보 가져오기
	 * @param map
	 * @return
	 */
	int selectLike(Map<String, Object> map);

	/** 좋아요 수 조회
	 * @param map
	 * @return
	 */
	int selectLikeCount(Map<String, Object> map);

	/** 게시물 한개 조회
	 * @param contentNo
	 * @return
	 */
	Map<String, Object> selectOne(int contentNo);

	/** 후기 조회
	 * @param contentNo
	 * @return
	 */
	List<Reply> selectReply(int contentNo);

	/** 후기 작성
	 * @param contentNo
	 * @param reply
	 * @param memberNo
	 * @return
	 */
	int insertReply(int contentNo, String reply, int memberNo);

	/** 컨텐츠 상세조회
	 * @param map
	 * @return
	 */
	Map<String, Object> searchContent(Map<String, Object> map);

	/** 컨텐츠 업데이트
	 * @param inputContent
	 * @param uploadPlaceImg
	 * @param webPath
	 * @param filePath
	 * @return
	 */
	int updateContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException ;

	/** 지도 핀 꽂기
	 * @return
	 */
	List<Content> selectPlace();

/*
  String mapSearch();
*/
}
