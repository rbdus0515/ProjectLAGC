package kh.semi.project.clientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.semi.project.clientService.model.dto.ClientService;
import kh.semi.project.clientService.model.service.ClientServiceService;

@Controller
@RequestMapping("/clientService")
public class ClientServiceController {
	
	@Autowired
	private ClientServiceService service;
	
	@GetMapping("/clientServicePage")
	public String clientServicePage(Model model) {
		
		List<ClientService> list = service.noticeList();
		model.addAttribute("list", list);
		
		return "/clientService/clientServicePage";
	}

}
