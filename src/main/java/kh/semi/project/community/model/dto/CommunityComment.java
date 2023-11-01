package kh.semi.project.community.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CommunityComment {
	
	private int communityCommentNo;
	private String communityCommentContent;
	private int memberNo;
	private int communityNo;
	private String communityTitle;
	private String communityContent;
	
	private String memberNickname;
	private String profileImage;

}
