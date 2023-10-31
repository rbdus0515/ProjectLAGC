package kh.semi.project.search.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.semi.project.search.model.dto.Search;

@Repository
public class SearchDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/** 검색 조회
	 * @param inputSearch
	 * @return List
	 */
	public List<Search> searchResult(String inputSearch) {
		
		return sqlSession.selectList("searchMapper.searchResult", inputSearch);
	}

}
