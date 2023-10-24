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