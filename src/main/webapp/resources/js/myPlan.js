

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

            if (selectedRightList) {
                rightList.removeChild(selectedRightList);
                divDes.appendChild(selectedRightList);
            }
        }

    });
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
        }


        

    }); 


    

    
};