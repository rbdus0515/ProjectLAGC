package kh.semi.project.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.semi.project.manager.model.dto.QNA;
import kh.semi.project.manager.model.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService service;
	
	/** 1:1 문의 이동
	 * @return
	 */
	@GetMapping("/managingQNA")
	public String managingAsk(Model model) {
		
		List<QNA> list = new ArrayList<QNA>();
		
		list = service.selectQNA();
		
		model.addAttribute("list", list);
		
		return "/manager/managingAsk";
	}
	
	@GetMapping("/managingAsk")
	@ResponseBody
	public List<QNA> QNACheck(@RequestParam String doneOrYet, 
							  Model model
							  ) {
		
		List<QNA> list = new ArrayList<QNA>();
		
		if(doneOrYet.equals("notYet")) {
			
			list = service.selectQNA();
			
		} else {
			
			list = service.selectQNADone();
		}
		
		return list;
	}
}
