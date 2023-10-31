package kh.semi.project.content.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reply {
	
	private int replyNo;
	private int contentNo;
	private String replyContent;
	private int memberNo;
	private String replyDeleteFlag;
}
