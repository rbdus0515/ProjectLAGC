package kh.semi.project.notice.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeDetail;
	private String noticeUploadDate;

}
