let loginFrm = document.getElementById("loginFrm");
let memberId = document.getElementById("memberId");
let memberPw = document.getElementById("memberPw");

if(loginFrm != null){

    loginFrm.addEventListener("submit", e => {

        if(memberId.value.trim().length == 0){
            alert("아이디를 입력해주세요.");

            memberId.value = "";

            e.preventDefault(); 
            return; 
        }


        if(memberPw.value.trim().length == 0){
            alert("비밀번호를 입력해주세요.");

            memberPw.value = ""; 

            e.preventDefault(); 
            return; 
        }


    });
}
