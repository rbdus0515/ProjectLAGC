const changePw = document.getElementById("changePw");
const newMemberPw = document.getElementById("newMemberPw");
const newMemberPwConfirm = document.getElementById("newMemberPwConfirm");


changePw.addEventListener("submit", e => {

    if (newMemberPw.value.trim() == "") {
        alert("바꿀 비밀번호를 입력해주세요");
        newMemberPw.focus();
        e.preventDefault();
        return;
    }

    if (newMemberPwConfirm.value.trim() == "") {
        alert("확인 비밀번호를 입력해주세요");
        newMemberPw.focus();
        e.preventDefault();
        return;
    }

    // 비밀번호 유효성 검사
    const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;
    if (!regEx.test(newMemberPw.value)) {
        alert("비밀번호가 유효하지 않습니다");
        newMemberPw.focus();
        e.preventDefault();
        return;
    }

    // 비밀번호 == 비밀번호 확인
    if (newMemberPw.value != newMemberPwConfirm.value) {
        alert("비밀번호가 일치하지 않습니다");
        newMemberPwConfirm.focus();
        e.preventDefault();
        return;
    }
});
