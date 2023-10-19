package kh.semi.project.myPlan.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.semi.project.myPlan.model.dao.MyPlanDAO;

@Service
public class MyPlanServiceImpl implements MyPlanService{

	@Autowired
	private MyPlanDAO dao;
}
