package kh.semi.project.myPlan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.semi.project.content.model.dto.Content;
import kh.semi.project.content.model.service.ContentService;
import kh.semi.project.member.model.dto.Member;

@Controller
@RequestMapping("/myPlan")
@SessionAttributes({"loginMember"})
public class MyPlanController {

	@Autowired
	private ContentService service;
	
	/** 나의 일정 이동
	 * @param model
	 * @param loginMember
	 * @return
	 */
	@GetMapping("/myPlans")
	public String MyPlanPage(Model model,
							 @SessionAttribute("loginMember") Member loginMember
			) {
		
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
		
		
		return "myPlan/myPlan";
	}

	
	@GetMapping("/myPlans")
	public String mapSearch() {
		
		return service.mapSearch();
		
	/** 지도 핀 꽂기
	 * @return
	 */
	@GetMapping("/selectPlace")
	@ResponseBody
	public List<Content> selectPlace() {
		
		List<Content> list = service.selectPlace();
		
		System.out.println(list);
		
		return list;

	}
}
