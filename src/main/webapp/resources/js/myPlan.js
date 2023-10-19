window.onload = function(){
var container = document.getElementById('map');
var options = {
    center: new kakao.maps.LatLng(36.450701, 127.570667),
    level: 10
};

var map = new kakao.maps.Map(container, options);

};