package kh.semi.project.member.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Member {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPno;
	private String memberEmail;
	private String memberPhone;
	private String memberNickname;
	private String memberProfileImage;
	private String memberDeleteFlag;
	private String enrollDate;
	
}
