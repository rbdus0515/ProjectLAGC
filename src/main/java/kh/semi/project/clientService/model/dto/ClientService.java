package kh.semi.project.clientService.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientService {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeUpload;
	private String noticeDelFl;

}
