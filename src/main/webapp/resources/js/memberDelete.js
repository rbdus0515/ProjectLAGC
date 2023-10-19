const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const memberDelete = document.getElementById("memberDelete");

memberDelete.addEventListener("submit", () => {
    
    if (memberPw.value != memberPwConfirm.value) {
        
        alert("비밀번호가 일치하지 않습니다");
    
        return;
    } 
    
})


