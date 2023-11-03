package kh.semi.project.myPlan.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPlanDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/** 나의 여행 계획 PLAN_NO 조회
	 * @return
	 */
	public List<Integer> selectMyPlanList() {

		return sqlSession.selectList("myPageMapper.selectMyPlanList");
	}


	/** 나의 여행 계획 세부 PLAN_NO 조회
	 * @return
	 */
	public List<Integer> selectMyPlanDetailList() {

		return sqlSession.selectList("myPageMapper.selectMyPlanDetailList");
	}


	/** 나의 여행 계획 세부 제거(매주 월요일)
	 * @param pd
	 * @return
	 */
	public int deleteDetail(Integer pd) {

		return sqlSession.delete("myPageMapper.deleteDetail", pd);
	}

}
