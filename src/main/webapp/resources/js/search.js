// --------------- 검색창 유효성 검사 ---------------
if(searchForm != null) {

	const searchForm = document.getElementById("searchForm");
	const inputSearch = document.getElementById("input-search");
	
	searchForm.addEventListener("submit", e => {
	
		if(inputSearch.value == "") {
			alert("검색어 입력 후 검색 버튼을 눌러주세요.");
			e.preventDefault();
	        return;
		}
	
	})

};

// --------------- 비회원이 내 일정 추가 클릭 시, 유효성 검사 ---------------
if(addMyPlan != null) {

	const addMyPlan = document.getElementById("addMyPlan");
	
	addMyPlan.addEventListener("click", e => {
	
		if (memberNo == "") {

		    alert("로그인 후 이용해주세요");
		    e.preventDefault();
		    return;
	
	  	}
		
	})

};