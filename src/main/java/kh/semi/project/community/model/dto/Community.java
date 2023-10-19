package kh.semi.project.community.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Community {

	private int communityNo;
	private int memberNo;
	private String communityTitle;
	private String communityContent;
	private String createDt;
	private int readCount;
	private String communityDelFl;
	
	private String profileImg;
	private String nickName;
	
}
