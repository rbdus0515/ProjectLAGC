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
function noticeAddConfirm() {

	const title = document.getElementById("title");
    const content = document.getElementById("content2");

    if(title.value == null) {
        alert("제목을 입력해주세요.");
        title.focus();
    }
    
    if(content.value == null) {
    	alert("내용을 입력해주세요.");
    	content.focus();
    }

}