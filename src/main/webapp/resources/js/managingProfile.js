const checkObj = {
    "memberId" : false,
    "memberName" : false,
    "memberPhone" : false,
    "memberNickname" : false,
    "memberEmail" : false,
    "authKey" : false
};

// ---------------- 아이디 유효성 검사 ------------------------
const memberId = document.getElementById("memberId");
const idMessage = document.getElementById("idMessage");

memberId.addEventListener("input", () => {

    if(memberId.value.trim().length == 0){
        memberId.value = ""; 

        idMessage.innerText = "영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";

        // confirm, error 클래스 삭제해서 검정 글씨로 만들기
        idMessage.classList.remove("confirm", "error");

        checkObj.memberId = false; // 빈칸 == 유효 X
        return;
    }

    const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;

    if(  regEx.test(memberId.value)  ){ // 유효한 경우

        fetch("/selectId?memberId=" + memberId.value)
        .then(res => res.text())
        .then(count => {
            if(count == 0) {
                idMessage.innerText = "사용 가능한 아이디입니다";
                idMessage.classList.add("confirm"); // .confirm 스타일 적용
                idMessage.classList.remove("error"); // .error 스타일 제거
                checkObj.memberId = true; // 유효 O
            } else {
                idMessage.innerText = "이미 사용중인 아이디입니다";
                idMessage.classList.add("error"); // .error 스타일 적용
                idMessage.classList.remove("confirm"); // .confirm 스타일 제거
                checkObj.memberId = false; // 유효 X

            }
        })
        .catch(err => {console.log(err)});



    } else{ // 유효하지 않은 경우(무효인 경우)
        idMessage.innerText = "아이디 형식이 유효하지 않습니다";
        idMessage.classList.add("error"); // .error 스타일 적용
        idMessage.classList.remove("confirm"); // .confirm 스타일 제거

        checkObj.memberId = false; // 유효 X
    }
});


// ----------------- 비밀번호/비밀번호 확인 유효성 검사 ---------------------
// const memberPw = document.getElementById("memberPw");
// const memberPwConfirm = document.getElementById("memberPwConfirm");
// const pwMessage = document.getElementById("pwMessage");

// // 비밀번호 입력 시 유효성 검사
// memberPw.addEventListener("input", () => {

//     // 비밀번호가 입력되지 않은 경우
//     if(memberPw.value.trim().length == 0){
//         memberPw.value = ""; // 띄어쓰지 못넣게 하기

//         pwMessage.innerText = "영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이로 입력해주세요.";
//         pwMessage.classList.remove("confirm", "error"); // 검정 글씨

//         checkObj.memberPw = false; // 빈칸 == 유효 X
//         return;
//     }


//     // 정규 표현식을 이용한 비밀번호 유효성 검사

//     // 영어,숫자,특수문자(!,@,#,-,_) 6~20글자 사이
//     const regEx = /^[a-zA-Z0-9\!\@\#\-\_]{6,20}$/;

//     // 입력한 비밀번호가 유효한 경우
//     if(regEx.test(memberPw.value)){
//         checkObj.memberPw = true; 
        
//         // 비밀번호가 유효하게 작성된 상태에서
//         // 비밀번호 확인이 입력되지 않았을 때
//         if(memberPwConfirm.value.trim().length == 0){

//             pwMessage.innerText = "유효한 비밀번호 형식입니다";
//             pwMessage.classList.add("confirm");
//             pwMessage.classList.remove("error");
        
//         }else{
//             // 비밀번호가 유효하게 작성된 상태에서
//             // 비밀번호 확인이 입력되어 있을 때

//             // 비밀번호 == 비밀번호 확인  (같을 경우)
//             if(memberPw.value == memberPwConfirm.value){
//                 pwMessage.innerText = "비밀번호가 일치합니다";
//                 pwMessage.classList.add("confirm");
//                 pwMessage.classList.remove("error");
//                 checkObj.memberPwConfirm = true;
                
//             } else{ // 다를 경우
//                 pwMessage.innerText = "비밀번호가 일치하지 않습니다";
//                 pwMessage.classList.add("error");
//                 pwMessage.classList.remove("confirm");
//                 checkObj.memberPwConfirm = false;
//             }
//         }

        
//     } else{ // 유효하지 않은 경우
        
//         pwMessage.innerText = "비밀번호 형식이 유효하지 않습니다";
//         pwMessage.classList.add("error");
//         pwMessage.classList.remove("confirm");
//         checkObj.memberPw = false; 
//     }
// });


// // 비밀번호 확인 유효성 검사
// memberPwConfirm.addEventListener('input', ()=>{

//     if(checkObj.memberPw){ // 비밀번호가 유효하게 작성된 경우에

//         // 비밀번호 == 비밀번호 확인  (같을 경우)
//         if(memberPw.value == memberPwConfirm.value){
//             pwMessage.innerText = "비밀번호가 일치합니다";
//             pwMessage.classList.add("confirm");
//             pwMessage.classList.remove("error");
//             checkObj.memberPwConfirm = true;
            
//         } else{ // 다를 경우
//             pwMessage.innerText = "비밀번호가 일치하지 않습니다";
//             pwMessage.classList.add("error");
//             pwMessage.classList.remove("confirm");
//             checkObj.memberPwConfirm = false;
//         }

//     } else { // 비밀번호가 유효하지 않은 경우
//         checkObj.memberPwConfirm = false;
//     }
// });


// -------------- 이름 유효성 검사 -----------------
const memberName = document.getElementById("memberName");
const nameMessage = document.getElementById('nameMessage');

// 이름이 입력이 되었을 때
memberName.addEventListener("input", ()=>{

    // 이름 입력이 되지 않은 경우
    if(memberName.value.trim() == ''){
        nameMessage.innerText = "한글을 2~5글자를 입력해주세요.";
        nameMessage.classList.remove("confirm", "error");
        checkObj.memberName = false;
        memberName.value = ""; 
        return;
    }

    // 정규표현식으로 유효성 검사
    const regEx = /^[가-힣]{2,5}$/;

    if(regEx.test(memberName.value)){ // 유효
        nameMessage.innerText = "이름 형식이 유효합니다.";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.memberName = true;

    } else{ // 무효
        nameMessage.innerText = "이름 형식이 유효하지 않습니다";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkObj.memberName = false;
    }

});

// -------------- 전화번호 유효성 검사 -----------------
const memberPhone = document.getElementById("memberPhone");
const phoneMessage = document.getElementById('phoneMessage');

// 전화번호가 입력이 되었을 때
memberPhone.addEventListener("input", ()=>{

    // 전화번호 입력이 되지 않은 경우
    if(memberPhone.value.trim() == ''){
        phoneMessage.innerText = "숫자만 입력해주세요.";
        phoneMessage.classList.remove("confirm", "error");
        checkObj.memberPhone = false;
        memberPhone.value = ""; 
        return;
    }

    // 정규표현식으로 유효성 검사
    const regEx = /^[0-9]{10,11}$/;

    if(regEx.test(memberPhone.value)){ // 유효
        phoneMessage.innerText = "전화번호 형식이 유효합니다.";
        phoneMessage.classList.add("confirm");
        phoneMessage.classList.remove("error");
        checkObj.memberPhone = true;

    } else{ // 무효
        phoneMessage.innerText = "전화번호 형식이 유효하지 않습니다";
        phoneMessage.classList.add("error");
        phoneMessage.classList.remove("confirm");
        checkObj.memberPhone = false;
    }

});

// ---------------- 닉네임 유효성 검사 ------------------------
const memberNickname = document.getElementById("memberNickname");
const nicknameMessage = document.getElementById("nicknameMessage");

memberNickname.addEventListener("input", () => {

    if(memberNickname.value.trim().length == 0){
        memberNickname.value = ""; 

        nicknameMessage.innerText = "영어, 한글, 숫자 포함 10글자 이내로 입력해주세요.";

        // confirm, error 클래스 삭제해서 검정 글씨로 만들기
        nicknameMessage.classList.remove("confirm", "error");

        checkObj.memberNickname = false; // 빈칸 == 유효 X
        return;
    }

    const regEx = /^[가-힣a-zA-Z0-9]{1,10}$/;

    if(  regEx.test(memberNickname.value)  ){ // 유효한 경우

        fetch("/selectNickname?nickname=" + memberNickname.value)
        .then(res => res.text())
        .then(count => {
            if(count == 0) {
                nicknameMessage.innerText = "사용 가능한 닉네임입니다";
                nicknameMessage.classList.add("confirm"); // .confirm 스타일 적용
                nicknameMessage.classList.remove("error"); // .error 스타일 제거
                checkObj.memberNickname = true; // 유효 O
            } else {
                nicknameMessage.innerText = "이미 사용중인 닉네임입니다";
                nicknameMessage.classList.add("error"); // .error 스타일 적용
                nicknameMessage.classList.remove("confirm"); // .confirm 스타일 제거
                checkObj.memberNickname = false; // 유효 X

            }
        })
        .catch(err => {console.log(err)});



    } else{ // 유효하지 않은 경우(무효인 경우)
        nicknameMessage.innerText = "닉네임 형식이 유효하지 않습니다";
        nicknameMessage.classList.add("error"); // .error 스타일 적용
        nicknameMessage.classList.remove("confirm"); // .confirm 스타일 제거

        checkObj.memberNickname = false; // 유효 X
    }
});



// ----------------------- 이메일 유효성 검사 / 인증번호 ----------------------------
// 이메일 유효성 검사
const memberEmail = document.getElementById("memberEmail");
const emailMessage = document.getElementById("emailMessage");

// 이메일이 입력될 때 마다
memberEmail.addEventListener("input", () => {

    if(currentEmail == memberEmail.value){
        emailMessage.innerText = "사용 가능한 이메일입니다";
        emailMessage.classList.add("confirm"); // .confirm 스타일 적용
        emailMessage.classList.remove("error"); // .error 스타일 제거

        checkObj.memberEmail = true;
        checkObj.authKey = true;

        return;
    }



    // 입력된 이메일이 없을 경우
    if(memberEmail.value.trim().length == 0){
        memberEmail.value = ""; 

        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";

        // confirm, error 클래스 삭제해서 검정 글씨로 만들기
        emailMessage.classList.remove("confirm", "error");

        checkObj.memberEmail = false; // 빈칸 == 유효 X
        return;
    }

    // 정규 표현식을 이용해서 유효한 형식이지 판별
    // 1) 정규표현식 객체 생성
    const regEx = /^[A-Za-z\d\-\_]{4,}@[가-힣\w\-\_]+(\.\w+){1,3}$/;

    // 2) 입력 받은 이메일과 정규식 일치 여부 판별
    if(  regEx.test(memberEmail.value)  ){ // 유효한 경우

        emailMessage.innerText = "사용 가능한 이메일입니다";
        emailMessage.classList.add("confirm"); // .confirm 스타일 적용
        emailMessage.classList.remove("error"); // .error 스타일 제거
       
        checkObj.memberEmail = true; // 유효 O
 
    } else{ // 유효하지 않은 경우(무효인 경우)
        emailMessage.innerText = "이메일 형식이 유효하지 않습니다";
        emailMessage.classList.add("error"); // .error 스타일 적용
        emailMessage.classList.remove("confirm"); // .confirm 스타일 제거

        checkObj.memberEmail = false; // 유효 X
    }
});


// --------------------- 이메일 인증 ---------------------

// 인증번호 발송
const sendAuthKeyEmail = document.getElementById("sendAuthKeyEmail");
const authKeyMessage = document.getElementById("authKeyMessage");
let authTimer;
let authMin = 4;
let authSec = 59;

// 인증번호를 발송한 이메일 저장
let tempEmail;

sendAuthKeyEmail.addEventListener("click", function(){
    authMin = 2;
    authSec = 59;

    checkObj.authKey = false;

    if(checkObj.memberEmail){ // 중복이 아닌 이메일인 경우

        fetch("/email/sendAuthKey?memberEmail="+memberEmail.value)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                console.log("인증 번호가 발송되었습니다.")
                tempEmail = memberEmail.value;
            }else{
                console.log("인증번호 발송 실패")
            }
        })
        .catch(err => {
            console.log("이메일 발송 중 에러 발생");
            console.log(err);
        });
        

        alert("인증번호가 발송 되었습니다.");
        
        authKeyMessage.innerText = "03:00";
        authKeyMessage.classList.remove("confirm");

        authTimer = window.setInterval(()=>{
													// 삼항연산자  :  조건 	  ?   	true : false
            authKeyMessage.innerText = "0" + authMin + ":" + (authSec < 10 ? "0" + authSec : authSec);
            
            // 남은 시간이 0분 0초인 경우
            if(authMin == 0 && authSec == 0){
                checkObj.authKey = false;
                clearInterval(authTimer);
                return;
            }

            // 0초인 경우
            if(authSec == 0){
                authSec = 60;
                authMin--;
            }


            authSec--; // 1초 감소

        }, 1000)

    } else{
        alert("중복되지 않은 이메일을 작성해주세요.");
        memberEmail.focus();
    }
});

// 인증 확인
const checkEmail = document.getElementById("checkEmail");
const certifyBtnEmail = document.getElementById("certifyBtnEmail");

certifyBtnEmail.addEventListener("click", function(){

    if(authMin > 0 || authSec > 0){ // 시간 제한이 지나지 않은 경우에만 인증번호 검사 진행
        /* fetch API */
        const obj = {"inputKey":checkEmail.value, "memberEmail":tempEmail}
        const query = new URLSearchParams(obj).toString()
        // inputKey=123456&email=user01

        fetch("/email/checkAuthKey?" + query)
        .then(resp => resp.text())
        .then(result => {
            if(result > 0){
                clearInterval(authTimer);
                authKeyMessage.innerText = "인증되었습니다.";
                authKeyMessage.classList.add("confirm");
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


// 회원 가입 form태그가 제출 되었을 때
document.getElementById("updateFrm").addEventListener("submit", e=>{

    for(let key in checkObj){

        if(!checkObj[key]){ // 각 key에 대한 value(true/false)를 얻어와
                            // false인 경우 == 유효하지 않다!

            switch(key){
            case "memberId": 
                alert("아이디가 유효하지 않습니다"); break;
            
            case "memberName" : 
                alert("이름이 유효하지 않습니다"); break;
            
            case "memberEmail" : 
                alert("이메일 주소가 유효하지 않습니다"); break;
           
            case "memberPhone" : 
                alert("전화번호가 유효하지 않습니다"); break;
            
            case "memberNickname" : 
                alert("닉네임이 유효하지 않습니다"); break;
            
            case "authKey" : 
                alert("이메일 인증이 유효하지 않습니다"); break;
           
            }

            e.preventDefault(); // form 태그 기본 이벤트 제거
            return; // 함수 종료
        } else {

        }


    }
});