package kh.semi.project.manager.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class QNA {

	private int QNANo;
	private String QNATitle;
	private String QNAContent;
	private String QNAAnswer;
	private String answerFlag;
	private int memberNo;
	
	private String memberEmail;
	private String memberNickname;
	private String memberPhone;
	
}
