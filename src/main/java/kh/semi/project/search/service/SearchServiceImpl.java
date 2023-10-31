package kh.semi.project.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.search.model.dao.SearchDAO;
import kh.semi.project.search.model.dto.Search;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDAO dao;

	// 검색 조회
	@Override
	public List<Search> searchResult(String inputSearch) {
		
		return dao.searchResult(inputSearch);
	}
	
	

}
