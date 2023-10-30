/* 카카오맵 API */
window.onload = function(){
var container = document.getElementById('map');
var options = {
    center: new kakao.maps.LatLng(36.450701, 127.570667),
    level: 10
};

var map = new kakao.maps.Map(container, options);

};

/* 선택한 여행지 div 숨기기 */
const hidden = document.querySelector('.storage');
const plan = document.querySelector('.right-side');
const arrow = document.getElementById('arrow');

hidden.addEventListener('click', () => {


    if(plan.style.display == 'none')  {
        plan.style.display = 'block';
        arrow.src = "/resources/img/myPage/left-arrow.png";
      }else {
        plan.style.display = 'none';
        arrow.src = "/resources/img/myPage/right-arrow.png";
      }
});

/* 오른쪽 div 펼치기 */
const expend = document.querySelectorAll(".expend");
const destinations = document.querySelectorAll(".destinations");
var newContent = "-";
for (let i = 0; i < expend.length; i++) {
    expend[i].addEventListener('click', () => {
    
            if(destinations[i].style.display == 'none') {
                destinations[i].style.display = 'block';
                expend.innerHTML = newContent;
            }else {
                destinations[i].style.display = 'none';
                
            }
        }

    )
}


/* 헷갈리는 부분 */
const cansle = document.querySelectorAll(".cansle-button");
const divDes = document.querySelector('.destinations');
const rightList = document.getElementById('rightList');

for (let i = 0; i < cansle.length; i++) {
    cansle[i].addEventListener('click', () => {
        const selectedDestination = divDes.querySelector(".선택한여행지");
        const selectedRightList = rightList.querySelector(".선택한여행지");

 
        if (selectedDestination) {
            divDes.removeChild(selectedDestination);
            rightList.appendChild(selectedDestination);
        } else {
        
        if(selectedRightList){
        	rightList.removeChild(selectedRightList);
            divDes.appendChild(selectedRightList);
            }
        }
        
    });
}


// 지도 검색
const apiKey = '246a0fc52dbb0ac008083682df20832d'; // 발급받은 API 키를 사용하세요.
const targetInput = document.querySelector(".출발지검색");
const searchResult = document.querySelector(".수도권여행");

// API 호출 URL 생성
const apiUrl = `https://dapi.kakao.com/v2/local/search/address.json?query=${query}`;


targetInput.addEventListener("input", e => {

	const query = e.target.value.trim();
	
	if(query.length == 0){
		resultArea.innerHTML = ""; // 이전 검색 결과 비우기
		return;
	}
	
	if(query.length > 0) {
		// API 호출
		fetch("/myPlans?query=${query}", {
		    method: 'GET',
		    headers: {
		        'Authorization': `KakaoAK ${apiKey}`
		    }
		})
		.then(response => response.text())
		.then(data => {
		    // API 응답 데이터 처리
		    console.log(data);
		})
		.catch(error => {
		    // 오류 처리
		    console.error('API 호출 중 오류 발생:', error);
		});
	
	}
	
	
	}








