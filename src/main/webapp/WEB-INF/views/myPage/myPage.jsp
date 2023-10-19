<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <div class="modal">
            <div class="modal_body">
                <div class="modalBodyTitle">공유하기</div>
                <div class="modalBodyIcon">
                    <div class="icon"><a href="#"><img src="/resources/img/myPage/카카오톡 아이콘.png">카카오톡</a></div>
                    <div class="icon"><a href="#"><img src="/resources/img/myPage/페이스북 아이콘.png">페이스북</a></div>
                    <div class="icon"><a href="#"><img src="/resources/img/myPage/인스타그램 아이콘.png">인스타그램</a></div>
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
                            <div class="profile-1">
                                <a href="managingProfile"><img class="profile-image" src="/resources/img/myPage/프로필 사진.png">
                                <div class="profile-button">
                                    <a href="managingProfile">프로필 관리</a>
                                </div>
                                </a>
                            </div>

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
                            <div class="mtm-title"><a href="#">동궁과 월지 문의</a></div> <!-- hidden 넣은 관리자 1대1 문의에 연결  -->
                            <div class="mtm-status">답변완료</div>
                        </div>
                    </div>
                </section>
                <section class="top-2">
                    <div class="like-list">
                        <div class="like-list-title">좋아요 목록</div>
                        <div class="like-list-main">
                            <div>
                                <button class="arrow-button"><img class="left-arrow" src="/resources/img/myPage/left-arrow.png"></button>
                            </div>
                            <div class="like-list-combo">
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
                            </div>
                           <div>
                            <button class="arrow-button"><img class="right-arrow" src="/resources/img/myPage/right-arrow.png"></button>
                           </div>
                        </div>
                    </div>
                    <div class="my-comment">
                        <div class="comment-title">작성한 후기</div>
                        <div class="comment-main">
                            <div class="comment">
                                <div class="comment-loca">해운대 블루라인파크</div>
                                <div class="comment-content">
                                    <div class="content">좋아요~!</div>
                                    <button class="comment-delete">x</button>
                                </div>
                            </div>
                            <div class="comment">
                                <div class="comment-loca">인천 차이나타운</div>
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
                    <a href="/myPlan/myPlans"><img class="my-plan-img" src="/resources/img/myPage/추천 콘텐츠 18.jpg"></a>
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
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="/resources/js/myPage.js"></script>
</body>
</html>