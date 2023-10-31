// --------------- 검색창 유효성 검사 ---------------
const searchForm = document.getElementById("searchForm");
const inputSearch = document.getElementById("input-search");

searchForm.addEventListener("submit", e => {

	if(inputSearch.value == "") {
		alert("검색어 입력 후 검색 버튼을 눌러주세요.");
		e.preventDefault();
        return;
	}

});