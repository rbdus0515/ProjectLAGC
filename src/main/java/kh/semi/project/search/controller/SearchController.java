package kh.semi.project.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import kh.semi.project.search.model.dto.Search;
import kh.semi.project.search.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	// 검색 조회
	@PostMapping("/search")
	public String searchResult(String inputSearch, Model model) {
		
		List<Search> list = service.searchResult(inputSearch); 
		
		/* for(Search sc : list) {
			System.out.println(sc);
		} */
		
		model.addAttribute("list", list);
		
		return "common/searchPage";
	}

}
