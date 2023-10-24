// ---------------- X 버튼 클릭 시, 삭제 확인창 ----------------
function contentDeleteConfirm(contentNo, areaCode) {
    // alert(contentNo);
    if(!confirm("정말 삭제하시겠습니까?")) { // 취소
    	return;
    	
    }
    
   location.href = "/content/delete?contentNo=" + contentNo + "&areaCode=" + areaCode; 
}