const placeSec = document.getElementsByClassName('placeSec');
const placeImg = document.getElementsByClassName("placeImg");

const updatePopup = document.getElementById('updatePopup');
const closeBtnUpdatePopup = document.getElementById('closeBtnUpdatePopup');

const contentNo = document.getElementsByClassName("contentNo");
const updateAgeCode = document.getElementById('updateAgeCode');
const updateMemberCode = document.getElementById('updateMemberCode');
const updateSeasonCode = document.getElementById('updateSeasonCode');
const themeCode = document.getElementById('updateThemeCode');
const updateInputPlace = document.getElementById('updateInputPlace');
const updateAreaCode = document.getElementById('updateAreaCode');
const updateLatitude = document.getElementById('updateLatitude');
const updateLongitude = document.getElementById('updateLongitude');
const updateUploadPlaceImg = document.getElementById('updateUploadPlaceImg');
const updatePlaceInfoUrl = document.getElementById('updatePlaceInfoUrl');
const updateInputInfo = document.getElementById('updateInputInfo');
const updateInputAddress = document.getElementById('updateInputAddress');
const contentNum = document.getElementById('contentNum');

const replyPlace = document.getElementById("review-controll-section-p");

closeBtnUpdatePopup.addEventListener('click', () => {
    updatePopup.classList.add('hidden');
});


// 팝업창 관련
let temp1 = 0;
let temp2 = 0;


for (var i = 0; i < placeSec.length; i++) {

    const tempNum = contentNo[i].value;

    console.log(tempNum)

    placeImg[i].addEventListener('click', () => {

        temp2 = tempNum;

        updatePopup.classList.remove('hidden');

        fetch("/content/searchContent?contentNo=" + tempNum)
            .then(resp => resp.json())
            .then(data => {

                console.log(data)

                contentNum.value = tempNum;
                updateAgeCode.value = data.AGE_CODE;
                updateMemberCode.value = data.MEMBER_CODE;
                updateSeasonCode.value = data.SEASON_CODE;
                themeCode.value = data.THEME_CODE;
                updateInputPlace.value = data.TRAVEL_NAME;
                updateAreaCode.value = data.AREA_CODE;
                updateLatitude.value = data.LATITUDE;
                updateLongitude.value = data.LONGITUDE;
                updateUploadPlaceImg.setAttribute("src", data.CONTENT_IMG);
                updatePlaceInfoUrl.value = data.PLACE_URL;
                updateInputInfo.value = data.PLACE_INFO;
                updateInputAddress.value = data.PLACE_ADDRESS;
                
                const replyList = data.replyList;
                replyPlace.innerHTML = "";

                for (var i = 0; i < replyList.length ; i++) {

                    replyPlace.innerHTML += replyList[i]+'<br>'
                    
                }

                // 기존 이미지 기억하고 jsp에 hidden으로 대입
                const imgHidden = document.createElement("input");
                imgHidden.setAttribute("type", "hidden");
                imgHidden.setAttribute("value", data.CONTENT_IMG);
                imgHidden.setAttribute("name", "originImg");

                updateUploadPlaceImg.append(imgHidden);

                console.log(imgHidden);



                
            

            })

        // --------------------------------------------------------------
        // 컨텐츠 이미지 관련

        // 컨텐츠 이미지 추가/변경/삭제
        const imageInputUpdate = document.getElementById("imageInputUpdate"); // input 태그

        let checkInit;
        // 초기 컨텐츠 이미지 상태를 저장하는 변수
        // false == 기본 이미지,  true == 이전 업로드 이미지

        let checkDelete = -1;
        // 컨텐츠 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수
        // -1 == 초기값,  1 == 새 이미지 업로드


        let imageOriginal; // 초기 컨텐츠 이미지 파일 경로 저장



        if (imageInputUpdate != null) { // 화면에 imageInput이 있을 경우 ( if 굳이 안해도 되긴 함 ) 

            // 프로필 이미지가 출력되는 img태그의 src 속성을 저장
            imageOriginal = updateUploadPlaceImg.getAttribute("src");


            // 회원 프로필 화면 진입 시 
            // 현재 회원의 프로필 이미지 상태를 확인
            if (updateUploadPlaceImg.getAttribute("src") == "/resources/img/common/main/프로필아이콘.png") {
                // 기본 이미지인 경우
                checkInit = false;
            } else {
                checkInit = true;
            }


            // change 이벤트 : 값이 변했을 때
            // - input type="file", "checkbox", "radio" 에서 많이 사용
            // - text/number 형식 사용 가능
            //   -> 이 때 input값 입력 후 포커스를 잃었을 때 
            //      이전 값과 다르면 change 이벤트 발생

            imageInputUpdate.addEventListener("change", e => {

                // 2MB로 최대 크기 제한 
                const maxSize = 1 * 1024 * 1024 * 2; // 파일 최대 크기 지정(바이트 단위)

                console.log(e.target); // input
                console.log(e.target.value); // 업로드된 파일 경로
                console.log(e.target.files); // 업로드된 파일의 정보가 담긴 배열

                const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체


                // 파일을 한번 선택한 후 취소했을 때 ( file이 undefined가 된다 ) 
                if (file == undefined) {
                    console.log("파일 선택이 취소됨");
                    checkDelete = -1; // 취소 == 파일 없음 == 초기상태

                    // 취소 시 기존 프로필 이미지로 변경 ( 기존 이미지에서 변경되는게 없게 하겠다는거죠 ) 
                    updateUploadPlaceImg.setAttribute("src", imageOriginal);

                    return;
                }

                if (file.size > maxSize) { // 선택된 파일의 크기가 최대 크기를 초과한 경우
                    alert("2MB 이하의 이미지를 선택해주세요.");
                    imageInputUpdate.value = "";
                    // input type="file" 태그에 대입할 수 있는 value는 "" (빈칸) 뿐이다!
                    checkDelete = -1; // 취소 == 파일 없음 == 초기상태

                    // 기존 프로필 이미지로 변경
                    updateUploadPlaceImg.setAttribute("src", imageOriginal);

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

                    // 프로필이미지(img) 태그에 src 속성으로 추가
                    updateUploadPlaceImg.setAttribute("src", url);

                    checkDelete = 1;
                }
            });


            // #profileFrm이 제출 되었을 때
            document.getElementById("updatePopup").addEventListener("submit", e => {

                return true;
            });
        }

    });

}




