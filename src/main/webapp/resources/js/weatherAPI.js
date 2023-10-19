let num = 0;
let region = 'seoul';
let korRegion = '';
const weather = document.getElementById("weather");
const weatherIcon = document.querySelector('.weatherIcon');

function getWeather(){
    
    weather.innerHTML = '';
    switch (num) {
        case 0: korRegion = '서울'; break;
        case 1: korRegion = '부산'; break;
        case 2: korRegion = '대전'; break;
        case 3: korRegion = '제주'; break;
        case 4: korRegion = '광주'; break;
        case 5: korRegion = '원주'; break;
        case 6: korRegion = '인천'; break;
    }; 

    weather.innerHTML += `${korRegion}`

    fetch(`https://api.openweathermap.org/data/2.5/weather?q=${region},kr&appid=0bc93ab707044ce12e60a520cf7d807e`)
    .then(response => response.json())
    .then(data => {
        
        weather.innerHTML += `<br>${Math.round(Number(data.main.temp) - 273.15)}°C`;
        const icon = data.weather[0].icon;
        const iconURL = `http://openweathermap.org/img/wn/${icon}@2x.png`;

        console.log(icon);
        console.log(iconURL);

        weatherIcon.setAttribute('src', iconURL);
    });

    num++;
    
    switch (num) {
        case 1: region = 'busan'; break;
        case 2: region = 'daejeon'; break;
        case 3: region = 'jeju'; break;
        case 4: region = 'gwangju'; break;
        case 5: region = 'wonju'; break;
        case 6: region = 'incheon'; break;
        case 7: region = 'seoul'; num = 0; break;
    };

};

setInterval(getWeather, 3000);