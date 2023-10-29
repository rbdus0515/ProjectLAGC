// ---------------- noticeDetail 조회 ----------------
function noticeDetail(noticeNo) {
    // alert(noticeNo);
    location.href = "/notice/detail?noticeNo=" + noticeNo;
}

// ---------------- 공지사항 삭제 버튼 클릭 시, 삭제 확인창 ----------------
function noticeDeleteConfirm(noticeNo) {
    
    if(!confirm("정말 삭제하시겠습니까?")) { // 취소
    	return;
    }
    
    location.href = "/notice/delete?noticeNo=" + noticeNo;
}

// ---------------- 공지사항 추가 버튼 클릭 시, 제목 및 내용 유효성 검사  ----------------
const insertForm = document.getElementById("insertForm");
const title = document.getElementById("title");
const content = document.getElementById("content2");

insertForm.addEventListener("submit", e=> {
	
	if(title.value == "") {
		alert("제목을 입력해주세요.");
		e.preventDefault();
        return;
	}
	
	if(content.value == "") {
		alert("내용을 입력해주세요.");
		e.preventDefault();
        return;
	}

});

// ---------------- 검색 버튼 클릭 시, 검색창 유효성 검사  ----------------
const searchForm = document.getElementById("noticeSearch");
const searchInput = document.getElementById("searchQuery");

searchForm.addEventListener("submit", e => {
	
    if(searchInput.value == "") {
        alert("검색어 입력 후 검색 버튼을 눌러주세요.");
        e.preventDefault();
        return;
    }

});