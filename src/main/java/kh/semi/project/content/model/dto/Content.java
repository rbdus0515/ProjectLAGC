package kh.semi.project.content.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Content {

	private int contentNo;
	private String areaCode;
	private String travelName;
	private String placeAddress;
	private String ageCode;
	private String seasonCode;
	private String memberCode;
	private String themeCode;
	private String contentDelFl;
	private String contentImg;
	
}
