/* 선택한 여행지 div 숨기기 */
const hidden = document.querySelector('.storage');
const plan = document.querySelector('.right-side');
const arrow = document.getElementById('arrow');

hidden.addEventListener('click', () => {


    if (plan.style.display == 'none') {
        plan.style.display = 'block';
        arrow.src = "/resources/img/myPage/left-arrow.png";
    } else {
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

        if (destinations[i].style.display == 'none') {
            destinations[i].style.display = 'block';
            expend.innerHTML = newContent;
        } else {
            destinations[i].style.display = 'none';

        }
    }

    )
}


/* 헷갈리는 부분 */
// 선택한 여행지 이동 함수
function moveSelectedLocation(cansle, destinations, rightList) {
    cansle.addEventListener('click', () => {
        const selectedDestination = destinations.querySelector(".선택한여행지");
        const selectedRightList = rightList.querySelector(".선택한여행지");

        if (selectedDestination) {
            destinations.removeChild(selectedDestination);
            rightList.appendChild(selectedDestination);
        } else if (selectedRightList) {
            rightList.removeChild(selectedRightList);
            destinations.appendChild(selectedRightList);
        }
    });
}

// 모든 cansle 버튼에 대해 처리
const cansleButtons = document.querySelectorAll(".cansle-button");
const destinationsList = document.querySelectorAll('.destinations');
const rightList = document.querySelector('#rightList'); // 단일 rightList로 가정

for (let i = 0; i < cansleButtons.length; i++) {
    moveSelectedLocation(cansleButtons[i], destinationsList[i], rightList);
}
}

/* 카카오맵 API */
window.onload = function () {
    var mapContainer = document.getElementById('map');
    var mapOption = {
        center: new kakao.maps.LatLng(37.5806736, 126.976952),
        level: 10
    };

    var map = new kakao.maps.Map(mapContainer, mapOption);

    let markerPosition = [];

    fetch("/myPlan/selectPlace")
    .then(resp => resp.json())
    .then(data => {

        var imageSrc = "/resources/img/content/button/pin(2).png"; 
    
        for (var i = 0; i < data.length; i ++) {
            
            var imageSize = new kakao.maps.Size(40, 40); 
            
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
            
            var marker = new kakao.maps.Marker({
                map: map, 
                position: (new kakao.maps.LatLng(data[i].longitude, data[i].latitude)),
                title : data[i].travelName,
                image : markerImage
            });

            var infowindow = new kakao.maps.InfoWindow({
                content: data[i].travelName// 인포윈도우에 표시할 내용
            });
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));

        }


        function makeOverListener(map, marker, infowindow) {
            return function() {
                infowindow.open(map, marker);
            };
        }
        
        // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
        function makeOutListener(infowindow) {
            return function() {
                infowindow.close();
            };
        }
    })
}


// // 지도 검색
// const apiKey = '246a0fc52dbb0ac008083682df20832d'; // 발급받은 API 키를 사용하세요.
// const targetInput = document.querySelector(".출발지검색");
// const searchResult = document.querySelector(".수도권여행");


// // API 호출 URL 생성
// const apiUrl = `https://dapi.kakao.com/v2/local/search/address.json?query=${query}`;


// targetInput.addEventListener("input", e => {

// 	const query = e.target.value.trim();
	
// 	if(query.length == 0){
// 		resultArea.innerHTML = ""; // 이전 검색 결과 비우기
// 		return;
// 	}
	

	
// 	}
	

// 	}
     

//     }); 
    
// };

