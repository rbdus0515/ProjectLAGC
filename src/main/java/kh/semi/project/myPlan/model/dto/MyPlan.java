package kh.semi.project.myPlan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MyPlan {

	private int planNo;
	private int memberNo;
	private String myPlanName;
	private String departDate;
	private String arrivalDate;
	private String departPlace;

	
}
