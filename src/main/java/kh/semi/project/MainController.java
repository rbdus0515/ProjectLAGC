package kh.semi.project;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.service.ContentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ContentService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Model model) {
		
		List<Content> list = new ArrayList<Content>(); 
		
		list = service.selectAll();
		
		model.addAttribute("list", list);

		List<Content> seoList = new ArrayList<Content>();
		List<Content> gyeincList = new ArrayList<Content>();
		List<Content> ganList = new ArrayList<Content>();
		List<Content> chuList = new ArrayList<Content>();
		List<Content> jeoList = new ArrayList<Content>();
		List<Content> gyeList = new ArrayList<Content>();
		List<Content> jejList = new ArrayList<Content>();
		
		
		for(Content content : list ) {
			if(content.getAreaCode().equals("seo")) {
				seoList.add(content);
			} else if(content.getAreaCode().equals("gyeinc")) {
				gyeincList.add(content);
			} else if(content.getAreaCode().equals("gan")) {
				ganList.add(content);
			} else if(content.getAreaCode().equals("chu")) {
				chuList.add(content);
			} else if(content.getAreaCode().equals("jeo")) {
				jeoList.add(content);
			} else if(content.getAreaCode().equals("gye")) {
				gyeList.add(content);
			} else {
				jejList.add(content);
			}
				
		}
		
		model.addAttribute("seoList", seoList);
		model.addAttribute("gyeincList", gyeincList);
		model.addAttribute("ganList", ganList);
		model.addAttribute("chuList", chuList);
		model.addAttribute("jeoList", jeoList);
		model.addAttribute("gyeList", gyeList);
		model.addAttribute("jejList", jejList);
		
		return "/common/main";
	}
	
}
