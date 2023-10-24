const memberId = document.getElementById("memberId");
const inputIdForm = document.getElementById("inputIdForm")

if(inputIdForm != null){ // 비밀번호 변경 페이지인 경우

    inputIdForm.addEventListener("submit", e => {
        
        // 현재 비밀번호 미작성 시
        if(memberId.value.trim() == ""){
            alert("아이디를 입력해주세요");
            e.preventDefault();
            memberId.focus();
            return;
        }

    });
}