const checkObj = {
    "memberName" : false,
    "memberEmail" : false,
    "authKey" : false
};

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
        } else{
        }

    });
}



const noUse = document.getElementById("noUse")
noUse.addEventListener("click", () => {

    alert("더 나은 서비스를 위헤 점검 중입니다.\n\n이메일 인증으로 진행해주세요")
        return;
})

// 인증번호 발송
const sendAuthKeyEmail = document.getElementById("sendAuthKeyEmail");
const authKeyMessage = document.getElementById("authKeyMessage");
const memberEmail = document.getElementById("memberEmail");
let authTimer;
let authMin = 2
let authSec = 59;

// 인증번호를 발송한 이메일 저장
let tempEmail;

sendAuthKeyEmail.addEventListener("click", e => {

        fetch("/email/sendAuthKeyForId?memberEmail="+memberEmail.value)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                alert("인증번호가 발송 되었습니다.");
                tempEmail = memberEmail.value;
                checkObj.memberEmail = true;

                authKeyMessage.innerText = "03:00";
                authKeyMessage.classList.remove("confirm");

                 authTimer = window.setInterval(()=>{
													// 삼항연산자  :  조건 	  ?   	true : false
                authKeyMessage.innerText = "0" + authMin + ":" + (authSec < 10 ? "0" + authSec : authSec);
                
                // 남은 시간이 0분 0초인 경우
                if(authMin == 0 && authSec == 0){
                    clearInterval(authTimer);
                    e.preventDefault();
                    return;
                }

                // 0초인 경우
                if(authSec == 0){
                    authSec = 60;
                    authMin--;
                }

                authSec--; // 1초 감소

            }, 1000)

            }else if(result == 0 ){ 
                console.log("인증번호 발송 실패")
            }else{
                alert("가입 정보가 없는 이메일입니다.")
                checkObj.memberEmail = false;
                return;
            }
        })
        .catch(err => {
            console.log("이메일 발송 중 에러 발생");
            console.log(err);
        });
        
});

// 인증 확인
const checkEmail = document.getElementById("checkEmail");
const certifyBtnEmail = document.getElementById("certifyBtnEmail");

certifyBtnEmail.addEventListener("click",  () => {

    if(authMin > 0 || authSec > 0){ // 시간 제한이 지나지 않은 경우에만 인증번호 검사 진행
        /* fetch API */
        const obj = {"inputKey":checkEmail.value, "memberEmail":tempEmail}
        const query = new URLSearchParams(obj).toString()

        fetch("/email/checkAuthKey?" + query)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                clearInterval(authTimer);
                alert("인증되었습니다.");
                checkObj.authKey = true;

            } else{
                alert("인증번호가 일치하지 않습니다.")
                checkObj.authKey = false;
            }
        })
        .catch(err => console.log(err));


    } else{
        alert("인증 시간이 만료되었습니다. 다시 시도해주세요.")
    }

});

const emailFrm = document.getElementById("emailFrm");

emailFrm.addEventListener("submit", e=>{

    if(memberName.value.trim() == ""){
        alert("이름을 입력해주세요");
        e.preventDefault();
        memberName.focus();
        checkObj.memberName = false;
        return;
    } else{
        checkObj.memberName = true;
    }

    if(memberEmail.value.trim() == ""){
        alert("이메일을 입력해주세요");
        e.preventDefault();
        memberEmail.focus();
        checkObj.memberEmail = false;
        return;
    } else{
        checkObj.memberEmail = true;
    }

    if(checkEmail.value.trim() == ""){
        alert("이메일 인증을 진행해주세요");
        e.preventDefault();
        checkEmail.focus();
        return;
    } 

    for(let key in checkObj){

        if(!checkObj[key]){ 

            switch(key){
            case "memberName": 
                alert("이름이 유효하지 않습니다"); break;

            case "memberEmail": 
                alert("이메일이 유효하지 않습니다"); break;

            document.getElementById(key).focus();

            e.preventDefault(); // form 태그 기본 이벤트 제거
            return; // 함수 종료
        }
    }

    }
});
