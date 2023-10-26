const placeSec = document.getElementsByClassName('placeSec');

const modalContainerPopup = document.getElementById('modalContainerPopup');
const closeBtnPopup = document.getElementById('closeBtnPopup');

// 팝업창 관련
let temp1 = 0;
let temp2 = 0;

for(var i = 0; i < placeSec.length; i ++) {
    
    const tempNum = placeSec[i].value;

    placeSec[i].addEventListener('click', () => {

        temp2 = tempNum;

        modalContainerPopup.classList.remove('hidden');

    });


}


closeBtnPopup.addEventListener('click', () => {
  modalContainerPopup.classList.add('hidden');
});

// --------------------------------------------------------------
// 컨텐츠 이미지 관련

// 컨텐츠 이미지 추가/변경/삭제
const uploadPlaceImg = document.getElementById("uploadPlaceImg"); // img 태그
const imageInput = document.getElementById("imageInput"); // input 태그


let initCheck; // 초기 컨텐츠 이미지 상태를 저장하는 변수
                // false == 기본 이미지,  true == 이전 업로드 이미지

let deleteCheck = -1; 
// 컨텐츠 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수
// -1 == 초기값,  1 == 새 이미지 업로드


let originalImage; // 초기 컨텐츠 이미지 파일 경로 저장

if(imageInput != null){ // 화면에 imageInput이 있을 경우 ( if 굳이 안해도 되긴 함 ) 

    // 컨텐츠 이미지가 출력되는 img태그의 src 속성을 저장
    originalImage = uploadPlaceImg.getAttribute("src"); 


    // 회원 컨텐츠 화면 진입 시 
    // 현재 회원의 컨텐츠 이미지 상태를 확인
    if(uploadPlaceImg.getAttribute("src") == "/resources/img/common/main/닫기버튼.png"){
        // 기본 이미지인 경우
        initCheck = false;
    }else{
        initCheck = true;
    }
    



    // change 이벤트 : 값이 변했을 때
    // - input type="file", "checkbox", "radio" 에서 많이 사용
    // - text/number 형식 사용 가능
    //   -> 이 때 input값 입력 후 포커스를 잃었을 때 
    //      이전 값과 다르면 change 이벤트 발생

    imageInput.addEventListener("change", e => {

        // 2MB로 최대 크기 제한 
        const maxSize = 1 * 1024 * 1024 * 2; // 파일 최대 크기 지정(바이트 단위)

        console.log(e.target); // input
        console.log(e.target.value); // 업로드된 파일 경로
        console.log(e.target.files); // 업로드된 파일의 정보가 담긴 배열

        const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체


        if( file.size > maxSize){ // 선택된 파일의 크기가 최대 크기를 초과한 경우
            alert("2MB 이하의 이미지를 선택해주세요.");
            imageInput.value = ""; 
            // input type="file" 태그에 대입할 수 있는 value는 "" (빈칸) 뿐이다!
            deleteCheck = -1; // 취소 == 파일 없음 == 초기상태

            // 기존 컨텐츠 이미지로 변경
            uploadPlaceImg.setAttribute("src", originalImage);

            return;
        }

	
        // JS에서 파일을 읽는 객체
        // - 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있음 
        const reader = new FileReader();

        reader.readAsDataURL(file);
        // 매개변수에 작성된 파일을 읽어서 저장 후
        // 파일을 나타내는 URL을 result 속성으로 얻어올 수 있게 함.

        // 다 읽었을 때
        reader.onload = e => {
            //console.log(e.target);
            console.log(e.target.result); // 읽은 파일의 URL 
            /* 개발자도구에서 Application탭에서 Frames > top > images 안에서 확인가능 */

            const url = e.target.result;

            // 컨텐츠이미지(img) 태그에 src 속성으로 추가
            uploadPlaceImg.setAttribute("src", url);

            deleteCheck = 1;
        }
    });



}
