package kh.semi.project.content.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.semi.project.common.utility.Util;
import kh.semi.project.content.model.dao.ContentDAO;
import kh.semi.project.content.model.dto.Content;

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
	@Override
	public int insertContent(Content inputContent, MultipartFile uploadPlaceImg, String webPath, String filePath) throws Exception, IOException {
		
		String temp = inputContent.getContentImg();
		String rename = null;
		
		if(uploadPlaceImg.getSize() > 0) {
			
			rename = Util.fileRename(uploadPlaceImg.getOriginalFilename());
		
			inputContent.setContentImg(rename);
		
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

	
}


















