package kh.semi.project.content.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kh.semi.project.common.utility.Util;
import kh.semi.project.content.model.dao.ContentDAO;
import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.dto.Reply;

@Service
public class ContetServiceImpl implements ContentService{

	@Autowired
	private ContentDAO dao;
	
	// content 상세페이지 조회
	@Override
	public List<Content> selectContentDetail(String area) {
		
		return dao.selectContentDetail(area);
	}

	// 이미지 삭제
	@Override
	public int contentDelete(Content content) {
		
		return dao.contentDelete(content);
	}

	// 컨텐츠 추가
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException {
		
		
		String temp = inputContent.getContentImg();
		String rename = null;
		
		if(uploadPlaceImg.getSize() > 0) {
			
			rename = Util.fileRename(uploadPlaceImg.getOriginalFilename());
		
			inputContent.setContentImg(webPath + rename);
		
		} else {
			inputContent.setContentImg(null);
		}
		
		int result = dao.insertContent(inputContent);
		
		if(result > 0) {
			
			if(rename != null) {
				uploadPlaceImg.transferTo(new File(filePath + rename));
			}
			
		} else {
			inputContent.setContentImg(temp);
		}
		
		return result;
	}

	/** 메인화면에서 보여줄 컨텐츠 전체 조회
	 * 
	 */
	@Override
	public List<Content> selectAll() {

		return dao.selectAll();
	}

	/** 모달창 오픈시 정보 가져오기
	 *
	 */
	@Override
	public int selectLike(Map<String, Object> map) {

		return dao.selectLike(map);
	}

	/** 좋아요 개수 조회
	 *
	 */
	@Override
	public int selectLikeCount(Map<String, Object> map) {

		return dao.selectLikeCount(map);
	}

	/** 게시물 한개 조회
	 *
	 */
	@Override
	public Map<String, Object> selectOne(int contentNo) {

		return dao.selcetOne(contentNo);
	}
	
	/** 후기 조회 서비스
	 *
	 */
	@Override
	public List<Reply> selectReply(int contentNo) {

		return dao.seletReply(contentNo);
	}

	/** 후기 작성
	 *
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertReply(int contentNo, String reply, int memberNo) {

		String XSSreply = Util.XSSHandling(reply);
		
		return dao.insertReply(contentNo, XSSreply, memberNo);
	}

	// 컨텐츠 상세 조회
	@Override
	public Content searchContent(Map<String, Object> map) {
		return dao.searchContent(map);
	}

	// 컨텐츠 업데이트
	@Override
	public int updateContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException {
		
		String temp = inputContent.getContentImg();
		String rename = null;
		
		if(uploadPlaceImg.getSize() > 0) {
			
			rename = Util.fileRename(uploadPlaceImg.getOriginalFilename());
		
			inputContent.setContentImg(webPath + rename);
		
		} else {
			inputContent.setContentImg(null);
		}
		
		int result = dao.updateContent(inputContent);
		
		if(result > 0) {
			
			if(rename != null) {
				uploadPlaceImg.transferTo(new File(filePath + rename));
			}
			
		} else {
			inputContent.setContentImg(temp);
		}
		
		return result;
	}


	
}


















