const memberPw = document.getElementById("memberPw");
const newMemberPw = document.getElementById("newMemberPw");
const newMemberPwConfirm = document.getElementById("newMemberPwConfirm");
const updatePw = document.getElementById("updatePw");

if(updatePw != null){ // 비밀번호 변경 페이지인 경우

    updatePw.addEventListener("submit", e => {
        
        // 현재 비밀번호 미작성 시
        if(memberPw.value.trim() == ""){
            alert("현재 비밀번호를 입력해주세요");
            e.preventDefault();
            memberPw.focus();
            return;
        }

        if(newMemberPw.value.trim() == ""){
            alert("바꿀 비밀번호를 입력해주세요");
            e.preventDefault();
            newMemberPw.focus();
            return;
        }

        if(newMemberPwConfirm.value.trim() == ""){
            alert("확인 비밀번호를 입력해주세요");
            e.preventDefault();
            newMemberPw.focus();
            return;
        }

        // 비밀번호 유효성 검사
        const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;
        if(!regEx.test(newMemberPw.value)){
            alert("비밀번호가 유효하지 않습니다");
            e.preventDefault();
            newMemberPw.focus();
            return;
        }

        // 비밀번호 == 비밀번호 확인
        if(newMemberPw.value != newMemberPwConfirm.value){
            alert("비밀번호가 일치하지 않습니다");
            e.preventDefault();
            newMemberPwConfirm.focus();
            return;
        }
    });
}