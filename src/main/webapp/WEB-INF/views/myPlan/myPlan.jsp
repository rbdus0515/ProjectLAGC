
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
    
   

</head>
<body>

	<div class="modal">
		<div class="modal_body">
			<div class="modal_upside">
				<button type="button" id="closeBtnPopup">
					<img src="/resources/img/common/main/X버튼.png" alt="">
				</button>
			</div>
			<div class= "modal_bottomside">
				<img src="/resources/img/common/main/4) 나의 일정 이용방법3.png" alt="">
			</div>
 				
		</div>

	</div>




    <form action="myPlan/myPlans" name="myPlan" method="get"></form>
    <main class="my-plan">

            <section class="left-side">
                <section class="search-conteiner">
                    <div class="logo-box">
                        <a href="/"><img class="logo" src="/resources/img/myPage/LAGC-logo.png"></a>
                    </div>
                    <div class="search-box">
                        <input class="search" name="inputLoca" type="text" autocapitalize="off" placeholder="여행지 검색">
                        <button class="search-btn" onclick="searchLoca()">
                        	<img id="search-img" src="/resources/img/common/main/Vector.png">
                        </button>
                    </div>
                </section>
                  
                        <section class="location">

                            <div class="locaContents">
                                <div class="출발지설정">
                                    서울
                                    <button class="expend" type="button">+</button>
                                </div>

                                <div class="destinations">

                                    <c:forEach var="seo" items="${seoList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${seo.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${seo.travelName}</div>
                                                <div class="여행지위치">${seo.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>

                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    경기/인천
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="gyeinc" items="${gyeincList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${gyeinc.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${gyeinc.travelName}</div>
                                                <div class="여행지위치">${gyeinc.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>
                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    강원
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="gan" items="${ganList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${gan.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${gan.travelName}</div>
                                                <div class="여행지위치">${gan.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    충청
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="chu" items="${chuList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${chu.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${chu.travelName}</div>
                                                <div class="여행지위치">${chu.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    전라
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="jeo" items="${jeoList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${jeo.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${jeo.travelName}</div>
                                                <div class="여행지위치">${jeo.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    경상
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="gye" items="${gyeList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${gye.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${gye.travelName}</div>
                                                <div class="여행지위치">${gye.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>


                                </div>
                            </div>

                            <div class="locaContents">
                                <div class="출발지설정">
                                    제주
                                    <button class="expend" type="button">+</button>
                                </div>
                                <div class="destinations">

                                    <c:forEach var="jej" items="${jejList}">

                                        <div class="selectedPlace">
                                            <button class="cansle-button" type="button">+</button>
                                            <img class="선택한-여행지-이미지" src="${jej.contentImg}">
                                            <div class="메뉴">
                                                <div class="시간">소요시간 : 1시간 22분</div>
                                                <div class="누적시간">누적 소요시간 : 1시간 41분</div>
                                                <div class="여행지이름">${jej.travelName}</div>
                                                <div class="여행지위치">${jej.placeAddress}</div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                </div>
                            </div>




                        </section>


                    </section>
                    

            </section>
            <section class="right-side">
                <section class="empty-box">
                	<a class="save" href="/myPage/myPages"> 돌아가기</a>
                	<form action="/myPage/save" method="post" enctype="multipart/form-data">
                		<button type="submit" id="save" class="save">저장</button>
                	
                	
                </section>
               
                        <section class="plan">
                            <div class="출발지설정1">
                                <div>출발지 설정</div>
                                <button class="expend">-</button>
                            </div>
                            <div class="destinations">
                                <input type="text" name="myPlanName" id="myPlanName" class="수도권여행" placeholder="일정명을 설정해주세요">

                                <div class="dateContainer">

                                    <input class="travelDate" type="date" name="departDate" id="departDate">
                                    <p id="tild"> &nbsp;&nbsp; ~ &nbsp;&nbsp; </p>
                                    <input class="travelDate" type="date" name="arrivalDate" id="arrivalDate">

                                </div>
                                
								<form name=mapSearch autocomplete="off">
									<div class="mapSearchBox">
										<input type="text" class="출발지검색" name="departPlace" id="departPlace" placeholder="출발지 검색">
										<button class=mapSearch-btn onclick="mapSearchList()">
											<img id="search-img" src="/resources/img/common/main/Vector.png">
										</button>
									</div>

								</form>


                            </div>

                            <div class="출발지설정1">
                                선택한 여행지
                                <button class="expend">-</button>
                            </div>

                            <div class="destinations">
                                <div id="rightList" class="locaContents">
                                    <div class="수도권여행"><span>출발지 :</span>${departPlace}</div>
                                    

   

                                </div>
                            </div>


                        </section>
                        </form>
                    </section>

                       <button class="이용방법">이용방법</button>
                       

                   
                    <div id="map" style="width:70%;height:100vh;">
                        <div class="storage">
                            <img id="arrow" class="left-arrow" src="/resources/img/myPage/left-arrow.png">
                        </div>



                        <div class="log-in">
                        	<a href="/myPage/myPages" class="imgWrapperMyPlan">
                        		
                        		<img class="map-profile" src="${loginMember.memberProfileImage}">
                        		
                        	</a>
                       	</div>

                    </div>

                    <!-- 지도 영역 -->

                    <script type="text/javascript"
                        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=246a0fc52dbb0ac008083682df20832d&libraries=services">
                    
                    </script>
 
                    </section>

                </main>
            </form>
            <script src="/resources/js/myPlan.js"></script>
        </body>

        </html>