package kh.semi.project.search.service;

import java.util.List;

import kh.semi.project.search.model.dto.Search;

public interface SearchService {

	/** 검색 조회
	 * @param inputSearch
	 * @return List
	 */
	List<Search> searchResult(String inputSearch);

}
