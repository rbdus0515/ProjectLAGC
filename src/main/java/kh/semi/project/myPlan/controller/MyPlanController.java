package kh.semi.project.myPlan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPlan")
public class MyPlanController {

	@GetMapping("/myPlans")
	public String MyPlanPage() {
		
		return "myPlan/myPlan";
	}
}
