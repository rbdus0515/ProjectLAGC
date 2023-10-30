<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>마이페이지</title>

            <link rel="stylesheet" href="/resources/css/myPage/myPage.css">

        </head>

        <body>


            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <main>
                <c:if test="${loginMember.memberManagerFlag == 'N'}">

                    <div class="modal">
                        <div class="modal_body">
                        	<div class="modal_upside">
	                        	<button type="button" id="closeBtnPopup">
									<img src="/resources/img/common/main/X버튼.png" alt="">
								</button>
                        	</div>

                            <div class="modalBodyTitle">공유하기</div>
                            <div class="modalBodyIcon">
                                <div class="icon"><a href="#"><img src="/resources/img/myPage/카카오톡 아이콘.png">카카오톡</a>
                                </div>
                                <div class="icon"><a href="#"><img src="/resources/img/myPage/페이스북 아이콘.png">페이스북</a>
                                </div>
                                <div class="icon"><a href="#"><img src="/resources/img/myPage/인스타그램 아이콘.png">인스타그램</a>
                                </div>
                                <div class="icon"><a href="#"><img src="/resources/img/myPage/트위터.png">트위터</a></div>
                            </div>
                        </div>

                    </div>
                    </div>
                    <section>
                        <section class="top">
                            <section class="top-1">
                                <div class="profile">
                                    <div class="profile-box">
                                        
                                            <a href="managingProfile">
                                        <div class="profile-1">
                                            
                                            	<c:if test="${empty loginMember.memberProfileImage}">
 	                      							<img src="/resources/img/member/signUp/프로필아이콘.png" class = profile-image>
						                    	</c:if>
						                    	
						                    	<c:if test="${not empty loginMember.memberProfileImage}">
						 	                       <img src="${loginMember.memberProfileImage}" class = profile-image>
						                    	</c:if>
						                    	
                                                <div class="profile-button">
                                                    <a href="managingProfile">프로필 관리</a>
                                                </div>
                                        </div>
                                                
                                            </a>
                                            
                                            

                                        <div class="profile-2">
                                            <div class="profile-2-1">
                                                <div class="profile-2-1-name">
                                                    <div class="profile-n">이름</div>
                                                    <div class="profile-name">${loginMember.memberName}</div>
                                                </div>

                                                <div class="profile-2-1-nick">
                                                    <div class="profile-n2">닉네임</div>
                                                    <div class="profile-nickname">${loginMember.memberNickname}</div>
                                                </div>
                                            </div>

                                            <div class="profile-2-2">
                                                <div class="profile-2-2-email">
                                                    <div class="profile-e">이메일</div>
                                                    <div class="profile-email">${loginMember.memberEmail}</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="inquiry">
                                    <div class="man-to-man-bar">1:1 문의</div>
                                    <div class="man-to-man">
                                        <div class="mtm-date">23.09.19</div>
                                        <div class="mtm-title"><a href="#">${qna.QNATitle}</a></div>
                                        <!-- hidden 넣은 관리자 1대1 문의에 연결  -->
                                        <div class="mtm-status">답변완료</div>
                                    </div>
                                </div>
                            </section>
                            <section class="top-2">
                                <div class="like-list">
                                    <div class="like-list-title">좋아요 목록</div>
                                    <div class="like-list-main">
                            <div>
                                <button class="left-arrow"><img class="arrow-button" src="/resources/img/myPage/left-arrow.png"></button>
                            </div>
                            <div class="like-list-combo">
                                <div class="slideBox">

                                    
                                    	<!-- 좋아요를 누른 곳이 없을 경우 -->
                                    	<c:if test="${empty likeCheck}">
                                    		<p>좋아요를 누른 여행지가 없습니다</p>
                                    	</c:if>
                                    	
                                    	<!-- 좋아요를 누른 곳이 있을 경우 -->
                                    	<c:if test="${not empty likeCheck}">
                                    		<foreach
                                    	</c:if>
                                    <div class="like-list-1">
                                        <a href="#"><img class="like-list-photo" src="/resources/img/myPage/Rectangle 115.png"></a>
                                        <div class="like-list-name"><a href="#">감천문화마을</a></div>
                                    </div>

                                    <div class="like-list-1">
                                        <a href="#"><img class="like-list-photo" src="/resources/img/myPage/Rectangle 116.png"></a>
                                        <div class="like-list-name"><a href="#">호미곶 해맞이광장</a></div>
                                    </div>

                                    <div class="like-list-1"> 
                                        <a href="#"><img class="like-list-photo" src="/resources/img/myPage/Rectangle 117.png"></a>
                                        <div class="like-list-name"><a href="#">동궁과 월지</a></div>
                                    </div>

                                    <div class="like-list-1"> 
                                        <a href="#"><img class="like-list-photo" src="/resources/img/myPage/Rectangle 117.png"></a>
                                        <div class="like-list-name"><a href="#">동궁과 월</a></div>
                                    </div>

                                </div>
                            </div>
                           <div>
                            <button class="right-arrow"><img class="arrow-button" src="/resources/img/myPage/right-arrow.png"></button>
                           </div>
                        </div>
                                </div>
                                <div class="my-comment">
                                    <div class="comment-title">작성한 후기</div>
                                    <div class="comment-main">
                                        <div class="comment">
                                            <div class="comment-loca"><a href="#">해운대 블루라인파크</a></div>
                                            <div class="comment-content">
                                                <div class="content">좋아요~!</div>
                                                <button class="comment-delete">x</button>
                                            </div>
                                        </div>
                                        <div class="comment">
                                            <div class="comment-loca"><a href="#">인천 차이나타운</a></div>
                                            <div class="comment-content">
                                                <div class="content">중식 가게가 많아요 ㅎㅎ</div>
                                                <button class="comment-delete">x</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </section>
                        </section>
                    </section>
                    <section class="under">
                        <div class="my-plan">
                            <div class="my-plan-title">나의 일정</div>
                            <div class="my-plan-1">
                                <a href="/myPlan/myPlans"><img class="my-plan-img"
                                        src="/resources/img/myPage/추천 콘텐츠 18.jpg"></a>
                                <div class="plan-main">
                                    <div class="plan-title"><a href="/myPlan/myPlans">수도권 여행</a></div>
                                    <div class="plan-D-day">D-8</div>
                                    <div class="plan-area">
                                        <div class="plan-area-title">서울</div>
                                        <div class="plan-area-main">남산타워</div>
                                    </div>
                                    <div class="plan-area">
                                        <div class="plan-area-title">경기</div>
                                        <div class="plan-area-main">에버랜드</div>
                                    </div>
                                    <div class="plan-date">2023-09-22 ~ 2023-09-23</div>
                                </div>
                                <div class="share-delete">
                                    <button class="share-button">공유</button>
                                    <button class="delete-button">삭제</button>
                                </div>
                            </div>
                            <div class="my-plan-1">
                                <a href="#"><img class="my-plan-img" src="/resources/img/myPage/오설록 티뮤지엄 5.png"></a>
                                <div class="plan-main">
                                    <div class="plan-title"><a href="#">홍길동님의 여행지</a></div>
                                    <div class="plan-D-day">D-14</div>
                                    <div class="plan-area">
                                        <div class="plan-area-title">제주</div>
                                        <div class="plan-area-main">오설록 티뮤지엄</div>
                                    </div>
                                    <div class="plan-area">
                                        <div class="plan-area-title">제주</div>
                                        <div class="plan-area-main">협재해수욕장</div>
                                    </div>
                                    <div class="plan-area">
                                        <div class="plan-area-title">제주</div>
                                        <div class="plan-area-main">만장굴</div>
                                    </div>
                                    <div class="plan-date">2023-09-28 ~ 2023-09-29</div>
                                </div>
                                <div class="share-delete">
                                    <button class="share-button">공유</button>
                                    <button class="delete-button">삭제</button>
                                </div>

                            </div>
                            <div class="my-plan-1">
                                <button class="plan-add"><a href="/myPlan/myPlans">+ 일정 추가하기</a></button>
                            </div>

                        </div>
                    </section>

                </c:if>




             <!----- 매니저 마이페이지 --------------------------------------------------------------------------------------->


                <c:if test="${loginMember.memberManagerFlag == 'Y'}">

                    <section id="managerSection">

                        <!----- left 공백---------------------------------------------------------------------------------------->
                        <div id="l_blank"></div>



                        <!----- 메인 화면 ---------------------------------------------------------------------------------------->
                        <main id="mainManager">

                            <!---- top 공백 ----------------------------------------------------------------------------------------->
                            <div id="b_blank"></div>



                            <!----- 프로필 ------------------------------------------------------------------------------------------->

                            <section class="profileManager">

                                <div class="profileImgManager">
                                    <div class="imgWrapperManager">
                                    
                                  		<c:if test="${empty loginMember.memberProfileImage}">
                     						<img src="/resources/img/member/signUp/프로필아이콘.png">
			                    		</c:if>
			                    	
				                    	<c:if test="${not empty loginMember.memberProfileImage}">
				 	                        <img src="${loginMember.memberProfileImage}">
				                    	</c:if>
				                    	
                                    </div>

                                    <a href="/myPage/managingProfile" class="managingProfileBtn">프로필 관리</a>

                                </div>

                                <div class="managerProfile">
                                    <div>
                                        <p>이름</p>
                                        <p class="managerInfo">${loginMember.memberName}</p>
                                    </div>

                                    <div>
                                        <p>닉네임</p>
                                        <p class="managerInfo">${loginMember.memberNickname}</p>
                                    </div>

                                    <div>
                                        <p>이메일</p>
                                        <p class="managerInfo">${loginMember.memberEmail}</p>
                                    </div>



                                </div>

                            </section>

                            <!----- 관리 메뉴 ----------------------------------------------------------------------------------------->

                            <section class="managingContent">
                                <a href="/manager/managingQNA">1:1문의 목록
                                    <c:if test="${QNACount != 0}">
                                        <span id="newAlarm">
                                            ${QNACount}
                                        </span>
                                    </c:if>


                                </a>
                                <a href="/notice/noticeList">공지사항</a>
                                <a href="#">게시물 업로드</a>
                                <a href="/community/communityPage">커뮤니티</a>

                            </section>


                            <!---- bottom 공백 ----------------------------------------------------------------------------------------->
                            <div id="b_blank"></div>

                        </main>


                        <!---- right 공백 ------------------------------------------------------------------------------------------->
                        <div id="r_blank"></div>

                    </section>

                </c:if>


            </main>



            <jsp:include page="/WEB-INF/views/common/footer.jsp" />
            <script src="/resources/js/myPage.js"></script>
        </body>

        </html>