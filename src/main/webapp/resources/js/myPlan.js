/*

const search-btn = document.querySelector(".search-btn"); 
const searchDes = document.querySelectorAll(".destinations"); 


search-btn.addEventListener('click', () => {

const inputLoca = document.querySelector(".search");

fetch("/myPlan/myPlans/searchLoca?inputLoca" + inputLoca, {
	.then(resp => resp.json()) // 응답 객체를 자바스크립트 객체 형태로 파싱
	.then(content => {
	
		console.log(list); // javascript 객체
	
	})
	.catch( err => console.log(err) );


});
*/

/*
function searchLoca() {

	var searchInput = document.querySelector('.search').value;
	
	 fetch('/myPlan/myPlans/searchLoca?searchInput=' + searchInput)
        .then(response => response.json())
        .then(data => {
            // JSON 데이터에서 검색어와 일치하는 결과 필터링
            var searchDestinations = data.filter(item => item.title.includes(searchInput));

            // 검색 결과를 화면에 표시
            displayResults(searchDestinations);
        })
        .catch(error => {
            console.error('데이터 가져오기 중 오류 발생:', error);
        });

}

function displayResults(results) {
    var searchDestinationsElement = document.getElementById('searchResults');
    searchResultsElement.innerHTML = '';

    if (results.length === 0) {
        searchResultsElement.textContent = '일치하는 결과가 없습니다.';
        return;
    }

    results.forEach(result => {
        var resultElement = document.createElement('div');
        resultElement.textContent = result.title;
        searchResultsElement.appendChild(resultElement);
    });
}
*/

// 여행지 저장 유효성 검사
const saveBtn = document.querySelector('#saveForm');


saveBtn.addEventListener('submit', e => {
	
	var pn = document.querySelector('#myPlanName').value;
	var dd = document.querySelector('#departDate').value;
	var ad = document.querySelector('#arrivalDate').value;
	var dp = document.querySelector('#departPlace').value;
	

	 if(pn == "") {
		alert("일정명을 입력해주세요") ;
		e.preventDefault();
		return;
	 }
	 
	  if(dd == "") {
		alert("날짜를 입력해주세요") ;
		e.preventDefault();
		return;
		
	 } 
	 
	 if(ad == "") {
		alert("날짜를 입력해주세요") ;
		e.preventDefault();
		return;
	} 
	
	if(dp == "") {
		alert("출발지를 입력해주세요") ;
		e.preventDefault();
		return;
	}

	
});

// 출발지
var msBtn = document.querySelector('#mapSearchBtn');
var dPlace = document.querySelector('#departPlace');
var searchedPlace = document.querySelector('#searchedPlace');

msBtn.addEventListener('click', e => {

	var dpv = document.querySelector('#departPlace').value;
	
	if(dpv == ""){
		alert("출발지를 입력해주세요") ;
		e.preventDefault();
		return;
		
	} else {
		searchedPlace.textContent = dpv;
	}

});


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



/* 오른쪽(서울, 경기, 인천 등등) div 펼치기 */
const expend = document.querySelectorAll(".expend");
const destinations = document.querySelectorAll(".destinations");
for (let i = 0; i < expend.length; i++) {
    expend[i].addEventListener('click', () => {

        if (destinations[i].style.display == 'none') {
            destinations[i].style.display = 'block';
            expend[i].innerHTML = '-';
        } else {
            destinations[i].style.display = 'none';
			expend[i].innerHTML = '+';
        }
    }

    )
}


/* 헷갈리는 부분 */

/*
const cansle = document.querySelectorAll(".cansle-button");
const divDes = document.querySelectorAll('.destinations');
const rightList = document.getElementById('rightList');
const selPlace = document.querySelectorAll('.selectedPlace');
/*
cansle.forEach((button) => {
    button.addEventListener('click', () => {
        rightList.classList.toggle('selectedPlace');
    });
});
*/

/*
for (let i = 0; i < cansle.length; i++) {
    cansle[i].addEventListener('click', () => {
        const selectedDestination = divDes.querySelectorAll(".selectedPlace");
        const selectedRightList = rightList.querySelector(".selectedPlace");

        if (selectedDestination) {
            divDes.removeChild(selectedDestination);
            rightList.appendChild(selectedDestination);
        }

        if (selectedRightList) {
            rightList.removeChild(selectedRightList);
            divDes.appendChild(selectedRightList);
        }
    });
}
*/

const cansle = document.querySelectorAll('.cansle-button');
const divDes = document.querySelectorAll('.destinations');
const rightList = document.getElementById('rightList');

cansle.forEach((button, i) => {
    button.addEventListener('click', () => {
        const selectedDestination = divDes[i].querySelector(".selectedPlace");
        const selectedRightList = rightList.querySelector(".selectedPlace");

        if (selectedDestination) {
            divDes[i].removeChild(selectedDestination);
            rightList.appendChild(selectedDestination);
            button.innerHTML = '-';
        } else if (selectedRightList) {
            rightList.removeChild(selectedRightList);
            divDes[i].appendChild(selectedRightList);
            button.innerHTML = '+';
        }
    });
});


/*
const cansle = document.querySelectorAll('.cansle-button');
const divDes = document.querySelectorAll('.destinations');
const rightList = document.getElementById('rightList');

cansle.forEach((button, i) => {
    button.addEventListener('click', () => {
        // divDes[i]에서 selectedPlace를 선택
        const selectedDestination = divDes[i].querySelectorAll(".selectedPlace");
        // rightList에서 selectedPlace를 선택
        const selectedRightList = rightList.querySelectorAll(".selectedPlace");

        // divDes[i]에 있는 selectedPlace를 rightList로 이동
        selectedDestination.forEach((element) => {
            rightList.appendChild(element);
        });

        // rightList에 있는 selectedPlace를 divDes[i]로 이동
        selectedRightList.forEach((element) => {
            divDes[i].appendChild(element);
        });

        // 버튼 내용 변경
        if (button.innerHTML == '-') {
            button.innerHTML = '+';
        } else {
            button.innerHTML = '-';
        }
    });
});

*/


// 이용방법 모달
const infoBtn = document.querySelector('.이용방법');
const modal = document.querySelector('.modal');
const closeBtnPopup = document.getElementById('closeBtnPopup');

infoBtn.addEventListener('click', () => {

      modal.classList.toggle('show');
  
    });


modal.addEventListener('click', (event) => {
  if (event.target === modal) {
    modal.classList.toggle('show');

    if (!modal.classList.contains('show')) {
      body.style.overflow = 'auto';
    }
  }
});

closeBtnPopup.addEventListener('click', () => {
  modal.classList.remove('show');
});



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




