package kh.semi.project.myPlan.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.semi.project.myPlan.model.dao.MyPlanDAO;

@Service
public class MyPlanServiceImpl implements MyPlanService{

	@Autowired
	private MyPlanDAO dao;

	/** 나의 여행 계획 PLAN_NO 조회
	 *
	 */
	@Override
	public List<Integer> selecetMyPlanList() {

		return dao.selectMyPlanList();
	}

	/** 나의 여행 계획 세부 PLAN_NO 조회
	 *
	 */
	@Override
	public List<Integer> selecetMyPlanDetailList() {

		return dao.selectMyPlanDetailList();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteDetail(Integer pd) {

		return dao.deleteDetail(pd);
	}

}
