<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 일정</title>
    <link rel="stylesheet" href="/resources/css/myPlan/myPlan.css">
    <script src="/resources/js/myPlan.js"></script>
</head>
<body>
    <form action="#" name="myPlan" method="get"></form>
    <main class="my-plan">

        <section class="map-api">
            <div class="left-side">
                <section class="search-conteiner">
                    <div class="logo-box">
                        <a href="/"><img class="logo" src="/resources/img/myPage/LAGC-logo.png"></a>
                    </div>
                    <div class="search-box">
                        <input class="search" type="text" placeholder="여행지 검색">
                    </div>
                </section>
                <section class="loca-plan">
                <section class="location">
                    

                    <div class="출발지설정">
                        서울
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        경기/인천
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        강원
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        충청
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        전라
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        경상
                        <button class="펼치기">+</button>
                    </div>

                    <div class="출발지설정">
                        제주
                        <button class="펼치기">+</button>
                    </div>

                    <button class="저장">저장</button>
                    
                </section>
                <section class="plan">
                    <div class="출발지설정1">
                        <div>출발지 설정</div>
                        <button class="펼치기">-</button>
                    </div>

                    <div class="수도권여행">수도권 여행</div>

                    <input class="출발지검색" >

                    <div class="출발지설정1">
                        선택한 여행지
                        <button class="펼치기">-</button>
                    </div>

                    <div class="수도권여행">출발지 : 서울역</div>

                    <div class="선택한여행지">
                        <button class="cansle-button" type="button">-</button>
                        <a href="#"><img class="선택한-여행지-이미지" src="/resources/img/myPage/추천 콘텐츠 18.jpg"></a>
                        <div class="메뉴">
                            <div class="시간">소요시간 : 19분</div>
                            <div class="누적시간">누적 소요시간 : 19분</div>
                            <div class="여행지이름">남산 타워</div>
                            <div class="여행지위치">서울특별시 용산구 남산공원길 105</div>
                        </div>
                    </div>

                    <div class="선택한여행지">
                        <button class="cansle-button" type="button">-</button>
                        <a href="#"><img class="선택한-여행지-이미지" src="/resources/img/myPage/추천 콘텐츠 6.png"></a>
                        <div class="메뉴">
                            <div class="시간">소요시간 : 1시간 22분</div>
                            <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                            <div class="여행지이름">에버랜드</div>
                            <div class="여행지위치">경기도 용인시 에버랜드로 199</div>
                        </div>
                    </div>
                </section>
            </section>
            </div>
            <div id="map" style="width:100%;height:100vh;">
            	<div class="storage">
                    <button><img class="left-arrow" src="/resources/img/myPage/left-arrow.png"></button>
                </div>
                
                <div class="이용방법"><a href="#">이용방법</a></div>

                <div class="log-in"><a href="/myPage/myPages"><img class="map-profile" src="/resources/img/myPage/프로필 사진.png"></a></div>

            </div>
            <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=246a0fc52dbb0ac008083682df20832d"></script>

        </section>
    </main>
</body>
</html>