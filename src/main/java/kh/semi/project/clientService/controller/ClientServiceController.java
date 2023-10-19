package kh.semi.project.clientService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientService")
public class ClientServiceController {
	
	@GetMapping("/clientServicePage")
	public String clientServicePage() {
		
		return "/clientService/clientServicePage";
	}

}
