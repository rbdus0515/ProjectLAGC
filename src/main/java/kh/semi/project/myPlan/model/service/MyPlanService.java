package kh.semi.project.myPlan.model.service;

import java.util.List;

public interface MyPlanService {

	List<Integer> selecetMyPlanList();

	List<Integer> selecetMyPlanDetailList();

	int deleteDetail(Integer pd);
	
	
}
