<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/clientService/clientServicePage.css">
<title>고객지원 페이지</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<section id="clientServicePage">

        <nav>
            <a href="#noticeArea">
                <button>공지사항</button>
            </a>

            <a href="#FAQ-area">
                <button>FAQ</button>
            </a>

            <a href="#ask-area">
                <button>1대1 문의</button>
            </a>
                
        </nav>

        <section id="headImageContainer">
            <section id="clService-headImage-box"></section>
        </section>

        <main>

            <section id="textPack">
                <section>
                    <strong>소개 / 고객지원</strong>
                </section>
                <section id="textPack-bottom">
                    <div>LAGC 소개</div>
                    <div></div>
                </section>
            </section>

            <section id="introduceText">
                <div>
                    <br>
                    저희 LAGC는 한국의 널리 알려진 유명한 관광지나<br>
                    아직 알려지지 않았지만 추천하기 좋은 여행지를 소개하며<br>
                    여행지에 대한 의견과 추억을 공유하기 위해 만든 사이트입니다<br><br>

                    화려한 도시<br>
                    편안한 자연 <br>
                    아름다운 건축물 <br><br>

                    여러분의 대한민국을 소개해 주세요<br>
                </div>
            </section>

            <section id="teamImage-area">
                <div>
                    <img src="/resources/img/clientService/고객지원2.jpg" alt="여행자 사진">
                </div>
            </section>

            <section id="noticeArea">
                <section>

                    <section id="noticeBox">

                        <section id="noticeBox-t">
                            <p>공지사항</p>
                            <div></div>
                            <section id="noticeBtnSec">
                                <a href="/notice/noticeList">
                                    <button class="fa-solid fa-plus"></button>
                                </a>
                            </section>
                        </section>

                        <section id="noticeBox-b">
                            <p>9/27(수) 홈페이지 개편 안내</p>
                            <div></div>
                            <p>23. 09. 27</p>
                        </section>

                    </section>

                </section>
            </section>

            <section id="FAQ-area">

                <div id="FAQ-box">

                    <div>자주 묻는 질문 (FAQ)</div>

                    <hr>
                    <div>
                        <br>
                        &nbsp; Q : 아이디가 기억나지 않아요. <br>
                        &nbsp; A : 로그인 페이지에서 아이디 찾기를 누른 후 재설정 하면 됩니다. <br>
                        <br>
                        &nbsp; Q : 비밀번호가 기억나지 않아요. <br>
                        &nbsp; A : 로그인 페이지에서 비밀번호 찾기를 누른 후 재설정 하면 됩니다. <br>
                        <br>
                        &nbsp; Q : 닉네임을 바꾸고 싶어요 <br>
                        &nbsp; A : 마이 페이지 - 프로필 관리 - 프로필 사진 재설정 순으로 <br>
                        &nbsp; &nbsp; &nbsp; 진행하시면 됩니다.<br>
                        <br>
                        &nbsp; Q : 회원탈퇴를 하고싶어요 <br>
                        &nbsp; A : 마이 페이지 - 프로필 관리 - 회원탈퇴 순으로 진행하시면 됩니다. <br>
                        <br>
                        &nbsp; Q : 문의는 어떻게 하나요? <br>
                        &nbsp; A : 마이 페이지 - 1:1문의에서 문의내용 작성 후 문의 내용 등록<br>
                        &nbsp; &nbsp; &nbsp; 버튼을 누르면 관리자 확인 후 답변을 남겨드립니다.
                        <br><br>
                    </div>

                </div>

            </section>

            <form>
                <section id="ask-area">
    
                    <div id="ask-box">
    
                        <section>1:1 문의</section>
    
                        <section>
    
                            <section id="ask-title-boxes">
                                <div>분류</div>
                                <div>이메일</div>
                                <div>휴대폰</div>
                                <div>제목</div>
                            </section>
    
                            <section id="ask-title-answers">
                                <select id="classificationSelect">
                                    <option selected>== 선택 ==</option>
                                    <option value="securityAsk">보안 문의</option>
                                    <option value="limitAsk">이용 제한 문의</option>
                                    <option value="accountAsk">계정 문의</option>
                                    <option value="declarationAsk">불건전한 이용자 신고</option>
                                    <option value="etcAsk">기타</option>
                                </select>
                                <input name="inputEmail">
                                <input name="inputPhone">
                                <input name="inputTitle">
                            </section>
    
                        </section>
    
                        <section>
                            <textarea name="inputAsk" placeholder="문의 내용을 작성해주세요." id="askText"></textarea>
                        </section>
    
                        <section>
                            <button>문의 내용 등록</button>
                        </section>
    
                    </div>   
    
                </section>
            </form>

        </main>
    </section>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://kit.fontawesome.com/27d1f811dc.js" crossorigin="anonymous"></script>
</body>
</html>