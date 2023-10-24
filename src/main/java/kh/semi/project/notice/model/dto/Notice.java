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
	private String noticeDelFl;
	
	// 이전글, 다음글 가져오기 위한 컬럼
	private int preNoticeNo;
	private String preNoticeTitle;
	private int nextNoticeNo;
	private String nextNoticeTitle;

}
