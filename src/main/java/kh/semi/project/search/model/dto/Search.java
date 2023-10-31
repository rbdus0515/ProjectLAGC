package kh.semi.project.search.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Search {
	
	private String contentImg;
	private String travelName;
	private String placeUrl;
	private String placeInfo;
	private String area;
	private int likeCount;

}
