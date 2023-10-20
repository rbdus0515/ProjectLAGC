const memberPw = document.getElementById("memberPw");
const memberPwConfirm = document.getElementById("memberPwConfirm");
const memberDelete = document.getElementById("memberDelete");
const deleteConfirm = document.getElementById("deleteConfirm");

memberDelete.addEventListener("submit", e => {
   
    if(memberPw.value.trim().length == 0){
        memberPw.value = "";
        
        alert("비밀번호를 입력해주세요");
        e.preventDefault(); 
        return; 

    }

    if(memberPwConfirm.value.trim().length == 0){
        memberPwConfirm.value = "";
        
        alert("확인 비밀번호를 입력해주세요");
        e.preventDefault(); 
        return; 

    }
    
    if (!deleteConfirm.checked){

        alert("회원 탈퇴에 동의하지 않으셨습니다.");
        
        e.preventDefault(); 
        return;
    } 
    
    if (memberPw.value != memberPwConfirm.value) {
        
        alert("비밀번호와 확인 비밀번호가 일치하지 않습니다");
        e.preventDefault(); 
        return; 
    } 

  
})


