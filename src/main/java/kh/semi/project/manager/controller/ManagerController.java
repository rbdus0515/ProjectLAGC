package kh.semi.project.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	/** 1:1 문의 조회
	 * @param doneOrYet
	 * @return
	 */
	@GetMapping("/managingAsk")
	@ResponseBody
	public List<QNA> QNACheck(@RequestParam String doneOrYet) {
		
		List<QNA> list = new ArrayList<QNA>();
		
		if(doneOrYet.equals("notYet")) {
			
			list = service.selectQNA();
			
		} else {
			
			list = service.selectQNADone();
		}
		
		return list;
	}
	
	@GetMapping("/insert")
	public String insert(String answerArea, int qnaNo, RedirectAttributes ra) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("answerArea", answerArea);
		map.put("qnaNo", qnaNo);
		
		int result = service.insertAnswer(map);
		
		String msg = null;
		String path = "redirect:/manager/managingQNA";
		
		if(result > 0) {
			msg = "답변 제출 완료";
		} else {
			msg = "답변 제출 실패";
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}
	
	
	@GetMapping("/update")
	public String update(String answerArea, int qnaNo, RedirectAttributes ra) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("answerArea", answerArea);
		map.put("qnaNo", qnaNo);
		
		int result = service.updateAnswer(map);
		
		String msg = null;
		String path = "redirect:/manager/managingQNA";
		
		if(result > 0) {
			msg = "답변 수정 완료";
		} else {
			msg = "답변 수정 실패";
		}
		
		ra.addFlashAttribute("msg", msg);
		
		return path;
	}
	
	
}
