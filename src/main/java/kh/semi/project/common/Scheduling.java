package kh.semi.project.common;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kh.semi.project.myPlan.model.service.MyPlanService;

public class Scheduling {

	@Component
	public class myPlanDeleteScheduling {

		@Autowired
		private MyPlanService service;

		/** 여행 계획 지우기(매주 월요일 12시)
		 * 
		 */
		@Scheduled(cron = "0 0 12 * * 2") 
		public void deleteMyPlanDetail() {
			
			List<Integer> MyPlanList = service.selecetMyPlanList();
			List<Integer> MyPlanDetailList = service.selecetMyPlanDetailList();
			
			int result = 0;
			String deleteList = "삭제된 나의 여행 계획 번호는 : ";
			
			for(Integer p : MyPlanList) {
					
				for(Integer pd : MyPlanDetailList) {
					
					if(p != pd) {
						
						result += service.deleteDetail(pd);
						deleteList += pd + ", ";
					}
				}
			}
			
			if(result > 0) {
			
				System.out.println(deleteList + "입니다.");
				
			} else {
				
				System.out.println("삭제된 목록이 없습니다.");
			}
			
			
		}
		
	}
}
